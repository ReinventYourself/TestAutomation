package com.unityworks.pages;

import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.unityworks.core.CoreClass;

public class MethodClass extends com.unityworks.core.CoreClass {

	@FindBy(xpath = ".//a[text()='CLICK HERE TO LOG IN']")
	public WebElement LoginLnk;

	@FindBy(xpath = "//input[@id ='login']")
	public WebElement LoginTxt;

	@FindBy(xpath = "//input[@id ='password']")
	public WebElement PasswordTxt;

	@FindBy(xpath = "//input[@type ='submit']")
	public WebElement SubmitBtn;

	@FindBy(xpath = ".//input[@id ='from']")
	public WebElement FromDate;

	@FindBy(xpath = ".//input[@id ='to']")
	public WebElement ToDate;

	@FindBy(xpath = "//select[@id ='item_id']")
	public WebElement MainDropdown;

	@FindBy(xpath = "//select[@id ='web_property_id']")
	public WebElement SubDropdown;

	@FindBy(xpath = ".//button[@id ='disp_button']")
	public WebElement displayBtn;
	
	@FindBy(xpath= "//div[@id ='wrapper']")
	public WebElement wrapper;
	
    public 	By Bywrapper = By.xpath("//div[@id ='wrapper']");
    public 	By loader = By.xpath("//div[@id='excel_download_loading']/img]");	
    
    @FindBy(xpath= "//div[text()='Language']")
    public WebElement LnggDrp;
    
    
   //===============Double Click WebElement=======================
    @FindBy(xpath= "//input[@value='bc_select']")
    public WebElement bc_select;
  
    @FindBy(xpath= "//input[@value='program_select']")
    public WebElement program_select;
    
    @FindBy(xpath= "//input[@value='custom_select']")
    public WebElement custom_select;
    
    @FindBy(xpath= "//select[@class='bc_select select_input']")
    public WebElement bc_select_options;
    
    @FindBy(xpath = "//select[@class='program_select select_input']")
    public WebElement program_select_options;
    
    @FindBy(xpath = "//select[@class='custom_select select_input']")
    public WebElement custom_select_options; 
    
   /* @FindBy(xpath= "//input[@name='apply_mgt_fee' and @id='mgt_yes']")
    public WebElement apply_mgt_yes;
    
    @FindBy(xpath = "//input[@name='apply_mgt_fee' and @id='mgt_no']")
    public WebElement apply_mgt_No;
    
    @FindBy(xpath = "//input[@name='apply_cc_fee' and @id='ccf_yes']")
    public WebElement apply_cc_yes;
    
    @FindBy(xpath = "//input[@name='apply_cc_fee' and @id='ccf_no']")
    public WebElement apply_cc_No;*/
    
    @FindBy(xpath = "//input[@name='res_cmp_start_date' and @id='mgt_yes']")
    public WebElement res_cmp_startdate_Yes;
    
    @FindBy(xpath = "//input[@name='res_cmp_start_date' and @id='mgt_no']")
    public WebElement res_cmp_startdate_No;
    
    @FindBy(xpath= "//input[@name='apply_fee_code' and @id='mgt_yes']")
    public WebElement Apply_Fee_code_Yes;
    
    @FindBy(xpath = "//input[@name='apply_fee_code' and @id='mgt_no']")
    public WebElement Apply_fee_code_No;
     
    @FindBy(xpath= "//select[@name= 'report_type']")
    public WebElement ReportType;
    
    @FindBy(xpath= "//span[text()='Add Scheduled Reports']")
    public WebElement AddScheduleReportBtn;
   
    
    //======================Campaign Manager WebElement==========================================
    
    @FindBy(xpath= "//img[@src='http://uwmedia.us/includes/video_lab_logo.png']")
    public WebElement LogoImg;
    
    @FindBy(xpath = "//div[contains(text(),'Campaign Manager')]")
    public WebElement CmpMngText;
    
    @FindBy(xpath= "//div[contains(text(),'Affinitiv BMW')]")
    public WebElement CmpAffinitiveBMW;
    
    
    //@FindBy(xpath= "//span[text()='Management Fee Table']")
    //public WebElement MngFeeTableReportTitle;
    
   public By pageview =  By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b");
    
    
    

	Select S = null;

	public MethodClass() {

		PageFactory.initElements(driver, this);

	}
	
	/*public String SelectTitleAsPerReportType(String value1, String value2)
	{
		String ReportGetText;
		
		if(value1.equals("Report")) 
		ReportGetText =	driver.findElement(By.xpath(value2)).getText();
		else
		ReportGetText =MngFeeTableReportTitle.getText();
		return ReportGetText;
	}*/
	
	
	/*public String SelectReportPageviewCountAsPerReportType(String Reporttype, String PageviewCount, String pageviewCount1)
	{ 
		
     String pageviewcount;
	 if(Reporttype.equals("Report"))
		pageviewcount=	driver.findElement(By.xpath(PageviewCount)).getText();
			else 
	    pageviewcount=driver.findElement(By.xpath(pageviewCount1)).getText();
		return pageviewcount;
	}*/
	
	
	/*public void analyzeLog() {

	    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	    for (LogEntry entry : logEntries) {
	        System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
	        //do something useful with the data
	    }
	    }*/
	
	
	
	public void ClickOnAffinitiveBMW()
	{
		CmpAffinitiveBMW.click();
		
	}
	
	
	
	
	public void SelectReporttype(String value)
	
	{
		S = new Select(ReportType);
	    S.selectByVisibleText(value);
		
	}
	
	public void SelectRadioBtn(String value)
	{   
		Actions a = new Actions(driver);
		
		if(value.equals("BC"))
			a.moveToElement(bc_select).click().build().perform();
		if(value.equals("Program"))
			a.moveToElement(program_select).click().build().perform();
		  if(value.equals("Custom Select"))
			a.moveToElement(custom_select).click().build().perform();
		
	}
	
	
	public void SelectDropDownBasedOnRadiobtn(String value, String BCSelect, 
			String ProgramSelect, String CustomSelect)
	{
		if(value.equals("BC"))
		{
			S= new Select(bc_select_options);
			S.selectByVisibleText(BCSelect);
		}
		
		if(value.equals("Program"))
		{	
			S= new Select(program_select_options);
		    S.selectByVisibleText(ProgramSelect);
		}
		if(value.equals("Custom Select"))
		{
			S= new Select(custom_select_options);
			S.selectByVisibleText(CustomSelect);
		}
	
	}
	
	/*public void SelectApplyCCFee(String value)
	{
		if(value.equals("Yes"))
		apply_cc_yes.click();
		else
		{
			apply_cc_No.click();
	    }
	}*/
	

	/*public void SelectApplyMgtFee(String value)
	{
		if(value.equals("Yes"))
		apply_mgt_yes.click();
		else
		{
		  apply_mgt_No.click();
	    }
	}*/
	
	public void ApplyfeesFromCodes(String value)
	{
		if(value.equals("Yes"))
			Apply_Fee_code_Yes.click();
		else 
			Apply_fee_code_No.click();
	}
	
	
	
	public void SelectResCMPStartDate(String value)
	{
		if (value.equals("Yes"))
			res_cmp_startdate_Yes.click();
		else 
			res_cmp_startdate_No.click();
	}
	
	
	
	
	
	
	
	

	public void stagelogin() throws InterruptedException {

		driver.navigate().to(prop.getProperty("produrl"));
		LoginLnk.click();
		LoginTxt.sendKeys(excel.getCellData("LoginTest", "UserName", 2));
		PasswordTxt.sendKeys(excel.getCellData("LoginTest", "Password", 2));
		SubmitBtn.click();
		log.debug("Stage login Successful");
		// System.out.println(SubDropdown);
	}

	public void Prodlogin() {
		driver.navigate().to(prop.getProperty("produrl"));
		LoginLnk.click();
		LoginTxt.sendKeys(excel.getCellData("ProdLogin", "UserName", 2));
		PasswordTxt.sendKeys(excel.getCellData("ProdLogin", "Password", 2));
		SubmitBtn.click();
		log.debug("Prod login Successfull");
	}
	
	public void CampaignLogin()
	{
		
		driver.navigate().to(prop.getProperty("CampaignUrl"));
		LoginTxt.sendKeys(excel.getCellData("LoginTest", "UserName", 2));
		PasswordTxt.sendKeys(excel.getCellData("LoginTest", "Password", 2));
		SubmitBtn.click();
		LogoImg.isDisplayed();
		CmpMngText.isDisplayed();
		log.debug("Campaign login Successful");
	}
	


	public void EnterDate( ) throws InterruptedException {

		FromDate.clear();
		FromDate.sendKeys(excel.getCellData("Calendar", "FromDate", 2));
		Thread.sleep(1000);
		ToDate.clear();
		ToDate.sendKeys(excel.getCellData("Calendar", "ToDate", 2));
	    R.keyPress(KeyEvent.VK_ESCAPE);
		R.keyRelease(KeyEvent.VK_ESCAPE);
		log.debug("Date Entered Successfully");

	}

	
	
	
	
	
	public void EnterDate1( String StartDate, String EndDate) throws InterruptedException {

		FromDate.clear();
		FromDate.sendKeys(StartDate);
		//FromDate.sendKeys(excel.getCellData("Calendar", "FromDate", 2));
		Thread.sleep(1000);
		ToDate.clear();
		ToDate.sendKeys(EndDate);
		//ToDate.sendKeys(excel.getCellData("Calendar", "ToDate", 2));
	    R.keyPress(KeyEvent.VK_ESCAPE);
		R.keyRelease(KeyEvent.VK_ESCAPE);
		log.debug("Date Entered Successfully");

	}

	public void SelectFormDropdown(String value) {

		S = new Select(MainDropdown);
		S.selectByVisibleText(value);
	}

	public void SelectFromSubDropdown(String value) {
       S = new Select(SubDropdown);
       Boolean Staleelement = true;
       while(Staleelement)
           try{
            S.selectByVisibleText(value);
            Staleelement = false;
            }catch(StaleElementReferenceException e){
          Staleelement = true;
          }
      }

	public void clickondisplayBtn() {

		Actions a = new Actions(driver);
		a.moveToElement(displayBtn).click().build().perform();

		// displayBtn.click();

	}

}
