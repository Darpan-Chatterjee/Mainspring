package com.Mainspring.Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Mainspring.Utilities.UtilityMethods;
import com.Mainspring.core.BaseTest;

public class ReleaseCreationPage extends BaseTest {
	
	UtilityMethods util= new UtilityMethods();
	String signIn=null;
	
	public ReleaseCreationPage() throws IOException
	{
		signIn=dataObj.getPropertyData("HomePage","SignIn");
	}
	
	public void clickSignIn()
	{
		driver.findElement(By.xpath(signIn)).click();
		util.waitInSeconds(2);
	}

}
