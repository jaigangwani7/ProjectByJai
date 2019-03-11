package com.ProjectByJai.testScript;

import org.testng.annotations.Test;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.pageObject.SalesForce_LoginPage;
import com.ProjectByJai.pageObject.SalesForce_RecordSearchPage;

public class SearchRecordInSalesforce 
{
	@Test
	public void searchForRecord()
	{
		SalesForce_RecordSearchPage searchforid = new SalesForce_RecordSearchPage();
		searchforid.enterSearchid("00027654");
	}
}
