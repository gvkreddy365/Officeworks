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

public class IphonesPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TechnologyPage technologypage;
	IphoneAndMobilePhonesPage iphoneandmobilephonespage;
	IphonesPage iphonespage;
	
	public IphonesPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage=new HomePage();
		technologypage=new TechnologyPage();
		iphoneandmobilephonespage = new IphoneAndMobilePhonesPage();
		iphonespage = new IphonesPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		technologypage = homepage.selectTechnologyOption();
		iphoneandmobilephonespage = technologypage.selectiphoneandmobilephones();
		iphonespage = iphoneandmobilephonespage.selectiphones();
	}
	
	//Test to validate the iphone page title
	@Test (priority=1)
	public void verifyIphonesPageTitleTest()
	{
		String iphonespageTitle = iphonespage.verifyIphonesPageTitle();
		Assert.assertEquals(iphonespageTitle, "iPhones | Officeworks", "iPhones Page Title is not matched"); //this message is only displayed if the test case fails
	}
	
	@Test(priority=2)
	public void addToCartTest()
	{
		iphonespage.addToCart();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
