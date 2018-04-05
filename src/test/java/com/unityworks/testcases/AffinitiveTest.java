package com.unityworks.testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.unityworks.core.CoreClass;
import com.unityworks.pages.MethodClass;
import com.unityworks.utils.PageLoad;
import com.unityworks.utils.Util;

public class AffinitiveTest extends CoreClass {

	MethodClass Method;
	PageLoad Load;
	Util util = null;
		
	public AffinitiveTest()
	{
		super();
		
	}
	
	
	@BeforeTest
	public void setup() {

		
		Method = new MethodClass();
		Load = new PageLoad();
	    util =  new Util();
	    
	}
	
	@Test(dataProvider = "getdata",dataProviderClass =Util.class)
	public void unityworksReportTest(String Category, String SubCategory, 
			String ReportTitle, String PageView, String ExecutionSatus) throws InterruptedException

	{ extentTest = extent.startTest(Category+"-"+SubCategory);	
		if(ExecutionSatus.equals("Yes"))
			{
         Method.stagelogin();
		log.debug("Stage Login Successful");
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		log.debug("Date has been entered successfully");
		Method.SelectFormDropdown(Category);
		log.debug("Category has been selected successfully");
		util.Wait_InvisibleLoader();
		Util.delay();
		Method.SelectFromSubDropdown(SubCategory);
		log.debug("SubCategory has been selected successfully");
		Util.delay();
		Method.clickondisplayBtn();
		log.debug("Click on display button");
		
		util.wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(PageView)));
	    util.Wait_TillPageView();
        WebElement stageelement2 = driver.findElement(By.xpath(ReportTitle));
		WebElement stageelement1 = driver.findElement(By.xpath(PageView));
		log.debug("Page view has been Added into the list");
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		log.debug("Prod Login Successful");
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		log.debug("Date has been entered successfully");
		Method.SelectFormDropdown(Category);
		log.debug("Category has been selected successfully");
		util.Wait_InvisibleLoader();
		Util.delay();
	    Method.SelectFromSubDropdown(SubCategory);
	    log.debug("SubCategory has been selected successfully");
	    Util.delay();
	    Method.clickondisplayBtn();
	    log.debug("Click on display button");
	    util.wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(PageView)));
	    
		//util.Wait_TillPageView();
		String prodelement2 = (driver.findElement(By.xpath(ReportTitle))).getText();
		String prodelement1 = (driver.findElement(By.xpath(PageView))).getText();
	    System.out.println("Grand total of "+Category+">"+SubCategory+"=" + prodelement1);
        assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);
		log.debug("Test Executed Successfully");
			}
		
		else 
		{
			throw new SkipException("Skipping this exception");
		}
		}

	
	
	
}
