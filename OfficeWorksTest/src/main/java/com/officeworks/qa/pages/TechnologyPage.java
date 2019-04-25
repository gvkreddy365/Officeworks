package com.officeworks.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.officeworks.qa.base.TestBase;

public class TechnologyPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'iPhones & Mobile Phones')]")
	WebElement allphones;
	
	@FindBy(xpath="//a[contains(@title,'View the iPhones category')]")
	WebElement iphonescategory;
	
	public TechnologyPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTechnologyPageTitle()
	{
		return driver.getTitle();
	}
	
	public IphoneAndMobilePhonesPage selectiphoneandmobilephones()
	{
		 allphones.click();
		 WebDriverWait wait = new WebDriverWait(driver, 30);
	     wait.until(ExpectedConditions.elementToBeClickable(iphonescategory));
		 return new IphoneAndMobilePhonesPage();	 
	}
}


