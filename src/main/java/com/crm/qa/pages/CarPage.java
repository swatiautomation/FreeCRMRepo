package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.crm.qa.base.TestBase;

public class CarPage extends TestBase
{
	@FindBy(xpath="//input[@name='PostCode']")
	@CacheLookup
	WebElement postCode;
	
	@FindBy(xpath="//select[@id='Make']")
	WebElement dropDown;
	
	@FindBy(xpath="//button[@class='btn sp__btn']")
	WebElement searchButton;
	
	@FindBy(className="r__cta")
	List<WebElement> mainClass;
	
	@FindBy(xpath="//span[@class='pgn__text']/span")
	WebElement pagecount;
	
	@FindBy(xpath="//footer[@class='sp2__cta']/div[1]")
	WebElement fulldetaillink;
	
	@FindBy(xpath="//section[@class='root-panel']/button[1]")
	WebElement makebutton;
	
	@FindBy(xpath="//section[@class='mm']/header/following-sibling::ul/li[2]/button")
	WebElement modelbutton;
	
	@FindBy(xpath="//div[@class='drawer active']/ul/li/button[@id='Models_Galaxy']")
	WebElement galaxymodel;
	
	@FindBy(xpath="//div[@class='filter-list__wrap']/input")
	WebElement inputbox;
	
	@FindBy(xpath="//ul[@class='filter-list__content']/li/button")
	WebElement searchbutton;
	
	@FindBy(xpath="//span[@class='pgn__text']/span")
	WebElement totalcountofaudi;
	
	@FindBy(xpath="//section[@class='sr']/div[2]/div[2]")
	WebElement firstproduct;
	
	@FindBy(xpath="//section[@class='sr']/div[2]/div[2]/a/h3")
WebElement firstproductitlename;
	
	
	@FindBy(xpath="//section[@class='sr']/div[2]/div[2]/div/img")
WebElement firstproductimage;
	
	@FindBy(xpath="//section[@class='sr']/div[2]/div[2]/div[2]//div[2]/div/p/span")
WebElement firstproductdistance;
	
	@FindBy(xpath="//section[@class='sr']/div[2]/div[2]/ul")	
	List<WebElement> firstproductspecitems;
	
	@FindBy(xpath="//div[@class='super__inner']/div[1]/footer/div/a")
	WebElement firstproductfooterdetails;
	
	@FindBy(xpath="//section[@class='sr']/div[2]/div[2]/a")
	WebElement firstproductmainpage;
	
	@FindBy(xpath="//header[@class='vdp-header vdp-header-lrg grid-area']/div/div[1]/div/h1")
	WebElement firstproductheadertitle;
	
	@FindBy(xpath="//header[@class='vdp-header vdp-header-lrg grid-area']/div/div[1]/div/p")
	WebElement firstproductvariant;
	
	@FindBy(xpath="//section[@class='sr']/div[2]/div[2]/div[2]/div[2]/div/p/span")
	WebElement distancevariant;
	
	@FindBy(xpath="//button[@title='Reset Search']")
	WebElement restbutton;
	
	
	@FindBy(xpath="//div[@class='count']")
	WebElement totalresultFord;
	
	public String name;
	
	public CarPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifySearchPageUrl(String keyword)
	{
		postCode.sendKeys(keyword);	
		Select select = new Select(dropDown);
		select.selectByVisibleText(prop.getProperty("dropdowntext"));
		searchButton.click();
		return driver.getCurrentUrl();
		
	}
	
	public String verifyResultCountPerPage()
	{		
		String totalresultforford=totalresultFord.getText();
		return totalresultforford;
	
	}
	
	public String verifytotalresultspageCount()
	{
		String totalproductperpage=pagecount.getText();
		return totalproductperpage;
	}
	
	public String applyFilter() throws InterruptedException
	{
		Thread.sleep(3000);

		makebutton.click();
		Thread.sleep(3000);
		modelbutton.click();
		Thread.sleep(3000);
	
		galaxymodel.click();
		Thread.sleep(3000);
	
	String resultgalaxy=	totalresultFord.getText();
	return resultgalaxy;
		
		
		
	}
	
	public void verifyTitleAndVariant()
	{
		firstproductmainpage.click();
		Reporter.log("Vehical Title :");
		String title=	firstproductheadertitle.getText();
		Reporter.log(title.toString());
		Reporter.log("Vehical Variant :");
		String var=	firstproductvariant.getText();
		Reporter.log(var.toString());
		
	}
	
	public String vehicalDistance()
	{
	String variant=	distancevariant.getText();	
	return variant;
	}
	
	

}
