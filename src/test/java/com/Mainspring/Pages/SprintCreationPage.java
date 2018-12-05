package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class SprintCreationPage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String name,description,sprintType,startDt,endDt,release,responsibility,save,returnBtn;
	
	public SprintCreationPage() throws IOException
	{
		name=dataObj.getPropertyData("SprintCreationPage","name");
		description=dataObj.getPropertyData("SprintCreationPage","description");
		sprintType=dataObj.getPropertyData("SprintCreationPage","sprintType");
		startDt=dataObj.getPropertyData("SprintCreationPage","startDt");
		endDt=dataObj.getPropertyData("SprintCreationPage","endDt");
		release=dataObj.getPropertyData("SprintCreationPage","release");
		responsibility=dataObj.getPropertyData("SprintCreationPage","responsibility");
		save=dataObj.getPropertyData("SprintCreationPage","save");
		returnBtn=dataObj.getPropertyData("SprintCreationPage","return");
	}
	
	public boolean saveSprint()
	{
		boolean status = false;
		try {
			excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "Sprint");
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
				
				Select sprntType= new Select(driver.findElement(By.xpath(sprintType)));
				sprntType.selectByVisibleText(excelDataList.get(index).get("SprintType"));
				util.waitInSeconds(1);
				
				Select rel= new Select(driver.findElement(By.xpath(release)));
				rel.selectByVisibleText(excelDataList.get(index).get("Release"));
				util.waitInSeconds(1);
								
				Select res= new Select(driver.findElement(By.xpath(responsibility)));
				res.selectByVisibleText(excelDataList.get(index).get("Responsibility"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(save)).click();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(returnBtn)).click();
				status=true;	
			}	
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	

}
