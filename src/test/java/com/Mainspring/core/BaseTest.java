package com.Mainspring.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Mainspring.Pages.HomePage;
import com.Mainspring.Utilities.DriverSet;
import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.PropertyFileData;

public class BaseTest {
	
	public ArrayList<HashMap<String,String>> excelDataList=null;
	public static WebDriver driver=null;
	public XSSFWorkbook masterExcelWorkBookObj=null;
	public ExcelUtility excelUtil=null;
	
	public String browserPath;
	public int timeOutLimit;
	public String masterExcelPath=null;
	public String masterExcelName=null;
	
	public PropertyFileData dataObj= new PropertyFileData();
	
	public HomePage homePageObj=null;
	
	@BeforeTest
	public void setup() throws IOException
	{
		browserPath=dataObj.getPropertyData("AutomationConfig","ChromePath");
		timeOutLimit=Integer.parseInt(dataObj.getPropertyData("AutomationConfig","AutomationTimeout"));
		masterExcelPath=dataObj.getPropertyData("AutomationConfig","MasterExcelPath");
		masterExcelName=dataObj.getPropertyData("AutomationConfig","MasterExcelName");
		
		DriverSet getDriver= new DriverSet(browserPath,timeOutLimit);
		excelUtil= new ExcelUtility(masterExcelPath,masterExcelName);
		homePageObj= new HomePage();
		
		driver= getDriver.openBrowser();
		masterExcelWorkBookObj=excelUtil.setExcel();
	}
	
	@AfterTest
	public void teardown() throws IOException
	{
		//driver.quit();
		masterExcelWorkBookObj.close();
	}
	
}
