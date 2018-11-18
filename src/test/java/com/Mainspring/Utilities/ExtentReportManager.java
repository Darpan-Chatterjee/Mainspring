package com.Mainspring.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	
   static ExtentHtmlReporter htmlReporter;
   static ExtentReports extentReport;
    
    /*public ExtentReportManager() throws IOException
    {
    	htmlReporter = new ExtentHtmlReporter("./Test Result/Consolidated.html");
    	extentReport = new ExtentReports();
    	extentReport.attachReporter(htmlReporter);
    	// creates a toggle for the given test, adds all log events under it    
        ExtentTest scenario1 = extentReport.createTest("Scenario1", "This is Scenario1");	        
        
        ExtentTest testCase11 = scenario1.createNode("Test Case 1 of Scenario 1","This is Test Case 1 of Scenario 1");
        testCase11.pass("Test Case1 of Scenario 1 is Passed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());
        
        ExtentTest testCase12 = scenario1.createNode("Test Case 2 of Scenario 1","This is Test Case 2 of Scenario 1");
        testCase12.fail("Test Case2 is Failed of Scenario 1",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());

     // creates a toggle for the given test, adds all log events under it    
        ExtentTest scenario2 = extentReport.createTest("Scenario2", "This is Scenario2");
        
        ExtentTest testCase21 = scenario2.createNode("Test Case 1 of Scenario 2","This is Test Case 1 of Scenario 2");
        testCase21.pass("Test Case1 is Passed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());
        
        ExtentTest testCase22 = scenario2.createNode("Test Case 2 of Scenario 2","This is Test Case 2 of Scenario 2");
        testCase22.pass("Test Case1 is Passed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DARPAN\\Desktop\\IMG_20181018_193746.jpg").build());

        extentReport.flush();
    }*/
    
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
