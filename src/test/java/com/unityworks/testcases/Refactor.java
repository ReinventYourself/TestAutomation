package com.unityworks.testcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.unityworks.core.CoreClass;
import com.unityworks.pages.MethodClass;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import net.lightbody.bmp.proxy.CaptureType;

public class Refactor  {
	
	String driverPath = "F:\\JavaWithSelenium\\UnityworksReportTest\\src\\main\\resources\\";
	String sFileName = "F:/SeleniumEasy.har";
	
	public WebDriver driver;
	public BrowserMobProxy proxy;
	MethodClass Method = new MethodClass();
	
	@BeforeTest
	public void setUp() {
			
	   // start the proxy
	    proxy = new BrowserMobProxyServer();
	    proxy.start(0);
      //proxy.blacklistRequests("http://www.google-analytics.com/r/__utm.gif", 404);  

	    //get the Selenium proxy object - org.openqa.selenium.Proxy;
	    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
	     

	    // configure it as a desired capability
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		
	    //set chromedriver system property
		//System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		//driver = new ChromeDriver(capabilities);
		driver = new FirefoxDriver(capabilities);
		
	    // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
	    /*proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,
	    		CaptureType.REQUEST_BINARY_CONTENT,CaptureType.REQUEST_HEADERS, 
	    		CaptureType.REQUEST_COOKIES, 
	    		CaptureType.RESPONSE_CONTENT, CaptureType.RESPONSE_BINARY_CONTENT, 
	    		CaptureType.RESPONSE_HEADERS, CaptureType.RESPONSE_COOKIES);*/
		
	   proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT);
	   
	   
	    // create a new HAR with the label "Unityworks.com"
	    proxy.newHar("UnityWorks.com");	 
        
	}
	
	@Test
	public void ValidateCampaign() throws InterruptedException
	{
		/*driver.get("http://uwmedia.us/includes/login-form.php?ref=/campaign_manager/");
		driver.findElement(By.xpath("//input[@id ='login']")).sendKeys("jkumar");
		driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("test123");;
		driver.findElement(By.xpath("//input[@type ='submit']")).click();
		//Method.LogoImg.isDisplayed();
		//Method.CmpMngText.isDisplayed();
		driver.findElement(By.xpath("//div[contains(text(),'Affinitiv BMW')]")).click();
		driver.findElement(By.xpath("//a[@title='http://uwmedia.us/affinitiv_videoPlayerAndCoupons/bmw/front/?CustomerID=23696242&RecordID=563057&Channel=PR']")).click();
        Thread.sleep(10000);*/
		driver.get("http://uwmedia.us/affinitiv_videoPlayerAndCoupons/bmw/front/?CustomerID=23696242&RecordID=563057&Channel=PR");
		
        }
	 
	@AfterTest
	public void tearDown() {

		// get the HAR data
		Har har = proxy.getHar();

		// Write HAR Data in a File
		File harFile = new File(sFileName);
		try {
			har.writeTo(harFile);
		} catch (IOException ex) {
			 System.out.println (ex.toString());
		     System.out.println("Could not find file " + sFileName);
		}
		
		if (driver != null) {
			proxy.stop();
		//	driver.quit();
		}
	}
}