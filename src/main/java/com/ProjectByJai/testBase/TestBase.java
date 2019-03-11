package com.ProjectByJai.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ProjectByJai.browser.Browser;
import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.LoggerHelper;
import com.ProjectByJai.helper.ReportFunction;
import com.ProjectByJai.helper.ResourcesHelper;
import com.ProjectByJai.helper.WaitHelper;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class TestBase 
{

	
	private Logger log = LoggerHelper.takeLogger(TestBase.class);
	public static File reportDirectery;

	@BeforeSuite
	public void beforeSuite() throws Exception
	{
	 ReportFunction.extentReportingMethod();
	}
	@BeforeClass
	public void beforeTest()
	{	
		ReportFunction.test = ReportFunction.extent.createTest(getClass().getSimpleName());
	}
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		ReportFunction.test.log(Status.INFO, method.getName()+"**************test started***************");
		log.info("**************"+method.getName()+"Started***************");
	}
	
	@BeforeTest
	public void beforeMethod()
	{
		Browser.getBrowser("chrome");
		Constant.driver.get(Constant.url);
		WaitHelper.impliciteWait(10);
		reportDirectery = new File(ResourcesHelper.getPath("src/main/resources/screenshot"));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE){
			ReportFunction.test.log(Status.FAIL, result.getThrowable());
			String img = captureScreen(result.getName());
			ReportFunction.test.addScreenCaptureFromPath(img);
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			ReportFunction.test.log(Status.PASS, result.getName()+" is pass");
			String img = captureScreen(result.getName());
			ReportFunction.test.addScreenCaptureFromPath(img);
			
		}
		else if(result.getStatus() == ITestResult.SKIP){
			ReportFunction.test.log(Status.SKIP, result.getThrowable());
			String img = captureScreen(result.getName());
			ReportFunction.test.addScreenCaptureFromPath(img);
		}
		log.info("**************"+result.getName()+"Finished***************");
		ReportFunction.extent.flush();
	}
	
	/*@AfterTest
	public void afterTest() throws Exception
	{
		if(Constant.driver!=null)
		{
			Constant.driver.quit();
		}
	}*/
	
	public String captureScreen(String fileName)
	{
		if(Constant.driver == null){
			log.info("driver is null..");
			return null;
		}
		if(fileName==""){
			fileName = "blank";
		}
		Reporter.log("captureScreen method called");
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screFile = ((TakesScreenshot)Constant.driver).getScreenshotAs(OutputType.FILE);
		try{
			destFile = new File(reportDirectery+"/"+fileName+"_"+formater.format(calendar.getTime())+".png");
			Files.copy(screFile, destFile);
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return destFile.toString();
	}
	
	
	
	public static void logExtentReport(String s1){
		ReportFunction.test.log(Status.INFO, s1);
	}
}
