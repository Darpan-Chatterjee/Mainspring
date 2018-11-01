package com.Mainspring.Tests;

import org.testng.annotations.Test;

import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class HomePageTest extends BaseTest {
	
	@Test
	public void HomePageValidation()
	{
		UtilityMethods util= new UtilityMethods();
		String urlCurrent=null;
		
		excelDataList =ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "User Story Investment");
		driver.get("https://portal.bsnl.in/myportal/");
		util.waitInSeconds(3);
		try 
		{
			urlCurrent= driver.getCurrentUrl();
			if(urlCurrent.contains("bsnl"))
			{
				homePageObj.click();
			}
		} 
		catch (Exception e) {
			
		}
	}
}
