package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtility;

public class HomePageTest extends TestBase   {

	

	LoginPage login;
	HomePage homepage;
	TestUtility utility;
	//GenerateReport extent;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		login = new LoginPage();
		login.verifyLogin();
		homepage = new HomePage();
		utility = new TestUtility();
		utility.SwicthTo();
	//	extent = new GenerateReport();
	}

	@Test
	public void verifyUsernameTitleTest() {
		homepage.verifyUsernameTitle();
		String Utitle = homepage.verifyUsernameTitle();
		Assert.assertEquals(Utitle, "Satish", "Username title does not machted");
	}

	@Test
	public void verifyContactsLinkTest() {
		homepage.verifyContactsLink();
		boolean b = homepage.ContactsTitleVerify();
		Assert.assertEquals(b, true);
	}

	@Test
	public void verifyCalenderLinkTest() {
		homepage.verifyCalenderLink();
	}

	@AfterMethod
	public void teaDown(){
		driver.quit();
	}
	
	

}
