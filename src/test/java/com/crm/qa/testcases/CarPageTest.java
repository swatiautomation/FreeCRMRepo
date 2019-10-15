package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.utils.Reader;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CarPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class CarPageTest extends TestBase {
	Logger logger;
	
	CarPage carpage;

	public CarPageTest(){
		
		//super class constructor to call the super class methods in testbase class,so that my properties will be intialized.
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		intialization();
		 carpage = new CarPage();
		
	}
	
	@Test(priority=1)
	public void verifySearchPageUrlTest()
	{
		  
		Reporter.log("verify url search/car/", true);	
		String title=carpage.verifySearchPageUrl(prop.getProperty("postcode"));
		Assert.assertEquals(title, "https://www.motors.co.uk/search/car/");
		Reporter.log(title.toString());
		
	}
	
	@Test(priority=2)
	public void verifyResultCountPerPageTest()
	{
		Reporter.log("output results page count", true);
		carpage.verifySearchPageUrl(prop.getProperty("postcode"));
		String countperpage=carpage.verifyResultCountPerPage();
		Reporter.log(countperpage.toString());
	}
	

	@Test(priority=3)
	public void applyFilterTest() throws InterruptedException
	{
		Reporter.log("Apply a model filter of Galaxy and output results page count");
		carpage.verifySearchPageUrl(prop.getProperty("postcode"));
		String totalresultcountforaudi=	carpage.applyFilter();
		Reporter.log(totalresultcountforaudi.toString());
	}

	@Test(priority=4)
	public void verifyTitleAndVariantTest() throws InterruptedException
	{
		//Reporter.log("Vehical Title :");
		carpage.verifySearchPageUrl(prop.getProperty("postcode"));
		carpage.applyFilter();
		carpage.verifyTitleAndVariant();
	}
	
	@Test(priority=5)
	public void vehicalDistanceTest()
	{
		Reporter.log("Verify output vehicle distance from postcode OX144RY");
		carpage.verifySearchPageUrl(prop.getProperty("postcode"));
		String vehicaldistance=carpage.vehicalDistance();
		
		Assert.assertEquals(vehicaldistance, "3 miles away");
		Reporter.log(vehicaldistance.toString());
	}
	
	
	@AfterMethod	
	public void tearDown(){
		driver.quit();
	}
	

}
