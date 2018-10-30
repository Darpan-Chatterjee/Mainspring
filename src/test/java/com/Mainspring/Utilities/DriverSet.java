package com.Mainspring.Utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSet {
	
	String browserPath;
	int timeOutLimit;
	
	public DriverSet() throws IOException {
		PropertyFileData dataObj= new PropertyFileData();
		Properties prop= dataObj.getPropertyData("AutomationConfig");
		
		this.browserPath = prop.getProperty("ChromePath");
		this.timeOutLimit = Integer.parseInt(prop.getProperty("AutomationTimeout"));
	}
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", browserPath);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("disable-extensions");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(caps);
		driver.manage().timeouts().implicitlyWait(timeOutLimit, TimeUnit.SECONDS);
		driver.get("https://mainspring.cognizant.com");
	}

}
