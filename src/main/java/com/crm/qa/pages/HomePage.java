package com.crm.qa.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	

	@FindBy(xpath="//td[contains(text(),'User: swati sharma')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	//"//a[@title='New Contact')"
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
public String verifyHomePageTitle()
{
	return driver.getTitle();
}

public boolean verifyCorrectUserName()
{
	return userNameLabel.isDisplayed();
}
public ContactsPage clickOnContactsLinks()
{
contactLink.click();
return new ContactsPage();
}

public DealsPage clickOnDealsPage()
{
	dealsLink.click();
	return new DealsPage();
	
}

public TasksPage clickOnTasksLink()
{
	taskLink.click();
	return new TasksPage();
}

public void clickOnNewContact()
{
	Actions act = new Actions(driver);
	act.moveToElement(contactLink).build().perform();
	newContact.click();	
}
}
