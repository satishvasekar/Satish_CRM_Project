package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties pro;
	public static WebDriver driver;
	public TestBase(){
		
		 try {
			pro = new Properties();
			 
			 FileInputStream fis = new FileInputStream("D:\\Satish Softaware Backup\\Eclipse Worspace\\Satish_FreeCRM_Project_POM\\src\\main\\java\\com\\crm\\config\\config.properties");
			 
			 pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization(){
		String browsername = pro.getProperty("browser");
		
		System.out.println(browsername);
		
		if(browsername.equalsIgnoreCase("Chrome")){
			 System.setProperty("webdriver.chrome.driver",
				"D:\\Satish Softaware Backup\\Eclipse Worspace\\SeleniumWebDriver\\src\\driver2\\chromedriver.exe");
			  driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",
		    	"D:\\Satish Softaware Backup\\Eclipse Worspace\\SeleniumWebDriver\\src\\driver2\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}

}
