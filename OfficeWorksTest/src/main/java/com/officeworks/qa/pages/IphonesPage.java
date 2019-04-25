package com.officeworks.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.officeworks.qa.base.TestBase;

public class IphonesPage extends TestBase {
	
	Actions act;
	@FindBy(xpath="//button[contains(@data-ref,'add-to-cart-button-IPXSP256SG')]")
	WebElement addtocart1;
	
	@FindBy(xpath="//button[contains(@data-ref,'add-to-cart-button-IPXS64SG')]")
	WebElement addtocart2;
	
	@FindBy(xpath="//div[contains(@data-ref,'counter')]")
	WebElement cartlink;
	
	@FindBy(xpath="//button[contains(text(),'View Cart & Checkout')]")
	WebElement checkout;
	
	public IphonesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyIphonesPageTitle()
	{
		return driver.getTitle();
	}
	
	public CheckoutPage addToCart()
	{
		addtocart1.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(addtocart2));
		addtocart2.click();
		act = new Actions(driver);
		act.clickAndHold(cartlink).build().perform();
		act.moveToElement(checkout).click().build().perform();
		return new CheckoutPage();
	}

}
