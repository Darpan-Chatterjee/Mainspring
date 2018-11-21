package com.Mainspring.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

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
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("TestResult"+File.separator+"Screenshot"+File.separator+screenshotCount+".jpeg"));
			screenshotPath="TestResult"+File.separator+"Screenshot"+File.separator+screenshotCount+".jpeg";
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return screenshotPath;
	}

}
