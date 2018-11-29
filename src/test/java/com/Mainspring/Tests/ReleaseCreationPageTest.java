package com.Mainspring.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Mainspring.Pages.CognizantLoginPage;
import com.Mainspring.Pages.ReleaseCreationPage;
import com.Mainspring.Utilities.ExtentReportManager;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.Utilities.Validations;
import com.Mainspring.core.BaseTest;
import com.aventstack.extentreports.ExtentTest;

public class ReleaseCreationPageTest extends BaseTest {

	static ExtentTest scenario;
	Validations validation;
	UtilityMethods util;
	String menu,closeMenu,myWork,planProject,addRelease;

	@BeforeClass
	public void ReleaseCreationPageTestScenarioSetup()
	{
		scenario = ExtentReportManager.createScenario("Release Creation Scenarios","");
		validation=new Validations(driver);
		util=new UtilityMethods();
		try 
		{
			menu=dataObj.getPropertyData("ReleaseCreationPage","menu");
			closeMenu=dataObj.getPropertyData("ReleaseCreationPage","closemenu");
			myWork=dataObj.getPropertyData("ReleaseCreationPage","myWork");
			planProject=dataObj.getPropertyData("ReleaseCreationPage","planProject");
			addRelease=dataObj.getPropertyData("ReleaseCreationPage","addRelease");
		} 
		catch (IOException e) {

		}
	}

	@Test(priority=1)
	public void MainSpringLandingPageCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Mainspring Landing Page Check","");
		try
		{
			driver.get(appUrl);
			util.waitInSeconds(8);
			if(driver.getCurrentUrl().equals("https://authvchnform.cognizant.com/vpn/tmindex.html"))
			{
				validation.validation(true, tc, "Cognizant Login Page is Open");
				CognizantLoginPage cognizantLoginPageObj=new CognizantLoginPage();
				cognizantLoginPageObj.clickLogin();
				util.waitInSeconds(5);
			}
			if(driver.findElement(By.xpath(menu)).isDisplayed())
			{
				WebElement el=driver.findElement(By.xpath(menu));
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

	@Test(priority=2)
	public void MyWorkPageCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Mainspring My Work Page Check","");
		try
		{
			util.waitInSeconds(8);
			if(driver.findElement(By.xpath(closeMenu)).isDisplayed())
			{
				ReleaseCreationPage releaseCreationPageObj=new ReleaseCreationPage();
				releaseCreationPageObj.clickWorkspace();
				util.waitInSeconds(2);
				releaseCreationPageObj.clickMyWorkspace();
				util.waitInSeconds(4);
				validation.validation(true, tc, "Mainspring My Work Page is Open");
			}
		}
		catch(Exception e)
		{
			validation.validation(false, tc, "Mainspring My Work Page Check is Failed");
		}
	}

	@Test(priority=3)
	public void ProjectPageCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Mainspring Project Page Check","");
		try
		{
			util.waitInSeconds(20);
			if(driver.findElement(By.xpath(myWork)).isDisplayed())
			{
				ReleaseCreationPage releaseCreationPageObj=new ReleaseCreationPage();
				Actions ac = new Actions(driver);
				ac.moveToElement(driver.findElement(By.xpath(myWork))).build().perform();
				driver.switchTo().defaultContent();
				util.waitInSeconds(1);
				releaseCreationPageObj.clickProject();
				util.waitInSeconds(5);
				driver.findElement(By.xpath("//div[text()='OFI QA Service']")).click();
				util.waitInSeconds(4);
				validation.validation(true, tc, "Mainspring Project Details Page is Open");
			}
		}
		catch(Exception e)
		{
			validation.validation(false, tc, "Mainspring Project Details Page Check is Failed");
		}
	}

	@Test(priority=4)
	public void ProjectPlanPageCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Mainspring Project Plan Page Check","");
		try
		{
			util.waitInSeconds(20);
			if(driver.findElement(By.xpath(planProject)).isDisplayed())
			{
				validation.validation(true, tc, "Mainspring Project Plan Page is Open");
				ReleaseCreationPage releaseCreationPageObj=new ReleaseCreationPage();
				Actions ac = new Actions(driver);
				ac.moveToElement(driver.findElement(By.xpath(planProject))).build().perform();
				driver.switchTo().defaultContent();
				util.waitInSeconds(1);
				releaseCreationPageObj.clickRelease();
				util.waitInSeconds(15);
				try {
					if(driver.findElement(By.xpath(addRelease)).isDisplayed())
					{
						util.waitInSeconds(2);
						validation.validation(true, tc, "Mainspring Release Details Page is Open");
					}
					else
					{
						validation.validation(false, tc, "Mainspring Release Details Page Check is Failed");
					}
				} catch (Exception e) {
					validation.validation(false, tc, "Mainspring Release Details Page Check is Failed");
				}
			}
		}
		catch(Exception e)
		{
			validation.validation(false, tc, "Mainspring Project Plan Page Check is Failed");
		}
	}

	@AfterClass
	public void ReleaseCreationPageTestScenarioTearDown()
	{
		scenario = null;
		validation=null;
	}

}
