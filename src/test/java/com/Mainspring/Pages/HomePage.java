package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class HomePage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String signIn=null;
	
	public HomePage() throws IOException
	{
		signIn=dataObj.getPropertyData("HomePage","SignIn");
	}
	
	public void click()
	{
		driver.findElement(By.xpath(signIn)).click();
		util.waitInSeconds(2);
	}

}
