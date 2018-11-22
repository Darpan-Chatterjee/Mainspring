package com.Mainspring.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Validations {
	WebDriver driver;
	Screenshots scrnsht;
	
	public Validations(WebDriver driver)
	{
		this.driver=driver;
		scrnsht=new Screenshots(driver);
	}
	
	public void validation(Boolean status,ExtentTest tc,String step) throws IOException
	{
		if(status)
		{
			//tc.pass(step,MediaEntityBuilder.createScreenCaptureFromPath(scrnsht.getScreenshot()).build());
			tc.pass(step,MediaEntityBuilder.createScreenCaptureFromPath(".\\Test Result\\Screenshot\\1.jpeg").build());
		}
		else
		{
			tc.fail(step,MediaEntityBuilder.createScreenCaptureFromPath(scrnsht.getScreenshot()).build());
		}
	}

}
