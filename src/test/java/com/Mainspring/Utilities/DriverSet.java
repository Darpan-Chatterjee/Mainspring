package com.Mainspring.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSet {
	
	String browserPath;
	int timeOutLimit;
	
	public DriverSet(String browserPath,int timeOutLimit) {
		
		this.browserPath = browserPath;
		this.timeOutLimit = timeOutLimit;
	}
	public WebDriver openBrowser()
	{
		if(browserPath.toLowerCase().contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", browserPath);
		}
		else if(browserPath.toLowerCase().contains("gecko"))
		{
			System.setProperty("webdriver.gecko.driver", browserPath);
		}
		else
		{
			System.setProperty("webdriver.ie.driver", browserPath);
		}
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("disable-extensions");
		options.addArguments("disable-infobars");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(caps);
		driver.manage().timeouts().implicitlyWait(timeOutLimit, TimeUnit.SECONDS);
		return driver;
	}

}
