package com.Mainspring.Tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.Mainspring.core.BaseTest;

public class MainspringReleaseCreation extends BaseTest {
	
	@Test
	public void AddRelease()
	{
		ArrayList<HashMap<String,String>> dataList =excelUtil.GetExcelDataExtract(masterExcel, "Release");
		driver.get("https://mainspring.cognizant.com");
	}

}
