package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@title='My Account']")WebElement lnkmyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")WebElement lnkregister;
	@FindBy(xpath="//a[normalize-space()='Login']")WebElement lnkLogin;

	
	
	
	public void clickmyaccount()
	{
		lnkmyaccount.click();
	}

	public void clickregister()
	{
		lnkregister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}

}
