package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {

	public Loginpage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-email']")WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")WebElement btnlogin;
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}

	
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	
	public void clicklogin()
	{
		btnlogin.click();
	}

	
	

}
