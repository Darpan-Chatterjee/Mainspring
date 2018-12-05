package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class CognizantLoginPage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String userid=null;
	String pwd=null;
	String login=null;
	
	public CognizantLoginPage() throws IOException
	{
		userid=dataObj.getPropertyData("CognizantLoginPage","userId");
		pwd=dataObj.getPropertyData("CognizantLoginPage","password");
		login=dataObj.getPropertyData("CognizantLoginPage","login");
	}
	
	public void clickLogin()
	{
		driver.findElement(By.xpath(userid)).clear();
		util.waitInSeconds(1);
		driver.findElement(By.xpath(pwd)).clear();
		util.waitInSeconds(1);
		driver.findElement(By.xpath(userid)).sendKeys("212772");
		util.waitInSeconds(1);
		driver.findElement(By.xpath(pwd)).sendKeys("TabuPutu11#");
		util.waitInSeconds(4);
		driver.findElement(By.xpath(login)).click();
	}

}
