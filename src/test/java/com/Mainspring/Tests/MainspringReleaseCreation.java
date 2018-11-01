package com.Mainspring.Tests;

import org.testng.annotations.Test;

import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.core.BaseTest;

public class MainspringReleaseCreation extends BaseTest {
	
	@Test
	public void AddRelease()
	{
		excelDataList =ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "User Story Investment");
		System.out.println(excelDataList.get(0).get("Due Date"));
		
		
		driver.get("https://mainspring.cognizant.com");
	}

}
