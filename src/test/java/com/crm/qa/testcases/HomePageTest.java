
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public HomePageTest(){
		
		//super class constructor to call the super class methods in testbase class,so that my properties will be intialized.
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intialization();
		loginpage =  new LoginPage();
		contactspage = new ContactsPage();
		testutil= new TestUtil();
	//	homepage = new HomePage(;)
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=3)
	public void clickOnContactListTest(){
		testutil.switchToFrame();
		contactspage =	homepage.clickOnContactsLinks();	
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		//Thread.sleep(2000);
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
