package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {

	// page Factory
	
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBttn;
		
		@FindBy(xpath="//a[contains(text(),'Sign Up')]")
		WebElement SignUpBttn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive') and @src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
	    WebElement CrmLogo;
		
		@FindBy(xpath="//a[contains(text(),'Customers')]")
		WebElement costumorsLink;
    

    public LoginPage(){
    	PageFactory.initElements(driver, this);
    }
    
    public String getTitle(){
    	  return driver.getTitle();       
    }
    
    public boolean verifyCrmLogo(){
    	return CrmLogo.isDisplayed();    	
    }
    
    public void verifysignUpBttn(){
    	SignUpBttn.click();
    }
    
    public boolean costumorsLink(){
    	costumorsLink.click();
    	return costumorsLink.isDisplayed();
    }
    
    public HomePage verifyLogin() throws InterruptedException{
    	username.sendKeys(pro.getProperty("username"));
    	password.sendKeys(pro.getProperty("password"));
        Thread.sleep(2000);
    	loginBttn.click();
    	
    	return new HomePage();
    }
    
    
    
}
    





