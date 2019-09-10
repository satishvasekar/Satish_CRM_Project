package com.crm.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.base.TestBase;

public class CustomizedLisner extends TestBase  implements ITestListener {

	public void onTestStart(ITestResult result) {
              System.out.println(result.getMethod()+"---->Test case started execution ");		
	}

	public void onTestSuccess(ITestResult result) {
              System.out.println(result.getMethod()+"---->Test case executed successfully ");		
	}

	public void onTestFailure(ITestResult result) {
              System.out.println(result.getName()+"----> Test case failed");
              
          		//take screenShot 
          		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          		// Store the screenShot 
          		try {
					FileUtils.copyFile(src, new File("D:\\Satish Eclipse Workspace\\EclipseWorkspace_1\\Satish_CRM_Project\\ScreenShots"+result.getName()+".jpg"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}

	public void onTestSkipped(ITestResult result) {
              System.out.println(result.getMethod()+"Test case Skipped");    
               		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
