package com.crm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;
import com.crm.utility.TestUtility;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//select[@name='title']")
	WebElement title1;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement username;

	@FindBy(xpath = "//input[@name='middle_initial']")
	WebElement middlename;

	@FindBy(xpath = "//input[@name='surname']")
	WebElement surname;

	@FindBy(xpath = "//input[@name='suffix']")
	WebElement suffix;

	@FindBy(xpath = "//input[@name='nickname']")
	WebElement nickname;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement componyName;

	@FindBy(xpath = "//input[@name='company_position']")
	WebElement Position;

	@FindBy(xpath = "//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBttn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void createContact(String title, String Uname, String Mname, String Sname, String Nname, String compony,
			String position) {

		Select s = new Select(title1);
		s.selectByVisibleText(title);

		username.sendKeys(Uname);
		middlename.sendKeys(Mname);
		surname.sendKeys(Sname);

		nickname.sendKeys(Nname);
		componyName.sendKeys(compony);
		Position.sendKeys(position);

		saveBttn.click();
	}

	public void SelectContact(String name)   {
		TestUtility utility = new TestUtility();
		utility.SelectContact1(name);
		}
	}


