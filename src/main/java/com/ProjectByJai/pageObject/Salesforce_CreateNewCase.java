package com.ProjectByJai.pageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.FrameHelper;
import com.ProjectByJai.helper.LoggerHelper;
import com.ProjectByJai.testBase.TestBase;

public class Salesforce_CreateNewCase
{
	private Logger log = LoggerHelper.takeLogger(Salesforce_CreateNewCase.class);
	
	
	@FindBy(xpath="//input[@value='New Case']")
	WebElement newCase;
	
	@FindBy(xpath="//h2[text()=' Select Case Record Type']")
	WebElement pageTitleOne;
	
	@FindBy(xpath="//select[@id='p3']")
	WebElement recordType;
	
	@FindBy(xpath="//input[@title='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//h2[text()=' New Case']")
	WebElement pageTitleTwo;
	
	@FindBy(xpath="//select[@id='00N80000005Z4gO']")
	WebElement country;
	
	@FindBy(xpath="//select[@id='00N80000005Z4gb']")
	WebElement language;
	
	@FindBy(xpath="//textarea[@id='00N80000005Z4h6']")
	WebElement summary;
	
	@FindBy(xpath="//input[@value=' Save ']")
	WebElement save;
	
	@FindBy(xpath="(//iframe)[2]")
	WebElement frame;
	public Salesforce_CreateNewCase()
	{
		PageFactory.initElements(Constant.driver, this);
		log.info("Salesforce_CreateNewCase object created");
		TestBase.logExtentReport("Salesforce_CreateNewCase object created");
		//List<WebElement> iframeElements = Constant.driver.findElements(By.tagName("iframe"));
		//log.info("The total number of iframes are " + iframeElements.size());
	}
	
	public void clickOnNewCaseButton()
	{
		newCase.click();
		log.info("Clicked on New Case Button..");
		TestBase.logExtentReport("Clicked on New Case Button..");
		Constant.driver.switchTo().defaultContent();
	}
	
	public void verifyPageTitleOne()
	{
		log.info("Current page title is "+pageTitleOne.getText());
		TestBase.logExtentReport("Current page title is "+pageTitleOne.getText());
	}
	
	public void selectRecordType(String record)
	{
		log.info("Enter here");
		
		//List <WebElement> listBox = Constant.driver.findElements(By.id("p3"));
		Select select = new Select(recordType);
		select.selectByVisibleText(record);
		log.info("Selecting Record Type as: "+record);
		TestBase.logExtentReport("Selecting Record Type as: "+record);	
		}
				
		/*List<WebElement> days = Constant.driver.findElements(By.xpath("//select[@id='p3']"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText();
			if (text.equals(record)) {
				log.info("Selecting record as: "+record);
				TestBase.logExtentReport("Selecting record as: "+record);
				c.click();
				break;
			}
		}*/
	
	
	public void clickOnContinueButton()
	{
		continueButton.click();
		log.info("Clicked on Continue Button..");
		TestBase.logExtentReport("Clicked on Continue Button..");
	}
	
	public void verifyPageTitleTwo()
	{
		log.info("Current page title is "+pageTitleTwo.getText());
		TestBase.logExtentReport("Current page title is "+pageTitleTwo.getText());
	}
	
	public void selectCounrty(String record)
	{
		Select select = new Select(country);
		select.selectByVisibleText(record);
		log.info("Selecting country as: "+record);
		TestBase.logExtentReport("Selecting country as: "+record);	
	}
	
	public void selectLanguage(String record)
	{
		Select select = new Select(language);
		select.selectByVisibleText(record);
		log.info("Selecting Language as: "+record);
		TestBase.logExtentReport("Selecting Language as: "+record);	
	}
	
	public void enterSummary(String summary)
	{
		this.summary.sendKeys(summary);
		log.info("Entered Summary is "+summary);
		TestBase.logExtentReport("Entered Summary is "+summary);	
	}
	
	public void clickOnSaveButton()
	{
		save.click();
		log.info("Clicked on Save button");
		TestBase.logExtentReport("Clicked on Save button");
	}
	public WebElement enteringFrame()
	{
		return frame;
	}
	
}
