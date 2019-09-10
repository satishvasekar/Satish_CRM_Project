package com.crm.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.CalendersPage;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtility;

public class CalendersPageTest extends TestBase {

	LoginPage login;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtility utility;
	DealsPage dealspage;
	CalendersPage calenderpage;
	
	public CalendersPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();
		login = new LoginPage();
		login.verifyLogin();
		homepage = new HomePage();
		utility = new TestUtility();
		utility.SwicthTo();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		calenderpage = new CalendersPage();
    }
	
	@Test
	public void CalenderPageTest(){
		homepage.CalenderLinkVerify();
		calenderpage.ClickOnDate("31-July");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
