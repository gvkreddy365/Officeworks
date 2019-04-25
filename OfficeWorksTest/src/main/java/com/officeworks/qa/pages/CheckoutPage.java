package com.officeworks.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.officeworks.qa.base.TestBase;

public class CheckoutPage extends TestBase{

	
	@FindBy(xpath="//a[contains(text(),'iPhone XS Max 256GB Space Grey')]")
	WebElement item1;
	
	@FindBy(xpath="//a[contains(text(),'iPhone XS 64GB Space Grey')]")
	WebElement item2;
	
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyitem1text()
	{
		return item1.isDisplayed();
	}
	
	public boolean verifyitem2text()
	{
		return item2.isDisplayed();
	}
	
}
