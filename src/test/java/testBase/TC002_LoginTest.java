package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PagesObjects.HomePage;
import PagesObjects.Loginpage;
import PagesObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

    @Test(groups = "Sanity")
    public void VerifyLogin() {
        logger.info("Starting TC002_LoginTest");

        HomePage homePage = new HomePage(driver);
        homePage.clickmyaccount();
        homePage.clickLogin();

        Loginpage loginPage = new Loginpage(driver);
        loginPage.setemail("sunilpal237@gmail.com");
        loginPage.setpassword("Sunil@44667");
        loginPage.clicklogin();

        MyAccountPage accountPage = new MyAccountPage(driver);
        boolean status = accountPage.isMyaccountExist();

        // Change remark: assert the observed login result instead of always passing.
        Assert.assertTrue(status, "Login failed: My Account page was not displayed");

        // Change remark: no try/catch is needed; TestNG reports Selenium exceptions directly.
        logger.info("Finished TC002_LoginTest");
    }
}
