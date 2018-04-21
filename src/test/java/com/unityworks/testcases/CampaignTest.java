package com.unityworks.testcases;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.unityworks.core.CoreClass;
import com.unityworks.pages.MethodClass;
import com.unityworks.utils.PageLoad;
import com.unityworks.utils.Util;

public class CampaignTest extends CoreClass {
    MethodClass Method;
	PageLoad Load;
	Util util = null;
	
	
	public CampaignTest()
	{
	super();	
		
	}
	
	@BeforeTest
	public void setup() {
        
		Method = new MethodClass();
		Load = new PageLoad();
	    util =  new Util();
	    
	    
	}
	
	@Test
	public void ValidateCampaign()
	
	{   extentTest = extent.startTest("CampaignTest");
		Method.CampaignLogin();
		Method.ClickOnAffinitiveBMW();
		driver.findElement(By.xpath("//a[@title='http://uwmedia.us/affinitiv_videoPlayerAndCoupons/bmw/front/?CustomerID=23696242&RecordID=563057&Channel=PR']")).click();
	    //Method.analyzeLog();
	
	}
		

	
	
	
}
