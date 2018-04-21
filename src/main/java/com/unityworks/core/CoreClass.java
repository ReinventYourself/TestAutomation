package com.unityworks.core;


import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.collections.Lists;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.unityworks.config.Configuration;
import com.unityworks.utils.Util;
import com.unityworks.utils.Xls_Reader;

public class CoreClass {

	public static WebDriver driver = null;
	public static Properties prop;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.xlsx");
	public static Robot R = null;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	
	
	public CoreClass() {

		try {
			prop = new Properties();

			FileInputStream config = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\unityworks\\config\\Configuration.properties");
			prop.load(config);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/UnityWorksTestAutomationReport.html", true);
        extent.addSystemInfo("Host Name", "SEZ-10.india.rsystems.com");
		extent.addSystemInfo("User Name", System.getProperty("user.name"));
		extent.addSystemInfo("Environment", "prod");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS:- " + result.getName());
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS:- " + result.getThrowable());
            String screenshotPath = CoreClass.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS:- " + result.getName());}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS:- " + result.getName());

		}
		extent.endTest(extentTest);
		
	}
	


	@AfterSuite
	public void SendEmail()
	{
		if(prop.getProperty("EmailSend").equals("true"))
		{
	      Configuration.SendMailSSLWithAttachment();
		  driver.quit();
		} 
		else
		{
			System.out.println("If you want to send the Test result Email then turn on the setting from the config");
			//driver.quit();
			
		}
		  
    }
	
	@BeforeSuite
	public void initialize() {

		if (prop.getProperty("Browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
		   log.debug("Firefox Driver Launch");
		}
		if (prop.getProperty("Browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			
			
			driver = new ChromeDriver();

			log.debug("Chrome Driver Launch");

			try {
				R = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
