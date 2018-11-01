package com.Mainspring.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Mainspring.Utilities.DriverSet;
import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.PropertyFileData;

public class BaseTest {
	
	public ArrayList<HashMap<String,String>> excelDataList=null;
	public WebDriver driver=null;
	public Properties prop = null;
	public XSSFWorkbook masterExcelWorkBookObj=null;
	public ExcelUtility excelUtil=null;
	
	public String browserPath;
	public int timeOutLimit;
	public String masterExcelPath=null;
	public String masterExcelName=null;
	
	public PropertyFileData dataObj= new PropertyFileData();
	
	@BeforeTest
	public void setup() throws IOException
	{
		prop = dataObj.getPropertyData("AutomationConfig");
		browserPath=prop.getProperty("ChromePath");
		timeOutLimit=Integer.parseInt(prop.getProperty("AutomationTimeout"));
		masterExcelPath=prop.getProperty("MasterExcelPath");
		masterExcelName=prop.getProperty("MasterExcelName");
		
		DriverSet getDriver= new DriverSet(browserPath,timeOutLimit);
		excelUtil= new ExcelUtility(masterExcelPath,masterExcelName);
		
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
