package com.unityworks.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.unityworks.core.CoreClass;
import com.unityworks.pages.MethodClass;
import com.unityworks.utils.PageLoad;
import com.unityworks.utils.Util;

import junit.framework.Assert;

public class ReportTest extends CoreClass {

	MethodClass Method;
	PageLoad Load;
	Util util = null;
	WebDriverWait wait = null;

	public ReportTest() {

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
	public void epsilon_BMWAirBagRecall() throws InterruptedException

	{
		extentTest = extent.startTest("epsilon_BMWAirBagRecall");	
		Method.stagelogin();
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 2));
		util.Wait_InvisibleLoader();
		util.Wait_forSubCategory();
	    Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 2));
	    util.Wait_invisibleWrapper();
	    Method.clickondisplayBtn();
	    util.Wait_TillPageView();
		WebElement stageelement1 = driver.findElement(Method.pageview);
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='BMW Airbag Recall']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 2));
		util.Wait_InvisibleLoader();
		util.Wait_forSubCategory();
		Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 2));
	    util.Wait_invisibleWrapper();
		Method.clickondisplayBtn();
		util.Wait_TillPageView();
		String prodelement1 = driver.findElement(Method.pageview).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='BMW Airbag Recall']")).getText();
		System.out.println("Grand total of Epsilon>Airbag>Page View=" + prodelement1);
        assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);
		}

	@Test
	public void epsilon_2014SalesTouchesRound1() throws InterruptedException {

		extentTest = extent.startTest("epsilon_2014SalesTouchesRound1");	
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 3));
		util.Wait_InvisibleLoader();
        wait.until(ExpectedConditions.visibilityOf(Method.wrapper));
		Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 3));
		Method.clickondisplayBtn();
		util.Wait_TillPageView();
		WebElement stageelement1 = driver.findElement(Method.pageview);
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Epsilon Sales Touch']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		util.Wait_InvisibleLoader();
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 3));
		util.Wait_InvisibleLoader();
		wait.until(ExpectedConditions.visibilityOf(Method.wrapper));
	    Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 3));
	    wait.until(ExpectedConditions.visibilityOf(Method.wrapper));
		Method.clickondisplayBtn();
		util.Wait_TillPageView();
		String prodelement1 = driver.findElement(Method.pageview).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Epsilon Sales Touch']")).getText();
        System.out.println("Grand total of Epsilon>Salse touch>Page View=" + prodelement1);
        assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);
		}

	@Test
	public void epsilon_BMWT2() throws InterruptedException {
		extentTest = extent.startTest("epsilon_BMWT2");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Method.loader));
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Method.loader));
		wait.until(ExpectedConditions.visibilityOf(Method.wrapper));
		Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Method.Bywrapper));
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(Method.pageview));
		WebElement stageelement1 = driver.findElement(Method.pageview);
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Epsilon BMW T2']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		
		Method.Prodlogin();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Method.loader));
		Method.EnterDate();
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Method.loader));
		wait.until(ExpectedConditions.visibilityOf(Method.wrapper));
		Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Method.Bywrapper));
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"))
				.getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Epsilon BMW T2']")).getText();

		System.out.println("Grand total of Epsilon>BMWT2>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);
	}

	@Test
	public void epsilon_BusinessElite() throws InterruptedException {
		extentTest = extent.startTest("epsilon_BusinessElite");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 5));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 5));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[3]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[3]/b"));
		WebElement stageelement2 = driver
				.findElement(By.xpath("//span[text()='Epsilon Business Elite Standard, Non-Standard Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 5));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 5));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[3]/b")));
		String prodelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[3]/b"))
				.getText();
		String prodelement2 = driver
				.findElement(By.xpath("//span[text()='Epsilon Business Elite Standard, Non-Standard Report']"))
				.getText();

		System.out.println("Grand total of Epsilon>Business Elite>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);
	}

	@Test

	public void epsilon_CSSR_CarCare() throws InterruptedException {
		extentTest  = extent.startTest("epsilon_CSSR_CarCare");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 6));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 6));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Epsilon Car Care Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 6));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 6));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"))
				.getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Epsilon Car Care Report']")).getText();

		System.out.println("Grand total of Epsilon>CarCare>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}

	@Test
	public void epsilon_CSSR_EVO_OLA_Combined() throws InterruptedException {
		extentTest = extent.startTest("epsilon_CSSR_EVO_OLA_Combined");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 7));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 7));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(60000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='EVO OLA Combined Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 7));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 7));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(60000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"))
				.getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='EVO OLA Combined Report']")).getText();

		System.out.println("Grand total of Epsilon>EVOOLACombined Report>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}

	@Test
	public void epsilon_CSSROLA() throws InterruptedException {
		extentTest = extent.startTest("epsilon_CSSROLA");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 8));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 8));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Epsilon OLA Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 8));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 8));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"))
				.getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Epsilon OLA Report']")).getText();

		System.out.println("Grand total of Epsilon>CSSR OLA>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}

	@Test
	public void epsilon_CSSRLease() throws InterruptedException {
		extentTest = extent.startTest("epsilon_CSSRLease");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 9));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 9));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Epsilon CSSR Lease Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 9));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 9));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b"))
				.getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Epsilon CSSR Lease Report']")).getText();

		System.out.println("Grand total of Epsilon>CSSRLease=>Page View" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}

	@Test
	public void epsilon_Cherokee() throws InterruptedException {
		extentTest = extent.startTest("epsilon_cherokee");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 10));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 10));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[3]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Cherokee Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 10));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 10));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[3]/b")));
		String prodelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/b")).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Cherokee Report']")).getText();

		System.out.println("Grand total of Epsilon>cherokee>Page View =" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}

	@Test
	public void epsilon_FordService() throws InterruptedException {
		extentTest = extent.startTest("epsilon_Fordservice");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 11));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 11));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[3]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Ford Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 11));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 11));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[3]/b")));
		String prodelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/b")).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Ford Report']")).getText();

		System.out.println("Grand total of Epsilon>Ford Service>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}
	
	@Test
	public void epsilon_FordTruck() throws InterruptedException {
		extentTest = extent.startTest("epsilon_FordTruck");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 12));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 12));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[3]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Ford Truck Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 12));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 12));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[3]/b")));
		String prodelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/b")).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Ford Truck Report']")).getText();

		System.out.println("Grand total of Epsilon>Ford Truck>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}
	
	
	@Test
	public void epsilon_HondaLcc() throws InterruptedException {
		extentTest = extent.startTest("epsilon_HondaLcc");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 13));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 13));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[5]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Honda Lcc']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 13));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 13));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/b")).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Honda Lcc']")).getText();

		System.out.println("Grand total of Epsilon>Honda Lcc>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}
	
	
	
	@Test
	public void epsilon_HondaSPS() throws InterruptedException {
		extentTest = extent.startTest("epsilon_HondaSPS");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 14));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 14));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[5]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Honda SPS']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 14));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 14));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/b")).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Honda SPS']")).getText();

		System.out.println("Grand total of Epsilon>Honda SPS>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}
		
	
	@Test
	public void epsilon_HyundaiEM() throws InterruptedException {
		extentTest = extent.startTest("epsilon_HyundaiEM");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 15));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 15));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[5]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Hyundai EM']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 15));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 15));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[5]/b")));
		String prodelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/b")).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Hyundai EM']")).getText();

		System.out.println("Grand total of Epsilon>Hyundai EM>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}
	
	@Test
	public void epsilon_InterceptLMA() throws InterruptedException {
		extentTest = extent.startTest("epsilon_InterceptLMA");
		wait = new WebDriverWait(driver, 600);
		Method.stagelogin();
		Method.EnterDate();
		Thread.sleep(10000);
		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 16));
		Thread.sleep(10000);
		Boolean Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 16));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}

		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[4]/b")));
		WebElement stageelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[4]/b"));
		WebElement stageelement2 = driver.findElement(By.xpath("//span[text()='Epsilon National LMA Report']"));
		List<String> Lst = new ArrayList<String>();
		Lst.add(stageelement1.getText());
		Lst.add(stageelement2.getText());
		Method.Prodlogin();
		Method.EnterDate();
		Thread.sleep(10000);

		Method.SelectFormDropdown(excel.getCellData("TestData", "Category", 16));
		Thread.sleep(10000);
		Stalelement = true;
		while (Stalelement)
			try {
				Method.SelectFromSubDropdown(excel.getCellData("TestData", "SubCategory", 16));
				Stalelement = false;
			} catch (StaleElementReferenceException e) {
				Stalelement = true;
			}
		Thread.sleep(10000);
		Method.clickondisplayBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[4]/b")));
		String prodelement1 = driver.findElement(By.xpath("//tbody/tr[last()]/td[4]/b")).getText();
		String prodelement2 = driver.findElement(By.xpath("//span[text()='Epsilon National LMA Report']")).getText();

		System.out.println("Grand total of Epsilon>InterceptLMA>Page View=" + prodelement1);

		assertEquals(Lst.get(0), prodelement1);
		assertEquals(Lst.get(1), prodelement2);

	}
		
		
	
}