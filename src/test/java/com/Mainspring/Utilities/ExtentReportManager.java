package com.Mainspring.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	
   static ExtentHtmlReporter htmlReporter;
   static ExtentReports extentReport;
 
    public static void startTest()
    {
    	htmlReporter = new ExtentHtmlReporter("./Test Result/Consolidated.html");
    	extentReport = new ExtentReports();
    	extentReport.attachReporter(htmlReporter);
    }
    
    public static ExtentTest createScenario(String scName,String scDesc)
    {
    	ExtentTest scenario = extentReport.createTest(scName, scDesc);
    	return scenario;
    }
    
    public static ExtentTest createTestCase(ExtentTest scenario,String tcName,String tcDesc)
    {
    	ExtentTest testCase = scenario.createNode(tcName,tcDesc);
    	return testCase;
    }
    
    public static void endTest()
    {
    	extentReport.flush();
    }
}
