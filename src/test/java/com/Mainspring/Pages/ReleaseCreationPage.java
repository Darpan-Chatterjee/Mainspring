package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class ReleaseCreationPage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String menu=null;
	String workspace,myworkspace=null,project,release;
	
	public ReleaseCreationPage() throws IOException
	{
		menu=dataObj.getPropertyData("ReleaseCreationPage","menu");
		workspace=dataObj.getPropertyData("ReleaseCreationPage","workspace");
		myworkspace=dataObj.getPropertyData("ReleaseCreationPage","myworkspace");
		project=dataObj.getPropertyData("ReleaseCreationPage","project");
		release=dataObj.getPropertyData("ReleaseCreationPage","release");
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
	

}
