package testBase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PagesObjects.HomePage;
import PagesObjects.Loginpage;
import PagesObjects.MyAccountPage;
import utilities.DataProviders;

public class TC002_LoginTestDDT extends BaseClass
{
	@Test(dataProvider = "LoginData",
	        dataProviderClass = DataProviders.class,groups="Datadriven")
	public void VerifyLoginDDT(String email,String pwd,String res)
	{
		logger.info(" Start-VerifyLoginDDT");
		
		HomePage hp= new HomePage(driver);
		hp.clickmyaccount();
		hp.clickLogin();
		
		Loginpage lp=new Loginpage(driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clicklogin();
		
		MyAccountPage ma=new MyAccountPage(driver);
		 Boolean targetstatus=ma.isMyaccountExist();
		 
		 //if valid=login sucess-logout-Pass & Invalid=Login unsuccess-Fail
		 
		//if Invalid=login sucess-logout-F & Invalid=Login unsuccess-P
		 
		 if (res.equalsIgnoreCase("valid")) 
		 {

			    if (targetstatus == true) 
			    {

			        ma.clicklogout();
			        Assert.assertTrue(true);

			    } else 
			    {

			        Assert.fail();
			    }

			}
			else if (res.equalsIgnoreCase("Invalid")) 
			{

			    if (targetstatus == true) 
			    {

			        ma.clicklogout();
			        Assert.assertTrue(false);

			    } else 
			    {

			        Assert.assertTrue(true);
			    }
			}
		 
		 logger.info("Finished - VerifyLoginDDT");
		 
		 
		}
	
}

