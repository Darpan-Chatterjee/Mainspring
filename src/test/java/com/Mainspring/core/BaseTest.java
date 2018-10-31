package com.Mainspring.core;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Mainspring.Utilities.DriverSet;
import com.Mainspring.Utilities.PropertyFileData;

public class BaseTest {
	
	public WebDriver driver=null;
	public Properties prop = null;
	public String browserPath;
	public int timeOutLimit;
	
	
	public PropertyFileData dataObj= new PropertyFileData();
	
	@BeforeTest
	public void setup() throws IOException
	{
		prop = dataObj.getPropertyData("AutomationConfig");
		browserPath=prop.getProperty("ChromePath");
		timeOutLimit=Integer.parseInt(prop.getProperty("AutomationTimeout"));
		DriverSet getDriver= new DriverSet(browserPath,timeOutLimit);
		driver= getDriver.openBrowser();
	}
	
	@AfterTest
	public void teardown()
	{
		//driver.quit();
	}
	
}
