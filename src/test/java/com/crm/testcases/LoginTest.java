package com.crm.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage login;
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		login = new LoginPage();
	}
	
	@Test
	public void verifyTitleTest(){
		String title = login.getTitle();
	    Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void verifyCrmLogoTest(){
		boolean b = login.verifyCrmLogo();
		Assert.assertEquals(b, true);
	}
	
	@Test
	public void verifysignUpBttnTest(){
		login.verifysignUpBttn();
	}
	
	@Test
	public void verifyCostumorsLinkTest() throws InterruptedException{
		Thread.sleep(3000);
		boolean b1 = login.costumorsLink();
		Assert.assertEquals(b1, true);
	}
	
	@Test
	public void LoginTest() throws InterruptedException{
		login.verifyLogin();
    	String title1 = driver.getTitle();
		Assert.assertEquals(title1, "CRMPRO");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
