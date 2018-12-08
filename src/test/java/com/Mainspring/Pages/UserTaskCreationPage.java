package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class UserTaskCreationPage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String name,stdCode,owner,estEffort,returnBtn;
	
	public UserTaskCreationPage() throws IOException
	{
		
		returnBtn=dataObj.getPropertyData("UserTaskCreationPage","return");
	}
	
	public boolean createTask(String storyName)
	{
		boolean status = false;
		try {
			if(storyName.contains("Distribution"))
			{
				excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "Task-Distribution");
				driver.switchTo().frame("eform_seg_10562241");
			}
			else if(storyName.contains("Marketing"))
			{
				excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "Task-Marketing");
				driver.switchTo().frame("eform_seg_10562241");
			}
			else if(storyName.contains("Investment"))
			{
				excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "Task-Investment");
				driver.switchTo().frame("eform_seg_10562241");
			}
			else if(storyName.contains("Digital"))
			{
				excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "Task-Digital");
				driver.switchTo().frame("eform_seg_10562241");
			}
			
			for(int index=0;index<excelDataList.size();index++)
			{
				driver.findElement(By.xpath("//button[@id='addRow'][text()='Add']")).click();
				
				/*Actions ac = new Actions(driver);
				ac.sendKeys(excelDataList.get(index).get("Name"));*/
				driver.switchTo().activeElement().sendKeys(excelDataList.get(index).get("Name"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath("//td[@role='gridcell'][contains(text(),'None')]")).click();
				util.waitInSeconds(1);
				Select stdCode= new Select(driver.findElement(By.xpath("//select[@name='activity_code_id']")));
				stdCode.selectByVisibleText(excelDataList.get(index).get("Standard Code"));
				util.waitInSeconds(3);
				
				driver.findElement(By.xpath("//td[@role='gridcell'][contains(text(),'UnAssigned')]")).click();
				util.waitInSeconds(1);
				Select owner = new Select(driver.switchTo().activeElement());
				owner.selectByVisibleText(excelDataList.get(index).get("To-Do Owner"));
				util.waitInSeconds(1);
				
				driver.switchTo().activeElement().sendKeys(Keys.TAB);
				util.waitInSeconds(2);
				driver.findElement(By.xpath("//input[@name='estimate']")).sendKeys(Keys.CONTROL + "a");
				util.waitInSeconds(1);
				
				/*driver.findElement(By.xpath("//td[@role='gridcell'][text()='Open']")).click();
				util.waitInSeconds(3);*/
				
				/*driver.findElements(By.xpath("//td[@role='gridcell'][contains(text(),'8')]")).get(0).click();
				util.waitInSeconds(2);
				driver.findElement(By.xpath("//input[@name='estimate']")).click();*/
			
				/*Actions ac = new Actions(driver);
				ac.moveToElement(driver.findElement(By.xpath("//input[@name='estimate']"))).sendKeys(Keys.CONTROL + "a").build().perform();
				driver.switchTo().defaultContent();*/
				driver.findElement(By.xpath("//input[@name='estimate']")).sendKeys(excelDataList.get(index).get("Estimated Effort"));
				util.waitInSeconds(1);
				
				status=true;	
			}	
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(returnBtn)).click();
		util.waitInSeconds(3);
		return status;
	}
	

}
