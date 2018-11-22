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
import com.Mainspring.Utilities.ExtentReportManager;
import com.Mainspring.Utilities.PropertyFileData;
import com.Mainspring.Utilities.UtilityMethods;

public class BaseTest {
	
	public ArrayList<HashMap<String,String>> excelDataList=null;
	public static WebDriver driver=null;
	public XSSFWorkbook masterExcelWorkBookObj=null;
	public ExcelUtility excelUtil=null;
	
	public static String appUrl; 
	public String browserValue;
	public String browserPath;
	public int timeOutLimit;
	public String masterExcelPath=null;
	public String masterExcelName=null;
	
	public PropertyFileData dataObj= new PropertyFileData();
	public UtilityMethods util=new UtilityMethods();
	
	public HomePage homePageObj=null;
	
	@BeforeTest
	public void setup() throws IOException
	{
		util.deleteScreenshots();
		browserValue=dataObj.getPropertyData("AutomationConfig","Browser");
		switch(browserValue)
		{
		case "Chrome":
			browserPath=dataObj.getPropertyData("AutomationConfig","ChromePath");
			break;
		case "Firefox":
			browserPath=dataObj.getPropertyData("AutomationConfig","FirefoxPath");
			break;
		case "IE":
			browserPath=dataObj.getPropertyData("AutomationConfig","IEPath");
			break;
		}
		appUrl=dataObj.getPropertyData("AutomationConfig","AppURL");
		timeOutLimit=Integer.parseInt(dataObj.getPropertyData("AutomationConfig","AutomationTimeout"));
		masterExcelPath=dataObj.getPropertyData("AutomationConfig","MasterExcelPath");
		masterExcelName=dataObj.getPropertyData("AutomationConfig","MasterExcelName");
		
		DriverSet getDriver= new DriverSet(browserPath,timeOutLimit);
		excelUtil= new ExcelUtility(masterExcelPath,masterExcelName);
		homePageObj= new HomePage();
		
		ExtentReportManager.startTest();
		
		
		driver= getDriver.openBrowser();
		masterExcelWorkBookObj=excelUtil.setExcel();
	}
	
	@AfterTest
	public void teardown() throws IOException
	{
		driver.quit();
		masterExcelWorkBookObj.close();
		ExtentReportManager.endTest();
	}
	
}
