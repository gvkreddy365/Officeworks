package com.officeworks.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.officeworks.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory or object repository of login page must be defined at first
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//button[contains(@class,'Button__BaseButton-e6xond-0 juspqu sc-iwsKbI eZvjeJ sc-dnqmqq GcbgT')]")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[contains(@class,'Header__LogoImage-xqjjg8-4 jpSRJV')]")
	WebElement companyLogo;
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}

	public boolean validateLogo()
	{
		return companyLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
	     Actions act = new Actions(driver);
	     act.sendKeys(Keys.TAB).build().perform();
	     act.sendKeys(pwd).build().perform();
		loginbutton.click();
		return new HomePage();
	}
	
	
	
	

}
