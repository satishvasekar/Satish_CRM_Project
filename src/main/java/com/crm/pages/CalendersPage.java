package com.crm.pages;

import com.crm.base.TestBase;
import com.crm.utility.TestUtility;

public class CalendersPage extends TestBase {

	TestUtility utilty;
	public void ClickOnDate(String Date){
		
		utilty = new TestUtility();
		
		utilty.SelectDate(Date);
	}
	
}
