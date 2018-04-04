package com.unityworks.utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.unityworks.core.CoreClass;
import com.unityworks.pages.MethodClass;

public class Util extends CoreClass {

   WebDriverWait wait = null;
   MethodClass M = new MethodClass();
   
   public Util()
   {
	   wait = new WebDriverWait(driver, 60);
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
	
}
