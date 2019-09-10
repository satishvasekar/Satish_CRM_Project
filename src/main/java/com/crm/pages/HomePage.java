package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.crm.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),' SAtish vasekar ')]")
	WebElement UsernameTitle;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement NewDealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Calendar') ]//parent::li")
	WebElement CalenderLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact') ]")
	WebElement NewContactsLink;
	
	@FindBy(xpath="//td[contains(text(),'Contacts') ]")
	WebElement ContactsTitle;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUsernameTitle(){
		return UsernameTitle.getText();
	}
	
	public ContactsPage verifyContactsLink(){
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage DealsLink(){
		DealsLink.click();
		return new DealsPage();
	}
	
	public CalendersPage verifyCalenderLink(){
		CalenderLink.click();
		return new CalendersPage();
	}
	
	public void verifyNewContactsLink(){
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactsLink.click();		
	}
	
	public boolean ContactsTitleVerify(){
		return ContactsTitle.isDisplayed();
	}
	
	public void NewDelsLink(){
		Actions action1 = new Actions(driver);
		action1.moveToElement(DealsLink).build().perform();
		NewDealsLink.click();
	}
	
	public CalendersPage CalenderLinkVerify(){
		CalenderLink.click();
		return new CalendersPage();
	}
	
	
	
 	
	
}
