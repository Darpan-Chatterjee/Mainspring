package com.Mainspring.Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Mainspring.Utilities.ExtentReportManager;
import com.Mainspring.core.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ContactUsPageTest extends BaseTest {
	
	static ExtentTest scenario;
	
	@BeforeClass
	public void ContactUsPageTestScenarioSetup()
	{
		scenario = ExtentReportManager.createScenario("Contact Us Page Scenarios", "This is for Contact Us Page Scenario Validation");
	}

	@Test
	public void ContactLandingPageCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Contact Us Landing Page Check","This is Contact Us Landing Page Check");
		tc.pass("Contact Us Landing Page is available",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());
		tc.pass("Contact Us Landing Page Navigation is Successful");
	}
	@Test
	public void ContactLandingPageLoginCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Contact Us Landing Page Login Check","This is Contact Us Landing Page Login Check");
		tc.pass("Contact Us Landing Page Login Section is available",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());
		tc.fail("Contact Us Landing Page Login is failed");
	}
	
	@AfterClass
	public void ContactUsPageTestScenarioTearDown()
	{
		scenario = null;
	}

}
