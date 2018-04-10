package com.unityworks.pages;

import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.unityworks.core.CoreClass;

public class MethodClass extends com.unityworks.core.CoreClass {

	@FindBy(xpath = ".//a[text()='CLICK HERE TO LOG IN']")
	WebElement LoginLnk;

	@FindBy(xpath = "//input[@id ='login']")
	WebElement LoginTxt;

	@FindBy(xpath = "//input[@id ='password']")
	WebElement PasswordTxt;

	@FindBy(xpath = "//input[@type ='submit']")
	WebElement SubmitBtn;

	@FindBy(xpath = ".//input[@id ='from']")
	WebElement FromDate;

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
    
   public By pageview =  By.xpath(".//*[@id='first_report']/tbody/tr[last()]/td[5]/b");
    
    
    

	Select S = null;

	public MethodClass() {

		PageFactory.initElements(driver, this);

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

	public void EnterDate() {

		FromDate.clear();
		FromDate.sendKeys(excel.getCellData("Calendar", "FromDate", 2));
		ToDate.clear();
		ToDate.sendKeys(excel.getCellData("Calendar", "ToDate", 2));
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
