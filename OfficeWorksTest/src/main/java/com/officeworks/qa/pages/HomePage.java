package com.officeworks.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.officeworks.qa.base.TestBase;

public class HomePage extends TestBase 
{
	Actions act;
	
	
	@FindBy(xpath="//a[contains(text(),'Technology')]")
	WebElement technologypage;
	
	@FindBy(xpath="//a[contains(text(),'iPhones & Mobile Phones')]")
	WebElement allphones;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public TechnologyPage selectTechnologyOption() 
	{
		 technologypage.click();
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(allphones));
		 return new TechnologyPage();
	}
}
