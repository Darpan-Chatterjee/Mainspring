package com.Mainspring.Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots{

	static int screenshotCount=0;
	private WebDriver driver;
	private String screenshotPath;

	public Screenshots(WebDriver driver)
	{
		this.driver=driver;
		screenshotPath=null;
	}

	public String getScreenshot()
	{
		screenshotCount++;
		try
		{
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("Test Result"+File.separator+"Screenshot"+File.separator+screenshotCount+".jpeg"));
			screenshotPath="."+File.separator+"Screenshot"+File.separator+screenshotCount+".jpeg";
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return screenshotPath;
	}

}
