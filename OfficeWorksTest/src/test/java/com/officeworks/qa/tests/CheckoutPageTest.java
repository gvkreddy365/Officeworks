package com.officeworks.qa.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.officeworks.qa.base.TestBase;
import com.officeworks.qa.pages.HomePage;
import com.officeworks.qa.pages.IphoneAndMobilePhonesPage;
import com.officeworks.qa.pages.LoginPage;
import com.officeworks.qa.pages.TechnologyPage;
import com.officeworks.qa.pages.IphonesPage;
import com.officeworks.qa.pages.CheckoutPage;

public class CheckoutPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	IphoneAndMobilePhonesPage iphoneandmobilephonespage;
	IphonesPage iphonespage;
	CheckoutPage checkoutpage;
	TechnologyPage technologypage;
	
	public CheckoutPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		iphonespage = new IphonesPage();
		checkoutpage = new CheckoutPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		technologypage= homepage.selectTechnologyOption();	
		iphoneandmobilephonespage=technologypage.selectiphoneandmobilephones();
		iphonespage=iphoneandmobilephonespage.selectiphones();
		checkoutpage = iphonespage.addToCart();
		
	}
	
	//Test to validate the checkout page title
	@Test (priority=1)
	public void verifyCheckoutPageTitleTest()
	{
		String CheckoutPageTitle = checkoutpage.verifyCheckoutPageTitle();
		Assert.assertEquals(CheckoutPageTitle, "Officeworks Checkout", "Checkout Page Title is not matched"); //this message is only displayed if the test case fails
	}
		
	@Test(priority=2)
	public void getitemtexttest()
	{
		Assert.assertTrue(checkoutpage.verifyitem1text());
		Assert.assertTrue(checkoutpage.verifyitem2text());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
