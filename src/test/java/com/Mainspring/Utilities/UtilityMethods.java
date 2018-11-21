package com.Mainspring.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	
	public WebElement WaitForElement(WebDriver driver,By locator)
	{
		WebElement el=null;
		WebDriverWait wt= new WebDriverWait(driver, 20);
		el=wt.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return el;
	}
	
	public void waitInSeconds(int sec)
	{
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteScreenshots() throws IOException
	{
		if(new File("TestResult"+File.separator+"Screenshot").exists())
		{
			FileUtils.deleteDirectory(new File("TestResult"+File.separator+"Screenshot"));
			new File("TestResult"+File.separator+"Screenshot").mkdir();
		}
		else
		{
			new File("TestResult"+File.separator+"Screenshot").mkdir();
		}
	}

}
