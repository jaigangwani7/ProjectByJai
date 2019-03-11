package com.ProjectByJai.testScript;

import org.testng.annotations.Test;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.pageObject.SalesForce_LoginPage;
import com.ProjectByJai.testBase.TestBase;

public class LoginToSalesForce extends TestBase
{
	@Test
	public void testValidLogin()
	{
		SalesForce_LoginPage loginTest = new SalesForce_LoginPage();
		loginTest.loginToApplication(Constant.userName,Constant.passWord);
		loginTest.printEnvt();
	}
}
