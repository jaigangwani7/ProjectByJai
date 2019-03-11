package com.ProjectByJai.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.LoggerHelper;
import com.ProjectByJai.testBase.TestBase;

public class SalesForce_LoginPage 
{
	private final Logger log = LoggerHelper.takeLogger(SalesForce_LoginPage.class);
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Sandbox: ']")
	WebElement verifyEnvt;
	
	@FindBy(xpath="//span[text()='ACC']")
	WebElement printEnvt;
	
	
	public SalesForce_LoginPage()
	{
		PageFactory.initElements(Constant.driver, this);
		log.info("SalesForce_LoginPage Object Created");
		TestBase.logExtentReport("SalesForce_LoginPage Object Created");
	}
	
	public void enterUserName(String username)
	{
		log.info("entering email address...."+username);
		TestBase.logExtentReport("entering email address...."+username);
		this.username.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		log.info("entering email address....********");
		TestBase.logExtentReport("entering password....********");
		this.password.sendKeys(password);
	}
	
	public void clickOnSignInLink()
	{
		log.info("clicked on Login button...");
		TestBase.logExtentReport("clicked on Login button...");
		loginButton.click();
	}
	
	public void loginToApplication(String emailid, String pwd)
	{
		
		enterUserName(emailid);
		enterPassword(pwd);
		clickOnSignInLink();
	}
	
	public void printEnvt()
	{
		log.info("Envt is "+printEnvt.getText());
		TestBase.logExtentReport("Envt is "+printEnvt.getText());
	}
	
}

