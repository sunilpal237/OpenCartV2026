package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{

    protected static WebDriver driver;
    public Properties p;

    // Logger initialized immediately
    protected Logger logger = LogManager.getLogger(this.getClass());

    @Parameters({"browser","OS"})
    @BeforeClass
    public void setup(String br, String os) throws IOException 
    {

        try (FileReader file =
                new FileReader("./src/test/resources/config.properties")) {
            p = new Properties();
            p.load(file);
        }

        String env = p.getProperty("execute_env");

        if (env == null || br == null || os == null) {
            throw new IllegalArgumentException(
                    "execute_env, browser and OS must be configured.");
        }

        br = br.trim().toLowerCase();
        env = env.trim();

        if (env.equalsIgnoreCase("Local")) {

            switch (br) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Unsupported browser: " + br);
            }

        } else if (env.equalsIgnoreCase("Remote")) {

            String gridURL = p.getProperty("gridURL");

            if (gridURL == null || gridURL.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "gridURL is missing in config.properties");
            }

            switch (br) {
                case "chrome":
                    driver = new RemoteWebDriver(
                            new URL(gridURL), new ChromeOptions());
                    break;

                case "edge":
                    driver = new RemoteWebDriver(
                            new URL(gridURL), new EdgeOptions());
                    break;

                case "firefox":
                    driver = new RemoteWebDriver(
                            new URL(gridURL), new FirefoxOptions());
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Unsupported remote browser: " + br);
            }

        } else {
            throw new IllegalArgumentException(
                    "Unsupported execution environment: " + env);
        }

        logger.info("Browser started: " + br);
        logger.info("Execution environment: " + env);
        logger.info("Execution Windows: " +os);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(p.getProperty("URL"));

        logger.info("Application URL loaded");
    


        driver.manage().deleteAllCookies();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get(p.getProperty("URL"));

        logger.info("*** URL loaded ***");
    }

    @AfterClass(groups = {"Sanity", "Regression", "Datadriven"})
    public void teardown() {

        if (driver != null) {
            driver.quit();
            logger.info("*** Browser closed ***");
        }
    }

    public String randomeString() {

        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomeNumber() {

        return RandomStringUtils.randomNumeric(10);
    }

    public String randomealphaNumber() 
    {

        String generatedstring =
                RandomStringUtils.randomAlphabetic(3);

        String generatednumber =
                RandomStringUtils.randomNumeric(3);

        return generatedstring + generatednumber;
    }
    
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}