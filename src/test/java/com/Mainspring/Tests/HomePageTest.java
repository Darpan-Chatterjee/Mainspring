package com.Mainspring.Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Mainspring.Utilities.ExtentReportManager;
import com.Mainspring.core.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class HomePageTest extends BaseTest {

	static ExtentTest scenario;
	
	@BeforeClass
	public void HomePageTestScenarioSetup()
	{
		scenario = ExtentReportManager.createScenario("Home Page Scenarios", "This is for Home Page Scenario Validation");
	}

	@Test
	public void HomeLandingPageCheck() throws IOException
	{                                                                                                               	
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Home Landing Page Check","This is Home Landing Page Check");
		tc.pass("Home Landing Page is available",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());
		tc.pass("Home Landing Page Navigation is Successful");
	}
	@Test
	public void HomeLandingPageLoginCheck() throws IOException
	{                                       	
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Home Landing Page Login Check","This is Home Landing Page Login Check");
		tc.pass("Home Landing Page Login Section is available",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());
		tc.pass("Home Landing Page Login is Successful");
	}
	
	@AfterClass
	public void setHomePageTestScenarioTearDown()
	{
		scenario = null;
	}

}
