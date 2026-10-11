package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PagesObjects.HomePage;
import PagesObjects.RegisterPage;

public class TC001_AccountregistrationTest extends BaseClass
{
	
	
	@Test(groups="Regression")
	void Verifyaccountregistration()
	{
		logger.info("**********Starting TC001_AccountregistrationTest*****");
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		logger.info("**********Click on myaccount link*****");

		hp.clickregister();
		logger.info("**********Click on register link*****");

		logger.info("**********Form element Locator start*****");

		RegisterPage respage=new RegisterPage(driver);
		respage.setFirstName(randomeString());
		respage.setLastName(randomeString());
		respage.setEmailid(randomeString()+"@gmail.com");
		respage.settelephone(randomeNumber());
		String password=randomealphaNumber();
		
		respage.setpassword(password);
		respage.setconfmpassword(password);
		respage.clickprivcypolicy();
		respage.clicksubmit();
		
		logger.info("**********Fecting element Locator Finished*****");

		
		String confirm=respage.getConfirmation();
		Assert.assertEquals(confirm, "Your Account Has Been Created!");
		
		logger.info("**********Validation of confirmation message*****");
		
		logger.info("**********Finished TC001_AccountregistrationTest *****");


	
	}
	
	
	

}
