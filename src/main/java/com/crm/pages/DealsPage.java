package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class DealsPage extends TestBase  {

	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement compony;
	
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement Pcontact;
	
	@FindBy(xpath="//input[@name='amount']")
	WebElement ammount;
	
	@FindBy(xpath="//input[@name='probability']")
	WebElement probability;
	
	@FindBy(xpath="//input[@name='commission']")
	WebElement commission;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[1]/td/input[1]")
	WebElement saveBtton;
	
	public DealsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void NewDeaal(String title1,String compony1, String Pcontact1,String ammount1, String probability1, String commission1) throws InterruptedException{
		title.sendKeys(title1);
		compony.sendKeys(compony1);
		Pcontact.sendKeys(Pcontact1);
		ammount.sendKeys(ammount1);
		probability.sendKeys(probability1);
		commission.sendKeys(commission1);
		Thread.sleep(2000);
		saveBtton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
