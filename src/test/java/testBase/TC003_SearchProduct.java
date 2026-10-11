package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PagesObjects.Searchpage;

public class TC003_SearchProduct extends BaseClass 
{
	@Test
	public void VerifyProduct()
	{
		logger.info("Start TC003_SearchProduct");
		try {
		
			TC002_LoginTest logintest=new TC002_LoginTest();
			logintest.VerifyLogin();
			
		Searchpage sp=new Searchpage(driver);
		sp.Setproductname(p.getProperty("ProductName"));
		
		sp.clicksearchbtn();
		
		String Expectedprodut=sp.validateprodutlist();
		
		Assert.assertEquals(Expectedprodut, p.getProperty("ProductName"));
		}
		catch (Exception e)
		{
			Assert.fail();;
		}
	
		
		logger.info("Finished TC003_SearchProduct");
		
	}

}
