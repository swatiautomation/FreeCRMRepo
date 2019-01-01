package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTestSwati extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTestSwati()
	{
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		
		 loginpage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitle()
	{
	String title=	loginpage.validateLoginPageTitile();
	Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		
	}
	
	@Test(priority=2)
	public void logoValidate()
	{
		boolean a = loginpage.validateCRMLogo();
		Assert.assertTrue(a);
	}
	
	@Test(priority=3)
	public void login()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
