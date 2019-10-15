package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;

public class TestBase {
	
	private static final String BREAK_LINE = null;
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger logger = null;
	
	public TestBase()  {
		try {
		prop = new Properties();
		FileInputStream fi = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SwatiInterview\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		
		prop.load(fi);
		}
		catch(FileNotFoundException e) {
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void 	intialization() {
	String browsername =	prop.getProperty("browser");
	if (browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if (browsername.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	 public static void reportLog(String message) {
		  //  message = BREAK_LINE + message;
		    
			logger.info("Message: " + message);
		    Reporter.log(message);
		}
}
