package com.officeworks.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.officeworks.qa.base.TestBase;

public class IphoneAndMobilePhonesPage extends TestBase {

	@FindBy(xpath="//a[contains(@title,'View the iPhones category')]")
	WebElement iphonescategory;
	
	public IphoneAndMobilePhonesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyiphoneandmobilephonesTitle()
	{
		return driver.getTitle();
	}
	
	public IphonesPage selectiphones()
	{
		 
		 iphonescategory.click();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'Go to iPhone')]")));
		 return new IphonesPage();
	}
}
