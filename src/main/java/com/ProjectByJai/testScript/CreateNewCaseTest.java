package com.ProjectByJai.testScript;

import org.testng.annotations.Test;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.FrameHelper;
import com.ProjectByJai.helper.WaitHelper;
import com.ProjectByJai.pageObject.Salesforce_CreateNewCase;
import com.ProjectByJai.pageObject.SalesForce_LoginPage;
import com.ProjectByJai.testBase.TestBase;

public class CreateNewCaseTest extends TestBase
{
	@Test(priority=1)
	public void testValidLogin()
	{
		SalesForce_LoginPage loginTest = new SalesForce_LoginPage();
		loginTest.loginToApplication(Constant.userName,Constant.passWord);
		loginTest.printEnvt();
	}
	@Test(priority=2)
	public void newCaseCreate()
	{
		Salesforce_CreateNewCase createCase = new Salesforce_CreateNewCase();
		WaitHelper.explicitlyWaitTimeForFrameAndSwitch(20,"ext-comp-1005");
		createCase.clickOnNewCaseButton();
		Constant.driver.switchTo().defaultContent();
		WaitHelper.explicitlyWaitTimeForFrameAndSwitch(20,"ext-comp-1029");
		createCase.verifyPageTitleOne();
		createCase.selectRecordType("NA");
		createCase.clickOnContinueButton();
		FrameHelper help =  new FrameHelper();
		help.switchToFrame(createCase.enteringFrame());
		createCase.verifyPageTitleTwo();
		createCase.selectCounrty("United States of America");
		createCase.selectLanguage("English-US");
		createCase.enterSummary("Running Automation Script");
		createCase.clickOnSaveButton();
	}
	
	
}




