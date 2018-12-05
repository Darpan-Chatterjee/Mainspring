package com.Mainspring.Tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Mainspring.Pages.CognizantLoginPage;
import com.Mainspring.Pages.ReleaseCreationPage;
import com.Mainspring.Pages.SprintCreationPage;
import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.ExtentReportManager;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.Utilities.Validations;
import com.Mainspring.core.BaseTest;
import com.aventstack.extentreports.ExtentTest;

public class SprintCreationPageTest extends BaseTest {

	static ExtentTest scenario;
	Validations validation;
	UtilityMethods util;
	/*String menu,closeMenu,myWork,planProject,addRelease;*/
	String releaseNamePart1,releaseNamePart2,sprint,linkIcon;

	@BeforeClass
	public void SprintCreationPageTestScenarioSetup()
	{
		scenario = ExtentReportManager.createScenario("Sprint Creation Scenarios","");
		validation=new Validations(driver);
		util=new UtilityMethods();
		try 
		{
			/*menu=dataObj.getPropertyData("ReleaseCreationPage","menu");
			closeMenu=dataObj.getPropertyData("ReleaseCreationPage","closemenu");
			myWork=dataObj.getPropertyData("ReleaseCreationPage","myWork");
			planProject=dataObj.getPropertyData("ReleaseCreationPage","planProject");
			addRelease=dataObj.getPropertyData("ReleaseCreationPage","addRelease");*/
			releaseNamePart1=dataObj.getPropertyData("SprintCreationPage","releaseNamePart1");
			releaseNamePart2=dataObj.getPropertyData("SprintCreationPage","releaseNamePart2");
			sprint=dataObj.getPropertyData("SprintCreationPage","sprint");
			linkIcon=dataObj.getPropertyData("SprintCreationPage","linkIcon");
			
			excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "Sprint");
		} 
		catch (IOException e) {

		}
	}

	/*@Test(priority=1)
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
			util.waitInSeconds(10);
			if(driver.findElement(By.xpath(planProject)).isDisplayed())
			{
				validation.validation(true, tc, "Mainspring Project Plan Page is Open");
				ReleaseCreationPage releaseCreationPageObj=new ReleaseCreationPage();
				Actions ac = new Actions(driver);
				ac.moveToElement(driver.findElement(By.xpath(planProject))).build().perform();
				driver.switchTo().defaultContent();
				util.waitInSeconds(1);
				releaseCreationPageObj.clickRelease();
				util.waitInSeconds(10);
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
	}*/
	
	@Test(priority=6)
	public void AddSprintCheck() throws IOException
	{
		ExtentTest tc = ExtentReportManager.createTestCase(scenario,"Mainspring Create Sprint Page Check","");
		try
		{
			util.waitInSeconds(4);
			String relName=excelDataList.get(0).get("Release").trim();
			if(driver.findElement(By.xpath(releaseNamePart1+relName+releaseNamePart2)).isDisplayed())
			{
				validation.validation(true, tc, "Mainspring Release :"+excelDataList.get(0).get("Release")+" Check");
				driver.findElement(By.xpath(releaseNamePart1+relName+releaseNamePart2)).click();
				util.waitInSeconds(5);
				driver.switchTo().frame("contentframe");
				driver.findElement(By.xpath(sprint)).click();
				util.waitInSeconds(3);
				driver.switchTo().frame("eform_seg_9928478");
				String parentWindow=driver.getWindowHandle();
				driver.findElement(By.xpath(linkIcon)).click();
				util.waitInSeconds(5);
				Set<String> windows=driver.getWindowHandles();
				Iterator<String> I1= windows.iterator();
				while(I1.hasNext())
				{
					String child_window=I1.next();
					if(!parentWindow.equals(child_window))
					{
						driver.switchTo().window(child_window);
						if(driver.getTitle().contains("Sprint Details"))
						{
							validation.validation(true, tc, "Mainspring Sprint Deatils Page Check");
						}
					}
				}
				SprintCreationPage sprintCreationPageObj=new SprintCreationPage();
				util.waitInSeconds(1);
				//boolean status=sprintCreationPageObj.saveSprint();
				driver.switchTo().window(parentWindow);
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				//validation.validation(status, tc, "Mainspring Sprint Creation Check");
			}
		}
		catch(Exception e)
		{
			validation.validation(false, tc, "Mainspring Create Sprint Page Check is Failed");
		}
	}

	@AfterClass
	public void ReleaseCreationPageTestScenarioTearDown()
	{
		scenario = null;
		validation=null;
	}

}
