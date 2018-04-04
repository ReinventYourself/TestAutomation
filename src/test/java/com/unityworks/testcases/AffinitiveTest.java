package com.unityworks.testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.unityworks.core.CoreClass;
import com.unityworks.pages.MethodClass;
import com.unityworks.utils.PageLoad;
import com.unityworks.utils.Util;

public class AffinitiveTest extends CoreClass {

	MethodClass Method;
	PageLoad Load;
	Util util = null;
	WebDriverWait wait = null;
	
	public AffinitiveTest()
	{
		super();
		
	}
	
	
	@BeforeTest
	public void setup() {

		//initialize();
		Method = new MethodClass();
		Load = new PageLoad();
	    util =  new Util();

	}
	
	@Test
	public void affinitive_BMWAffinitiveTire() throws InterruptedException

	{
		extentTest = extent.startTest("affinitive_BMWAffinitiveTire");	
		Method.stagelogin();
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 17));
		util.Wait_InvisibleLoader();
		Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 17));
	    Thread.sleep(1000);
		Method.clickondisplayBtn();
	    
	    util.Wait_TillPageView();
		WebElement stageelement1 = driver.findElement(Method.pageview);
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Bmw Affinitiv Tire']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 17));
		util.Wait_InvisibleLoader();
	    Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 17));
	    Thread.sleep(1000);
	    Method.clickondisplayBtn();
		util.Wait_TillPageView();
		String prodelement1 = driver.findElement(Method.pageview).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Bmw Affinitiv Tire']")).getText();
		System.out.println("Grand total of Affinitive>BMWAffinitiveTire=" + prodelement1);
        assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);
		}

	
	
	
}
