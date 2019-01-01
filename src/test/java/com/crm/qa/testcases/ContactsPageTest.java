package com.crm.qa.testcases;
//author
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
String sheetName = "contacts";
	
	public ContactsPageTest() {
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
	testutil.switchToFrame();
	homepage.clickOnContactsLinks();
	
}

@Test
public void verifyContactsPageLabel()
{
	Assert.assertTrue(contactspage.verifyContactsLabel());
	
}
@Test
public void selectContactsByName()
{
	
	contactspage.selectContacts("testing swati");
	
	 
}
@Test
public void selectMultipleContactsList()
{
	contactspage.selectContacts("testing swati");
	contactspage.selectContacts("navi test");
}

@DataProvider
public Object[][] getCRMTestData()
{
	Object data [][]=testutil.getTestData(sheetName)	;
	return data;
	
}
@Test(dataProvider="getCRMTestData")
public void validateCreteNewContact(String title,String firstname,String lastname,String company)
{
	homepage.clickOnNewContact();
	//contactspage.createNewContact("Mr.", "rame", "sharma", "google");
	contactspage.createNewContact(title,firstname,lastname,company);
	
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}


}
