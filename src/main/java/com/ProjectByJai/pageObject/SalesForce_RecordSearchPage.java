package com.ProjectByJai.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.LoggerHelper;
import com.ProjectByJai.testBase.TestBase;

public class SalesForce_RecordSearchPage 
{
	private Logger log= LoggerHelper.takeLogger(SalesForce_RecordSearchPage.class);
	
	@FindBy(xpath="//input[@id='phSearchInput']")
	WebElement search;
	
	public SalesForce_RecordSearchPage()
	{
		PageFactory.initElements(Constant.driver, this);
		log.info("SalesForce_RecordSearchPage object created");
		TestBase.logExtentReport("SalesForce_RecordSearchPage object created");
	}
	
	public void enterSearchid(String id)
	{
		log.info("Searching for id - "+id);
		TestBase.logExtentReport("Searching for id - "+id);
		search.sendKeys(id);
		search.sendKeys(Keys.ENTER);
	}
}
