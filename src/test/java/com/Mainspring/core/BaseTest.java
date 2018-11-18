package com.Mainspring.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Mainspring.Pages.HomePage;
import com.Mainspring.Tests.ContactUsPageTest;
import com.Mainspring.Tests.HomePageTest;
import com.Mainspring.Utilities.DriverSet;
import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.ExtentReportManager;
import com.Mainspring.Utilities.PropertyFileData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	
	public ArrayList<HashMap<String,String>> excelDataList=null;
	public static WebDriver driver=null;
	public XSSFWorkbook masterExcelWorkBookObj=null;
	public ExcelUtility excelUtil=null;
	
	public String browserPath;
	public int timeOutLimit;
	public String masterExcelPath=null;
	public String masterExcelName=null;
	
	protected ExtentHtmlReporter htmlReporter;
    protected ExtentReports extentReport;
	
	public PropertyFileData dataObj= new PropertyFileData();
	
	public HomePage homePageObj=null;
	public HomePageTest homePageTestObj=null;
	public ContactUsPageTest contactUsPageTestObj=null;
	
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
		homePageTestObj=new HomePageTest();
		contactUsPageTestObj=new ContactUsPageTest();
		
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
