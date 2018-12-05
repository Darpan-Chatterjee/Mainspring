package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class ReleaseCreationPage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String menu=null;
	String workspace,myworkspace=null,project,release;
	String addRelease;
	String name,description,releaseType,startDt,endDt,typeOfTesting,priority,responsibility,save,returnBtn;
	
	public ReleaseCreationPage() throws IOException
	{
		menu=dataObj.getPropertyData("ReleaseCreationPage","menu");
		workspace=dataObj.getPropertyData("ReleaseCreationPage","workspace");
		myworkspace=dataObj.getPropertyData("ReleaseCreationPage","myworkspace");
		project=dataObj.getPropertyData("ReleaseCreationPage","project");
		release=dataObj.getPropertyData("ReleaseCreationPage","release");
		addRelease=dataObj.getPropertyData("ReleaseCreationPage","addRelease");
		
		name=dataObj.getPropertyData("ReleaseCreationPage","name");
		description=dataObj.getPropertyData("ReleaseCreationPage","description");
		releaseType=dataObj.getPropertyData("ReleaseCreationPage","releaseType");
		startDt=dataObj.getPropertyData("ReleaseCreationPage","startDt");
		endDt=dataObj.getPropertyData("ReleaseCreationPage","endDt");
		typeOfTesting=dataObj.getPropertyData("ReleaseCreationPage","typeOfTesting");
		priority=dataObj.getPropertyData("ReleaseCreationPage","priority");
		responsibility=dataObj.getPropertyData("ReleaseCreationPage","responsibility");
		save=dataObj.getPropertyData("ReleaseCreationPage","save");
		returnBtn=dataObj.getPropertyData("ReleaseCreationPage","return");
	}
	
	public void clickWorkspace()
	{
		driver.findElement(By.xpath(workspace)).click();
		util.waitInSeconds(1);
	}
	public void clickMyWorkspace()
	{
		driver.findElement(By.xpath(myworkspace)).click();
		util.waitInSeconds(1);
	}
	public void clickProject()
	{
		driver.findElement(By.xpath(project)).click();
		util.waitInSeconds(1);
	}
	public void clickRelease()
	{
		driver.findElement(By.xpath(release)).click();
		util.waitInSeconds(1);
	}
	public void clickAddReleaseButton()
	{
		driver.findElement(By.xpath(addRelease)).click();
		util.waitInSeconds(3);
	}
	public boolean saveRelease()
	{
		boolean status = false;
		try {
			excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "Release");
			driver.switchTo().frame("contentframe");
			for(int index=0;index<excelDataList.size();index++)
			{
				driver.findElement(By.xpath(name)).click();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(name)).sendKeys(excelDataList.get(index).get("Name"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(description)).click();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(description)).sendKeys(excelDataList.get(index).get("Description"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(startDt)).click();
				driver.findElement(By.xpath(startDt)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(startDt)).sendKeys(excelDataList.get(index).get("Start Date"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(endDt)).click();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(endDt)).sendKeys(excelDataList.get(index).get("End Date"));
				util.waitInSeconds(1);
				
				Select relType= new Select(driver.findElement(By.xpath(releaseType)));
				relType.selectByVisibleText(excelDataList.get(index).get("Release Type"));
				util.waitInSeconds(1);
				
				Select typTest= new Select(driver.findElement(By.xpath(typeOfTesting)));
				typTest.selectByVisibleText(excelDataList.get(index).get("Type Of Testing"));
				util.waitInSeconds(1);
				
				Select prio= new Select(driver.findElement(By.xpath(priority)));
				prio.selectByVisibleText(excelDataList.get(index).get("Priority"));
				util.waitInSeconds(1);
				
				Select res= new Select(driver.findElement(By.xpath(responsibility)));
				res.selectByVisibleText(excelDataList.get(index).get("Responsibility"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(save)).click();
				status=true;	
			}
			driver.switchTo().defaultContent();
			
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	

}
