package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage 
{

	public RegisterPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']")WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")WebElement txttele;
	@FindBy(xpath="//input[@id='input-password']")WebElement txtpwd;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement txtpwdconfirm;
	@FindBy(xpath="//input[@name='agree']")WebElement chkagree;
	@FindBy(xpath="//input[@value='Continue']")WebElement btnsubmit;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgconfirmation;

	
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmailid(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void settelephone(String tel)
	{
		txttele.sendKeys(tel);
	}

	public void setpassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}

	public void setconfmpassword(String pwd)
	{
		txtpwdconfirm.sendKeys(pwd);
	}
	
	public void clickprivcypolicy()
	{
		chkagree.click();
	}
	
	public void clicksubmit()
	{
		btnsubmit.click();
	}
  
	public String getConfirmation() 
	{

	    try {
	    	
	        return msgconfirmation.getText();
	        } 
	    catch (Exception e) 
	    {
	        System.out.println("Confirmation message is not displayed: " + e.getMessage());
	        return "";
	    }
	}

}
