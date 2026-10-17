package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchpage extends BasePage
{

	public Searchpage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")WebElement Searchpdt;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")WebElement btnsearch;

	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iPhone')]")WebElement productname;
	
	@FindBy(xpath="//p[@class='price']")WebElement productprice;
	
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")WebElement addcart;
	
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")WebElement Confmess;

	
	

	
	


    
	public void Setproductname(String prname)
	{
		Searchpdt.sendKeys(prname);
	}
	
	public void clicksearchbtn()
	{
		btnsearch.click();
	}
	
	public String validateprodutlist()
	{
		
try {
	    	
	        return productname.getText();
	        } 
	    catch (Exception e) 
	    {
	        System.out.println("Confirmation message is not displayed: " + e.getMessage());
	        return "";
	    }
	}

}
