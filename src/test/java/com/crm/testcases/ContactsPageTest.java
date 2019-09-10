package com.crm.testcases;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtility;

public class ContactsPageTest extends TestBase {

	LoginPage login;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtility utility;
	
	public ContactsPageTest(){
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
	}
	
	@DataProvider
	public Object[][] TestData() throws InvalidFormatException{
		Object[][] obj = TestUtility.getTestData("Contacts");
		return obj;
		
	}
	@Test(dataProvider="TestData")
	public void createContactsTest(String title,String Uname,String Mname,String Sname,String Nname,String compony,String position){
		homepage.verifyNewContactsLink();
		contactspage.createContact(title,Uname, Mname, Sname,Nname, compony, position);
	}
	
	@Test
	public void SelectContactTest()   {
        homepage.verifyContactsLink();
		contactspage.SelectContact("Sham tupe");
		contactspage.SelectContact("Priya Vinchu");
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
