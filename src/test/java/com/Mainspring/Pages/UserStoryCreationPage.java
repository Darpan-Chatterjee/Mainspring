package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Mainspring.Utilities.ExcelUtility;
import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class UserStoryCreationPage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String name,description,cardOwner,userStoryType,state,duedate,priority,theme,epic;
	String release,sprint,actualEndDt,storyPointAct,storyPointEst,resrcGrp,rank,saveNew,returnBtn;
	
	public UserStoryCreationPage() throws IOException
	{
		name=dataObj.getPropertyData("UserStoryCreationPage","name");
		description=dataObj.getPropertyData("UserStoryCreationPage","description");
		cardOwner=dataObj.getPropertyData("UserStoryCreationPage","cardOwner");
		userStoryType=dataObj.getPropertyData("UserStoryCreationPage","userStoryType");
		state=dataObj.getPropertyData("UserStoryCreationPage","state");
		duedate=dataObj.getPropertyData("UserStoryCreationPage","duedate");
		priority=dataObj.getPropertyData("UserStoryCreationPage","priority");
		theme=dataObj.getPropertyData("UserStoryCreationPage","theme");
		epic=dataObj.getPropertyData("UserStoryCreationPage","epic");
		release=dataObj.getPropertyData("UserStoryCreationPage","release");
		sprint=dataObj.getPropertyData("UserStoryCreationPage","sprint");
		actualEndDt=dataObj.getPropertyData("UserStoryCreationPage","actualEndDt");
		storyPointEst=dataObj.getPropertyData("UserStoryCreationPage","storyPointEst");
		storyPointAct=dataObj.getPropertyData("UserStoryCreationPage","storyPointAct");
		resrcGrp=dataObj.getPropertyData("UserStoryCreationPage","resrcGrp");
		rank=dataObj.getPropertyData("UserStoryCreationPage","rank");
		saveNew=dataObj.getPropertyData("UserStoryCreationPage","saveNew");
		returnBtn=dataObj.getPropertyData("UserStoryCreationPage","return");
	}
	
	public boolean saveUserDetails()
	{
		boolean status = false;
		try {
			excelDataList=ExcelUtility.GetExcelDataExtract(masterExcelWorkBookObj, "User Story");
			for(int index=0;index<excelDataList.size();index++)
			{
				/*driver.findElement(By.xpath(name)).click();
				driver.findElement(By.xpath(duedate)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(name)).sendKeys(excelDataList.get(index).get("Name"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(description)).click();
				driver.findElement(By.xpath(duedate)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(description)).sendKeys(excelDataList.get(index).get("Description"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(duedate)).click();
				driver.findElement(By.xpath(duedate)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(duedate)).sendKeys(excelDataList.get(index).get("Due Date"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(actualEndDt)).click();
				driver.findElement(By.xpath(duedate)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(actualEndDt)).sendKeys(excelDataList.get(index).get("Actual end Date"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath("//option[text()='"+excelDataList.get(index).get("Card Owner")+"']")).click();
				util.waitInSeconds(1);
				
				Select usrStryTyp= new Select(driver.findElement(By.xpath(userStoryType)));
				usrStryTyp.selectByVisibleText(excelDataList.get(index).get("User Story Type"));
				util.waitInSeconds(1);
				
				Select st= new Select(driver.findElement(By.xpath(state)));
				st.selectByVisibleText(excelDataList.get(index).get("State"));
				util.waitInSeconds(1);
				
				Select pt= new Select(driver.findElement(By.xpath(priority)));
				pt.selectByVisibleText(excelDataList.get(index).get("Priority"));
				util.waitInSeconds(1);
				
				Select rel= new Select(driver.findElement(By.xpath(release)));
				rel.selectByVisibleText(excelDataList.get(index).get("Release"));
				util.waitInSeconds(1);
				
				Select sp= new Select(driver.findElement(By.xpath(sprint)));
				sp.selectByVisibleText(excelDataList.get(index).get("Sprint"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(storyPointEst)).click();
				driver.findElement(By.xpath(storyPointEst)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(storyPointEst)).sendKeys(excelDataList.get(index).get("Estimate Story Points"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(storyPointAct)).click();
				driver.findElement(By.xpath(storyPointAct)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(storyPointAct)).sendKeys(excelDataList.get(index).get("Actual Story Points"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(rank)).click();
				driver.findElement(By.xpath(rank)).clear();
				util.waitInSeconds(1);
				driver.findElement(By.xpath(rank)).sendKeys(excelDataList.get(index).get("Rank"));
				util.waitInSeconds(1);
				
				Select rg= new Select(driver.findElement(By.xpath(resrcGrp)));
				rg.selectByVisibleText(excelDataList.get(index).get("Resource Group"));
				util.waitInSeconds(1);
				
				driver.findElement(By.xpath(saveNew)).click();
				util.waitInSeconds(5);*/
				status=true;	
			}	
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		driver.findElement(By.xpath(returnBtn)).click();
		return status;
	}
	

}
