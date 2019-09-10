package com.crm.testcases;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtility;

public class DealsPageTest extends TestBase {

	
	LoginPage login;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtility utility;
	DealsPage dealspage;
	
	public DealsPageTest(){
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
    }
	
	@DataProvider
	public Object[][] TestData() throws InvalidFormatException{
		Object[][] obj1 = TestUtility.getTestData("Deals");
		return obj1;
	}
	
	@Test(dataProvider="TestData")
	public void NewDealsTest(String title1,String compony1, String Pcontact1, String ammount1, String probability1, String commission1 ) throws InterruptedException{
		homepage.NewDelsLink();
		dealspage.NewDeaal(title1, compony1, Pcontact1, ammount1, probability1, commission1);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}













