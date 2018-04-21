package com.unityworks.utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.unityworks.core.CoreClass;
import com.unityworks.pages.MethodClass;

public class Util extends CoreClass {

  public WebDriverWait wait = null;
   MethodClass M = new MethodClass();
   
   public Util()
   {
	   wait = new WebDriverWait(driver, 600);
   }
   
  
   
   public static void delay()
	{
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void Wait_forSubCategory()
	
	{
		wait.until(ExpectedConditions.visibilityOf(M.wrapper));	
	}
	
	
	public void Wait_invisibleWrapper()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(M.Bywrapper));
		
	}
	
	public void Wait_InvisibleLoader()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(M.loader));
		
	}
	
	
	public void Wait_TillPageView()
	
	{
		wait.until(ExpectedConditions
				.presenceOfElementLocated(M.pageview));
		
		
	}
	
	
	@DataProvider
	public static Object[][] getdata()
	{
	
		int rowNum =excel.getRowCount("TestData");
		//System.out.println(rowNum);
		int colcount = excel.getColumnCount("TestData");
		//System.out.println(colcount);
		Object[][] data = new Object[rowNum-1][colcount];
		for(int i=2;i<=rowNum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-2][j] = excel.getCellData("TestData", j, i);
				//System.out.println(data[i-2][j]);
				
			}
		}
		return data;
		
		}
	
	@DataProvider
	public static Object[][] NewReportGetData()
	{
	
		int rowNum =excel.getRowCount("NewReportTestData");
		//System.out.println(rowNum);
		int colcount = excel.getColumnCount("NewReportTestData");
		//System.out.println(colcount);
		Object[][] data = new Object[rowNum-1][colcount];
		for(int i=2;i<=rowNum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-2][j] = excel.getCellData("NewReportTestData", j, i);
				//System.out.println(data[i-2][j]);
				
			}
		}
		return data;
		
		}
	
	
	
	@DataProvider
	public static Object[][] DoubleClickReportGetData()
	{
	
		int rowNum =excel.getRowCount("DoubleClickReportTestData");
		//System.out.println(rowNum);
		int colcount = excel.getColumnCount("DoubleClickReportTestData");
		//System.out.println(colcount);
		Object[][] data = new Object[rowNum-1][colcount];
		for(int i=2;i<=rowNum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-2][j] = excel.getCellData("DoubleClickReportTestData", j, i);
				//System.out.println(data[i-2][j]);
				
			}
		}
		return data;
		
		}
	
	
	
}
