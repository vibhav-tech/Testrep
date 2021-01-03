package com.xyz.test.extentreport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_rep 
{
	ExtentReports report;
	ExtentTest logger;
	WebDriver d;
	@Test
	public void VerifyblogTitle()
	{
		report=new ExtentReports("H:\\Eclipse workspace\\extent_report\\Report_of_run.html");
		logger=report.startTest("This is Title of the Report");
		System.setProperty("webdriver.chrome.driver","H:\\Eclipse workspace\\vibhav\\chromedriver_win32\\chromedriver.exe");
	     d=new ChromeDriver();
	     d.manage().window().maximize();
	     d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	     logger.log(LogStatus.INFO, "Browser started");
	     d.get("https://www.orangehrm.com");
	     logger.log(LogStatus.INFO, "Site Launch Success");
	     String title=d.getTitle();
	     System.out.println(d.getTitle());
	     Assert.assertTrue(title.contains("HR Management Software"));
	     logger.log(LogStatus.INFO, "Title checking done");
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Title verification failed");
		}
		report.endTest(logger);
		report.flush();
		d.get("H:\\Eclipse workspace\\extent_report\\Report_of_run.html");
	}

}
