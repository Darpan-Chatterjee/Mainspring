package com.Mainspring.Tests;

import org.testng.annotations.Test;

import com.Mainspring.core.BaseTest;

public class MainspringReleaseCreation extends BaseTest {
	
	@Test
	public void AddRelease()
	{
		driver.get("https://mainspring.cognizant.com");
	}

}
