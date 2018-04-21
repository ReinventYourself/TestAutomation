package com.unityworks.testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	
	/*@Test(dataProvider = "getdata",dataProviderClass =Util.class)
	public void unityworksReportTest(String Category, String SubCategory, 
			String ReportTitle, String PageView, String ExecutionStatus) throws InterruptedException

	{ extentTest = extent.startTest(Category+"-"+SubCategory);	
		if(ExecutionStatus.equals("Yes"))
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
	   // util.Wait_TillPageView();
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
		}*/

	
	
	@Test(dataProvider = "NewReportGetData",dataProviderClass =Util.class)
	public void verifyPageViewandReportTitle(String StartDate, String EndDate,String Category, String SubCategory, 
			String ReportTitle, String PageView, String ExpectedReportTitle, String ExpectedPageViewCount,
			String ExecutionStatus) throws InterruptedException
	{
		extentTest = extent.startTest(Category+"-"+SubCategory);
		if(ExecutionStatus.equalsIgnoreCase("Yes"))
		{
		Method.stagelogin();
		log.debug("Stage Login Successful");
		util.Wait_InvisibleLoader();
		Method.EnterDate1(StartDate, EndDate);
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

		String ReportName = (driver.findElement(By.xpath(ReportTitle))).getText();
		String PageviewCount = (driver.findElement(By.xpath(PageView))).getText();
		
		Assert.assertEquals(ReportName, ExpectedReportTitle);
		assertEquals(PageviewCount,ExpectedPageViewCount);
		
		}
		
		else 
		{
			throw new SkipException("Skipping this exception");
			
		}
		
	}
	
	
	@Test(dataProvider = "DoubleClickReportGetData",dataProviderClass =Util.class)
	public void doubleclickreportTest(String StartDate, String EndDate, String Category, String SubCategory,
			String RadioButton, String BCSelect, String ProgramSelect, String CustomSelect, 
			String ApplyManagementFee, String ApplyContentCreationFee, String RestrictCampaignStartDate, 
			String TypeDropDown,String ReportTitle, String PageView, 
			String ExpectedReportTitle, String ExpectedPageViewCount,
			String ExecutionStatus ) throws InterruptedException
	
	{
		
		extentTest = extent.startTest(Category+"-"+SubCategory);
      
		
	   if(ExecutionStatus.equalsIgnoreCase("Yes"))
	   {
		
	    Method.stagelogin();
	    Method.AddScheduleReportBtn.isDisplayed();
		log.debug("Stage Login Successful");
		util.Wait_InvisibleLoader();
		Method.EnterDate1(StartDate, EndDate);
		log.debug("Date has been entered successfully");
		Method.SelectFormDropdown(Category);
		log.debug("Category has been selected successfully");
		util.Wait_InvisibleLoader();
		Util.delay();
		Method.SelectFromSubDropdown(SubCategory);
		log.debug("SubCategory has been selected successfully");
		Util.delay();
		Method.SelectRadioBtn(RadioButton);
		Method.SelectDropDownBasedOnRadiobtn(RadioButton, BCSelect,ProgramSelect, CustomSelect);
		Method.SelectApplyMgtFee(ApplyManagementFee);
		Method.SelectApplyCCFee(ApplyContentCreationFee);
		Method.SelectResCMPStartDate(RestrictCampaignStartDate);
		Method.SelectReporttype(TypeDropDown);
		Method.clickondisplayBtn();
		util.wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(PageView)));
		String ReportName = (driver.findElement(By.xpath(ReportTitle))).getText();
		String PageviewCount = (driver.findElement(By.xpath(PageView))).getText();
		
		Assert.assertEquals(ReportName, ExpectedReportTitle);
		
		if(TypeDropDown.equalsIgnoreCase("Report"))
		assertEquals(PageviewCount,ExpectedPageViewCount);
		} else 
     {
    	 throw new SkipException("Skipping this exception");
     }
	
     }
	
	
}
