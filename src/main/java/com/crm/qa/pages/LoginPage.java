package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;

public class LoginPage extends TestBase {
	
	//PageFactory or OR
	
	@FindBy(name ="username")
    WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initialization the page Objects :
	//LoginTestSwati() -- this is consturctor of class.
	//PageFactory -- this is already created class.
	//initElements -- method
	//this -- refer to current class objects
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateLoginPageTitile()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()
	{
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un ,String pd)
	{
		username.sendKeys(un);
		password.sendKeys(pd);
	//	loginBtn.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
    	
    	
		return new HomePage();
		
	}

}
