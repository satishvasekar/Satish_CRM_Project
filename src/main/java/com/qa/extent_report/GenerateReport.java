/*package com.qa.extent_report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReport {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;

	public static void startExtent() {

		htmlReporter = new ExtentHtmlReporter(
				"D:\\Satish Softaware Backup\\Eclipse Worspace\\Satish_FreeCRM_Project_POM_1\\test-output\\MyExtentReport.html");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Functional report");
		htmlReporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReporter);

		report.setSystemInfo("Hostname", "LocalHost");
		report.setSystemInfo("OS", "Windows7");
		report.setSystemInfo("Tester Name", "Satish vasekar");
		report.setSystemInfo("Browser", "Chrome");
	}

	public void endReport() {
		report.flush();
	}
	
	public void Results(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL,"TEST CASE FAILED IS"+result.getName()); // to add name in the extent report
			test.log(Status.FAIL,"TEST CASE FAILED IS"+result.getThrowable()); // to add error/exceptions to the report
			
			String ScreenShotPath = GenerateReport.getScreenShot(driver ,result.getName());
			
			test.addScreencastFromPath(ScreenShotPath); // adding screenShot
		}
		else if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.SKIP,"TEST CASE SKIPPED IS"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS,"TEST CASE SKIPPED IS"+result.getName());
		}
	}
	
	public static String getScreenShot(WebDriver driver , String ScreenShotName) throws IOException{
		String datename = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = "D:\\Satish Softaware Backup\\Eclipse Worspace\\Satish_FreeCRM_Project_POM_1\\ScreenShots\\"+ScreenShotName+".png";
		File finaldestination = new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
		
		
	}

}
*/