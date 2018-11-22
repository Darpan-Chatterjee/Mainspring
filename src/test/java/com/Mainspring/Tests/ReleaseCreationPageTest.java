package com.Mainspring.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Mainspring.Pages.CognizantLoginPage;
import com.Mainspring.Utilities.ExtentReportManager;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.Utilities.Validations;
import com.Mainspring.core.BaseTest;
import com.aventstack.extentreports.ExtentTest;

public class ReleaseCreationPageTest extends BaseTest {
	
	static ExtentTest scenario;
	Validations validation;
	UtilityMethods util;
	
	@BeforeClass
	public void ReleaseCreationPageTestScenarioSetup()
	{
		scenario = ExtentReportManager.createScenario("Release Creation Scenarios","");
		validation=new Validations(driver);
		util=new UtilityMethods();
	}

	@Test
	public void MainSpringLandingPageCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Mainspring Landing Page Check","");
		try
		{
			driver.get(appUrl);
			util.waitInSeconds(3);
			if(driver.getCurrentUrl().equals("https://authvchnform.cognizant.com/vpn/tmindex.html"))
			{
				validation.validation(true, tc, "Cognizant Login Page is Open");
				CognizantLoginPage cognizantLoginPageObj=new CognizantLoginPage();
				cognizantLoginPageObj.clickLogin();
				util.waitInSeconds(5);
			}
			if(driver.findElement(By.xpath("//span[contains(@class,'icon-leftMeuOpen close_menu')]")).isDisplayed())
			{
				WebElement el=driver.findElement(By.xpath("//span[contains(@class,'icon-leftMeuOpen close_menu')]"));
				Actions ac = new Actions(driver);
				ac.moveToElement(el).build().perform();
				driver.switchTo().defaultContent();
				validation.validation(true, tc, "Mainspring Landing Page is Open");
			}
		}
		catch(Exception e)
		{
			validation.validation(false, tc, "Mainspring Landing Page Check is Failed");
		}
	}
	
	@AfterClass
	public void ContactUsPageTestScenarioTearDown()
	{
		scenario = null;
		validation=null;
	}

}
