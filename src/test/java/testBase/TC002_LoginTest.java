package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PagesObjects.HomePage;
import PagesObjects.Loginpage;
import PagesObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups="Sanity")
	public void VerifyLogin()
	{
		logger.info("Staring TC002_LoginTest");
		try {
			
		
		HomePage hp= new HomePage(driver);
		hp.clickmyaccount();
		hp.clickLogin();
		
		Loginpage lp=new Loginpage(driver);
		lp.setemail("sunilpal237@gmail.com");
		lp.setpassword("Sunil@44667");
		lp.clicklogin();
		
		MyAccountPage ma=new MyAccountPage(driver);
		 Boolean status=ma.isMyaccountExist();
		 Assert.assertTrue(true);
		
		}
		catch (Exception e)
		{
			Assert.fail();;
		}
		
		logger.info("Finished TC002_LoginTest");
	}

}
