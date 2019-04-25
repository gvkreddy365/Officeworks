package com.officeworks.qa.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.officeworks.qa.base.TestBase;
import com.officeworks.qa.pages.HomePage;
import com.officeworks.qa.pages.LoginPage;
import com.officeworks.qa.pages.TechnologyPage;
import com.officeworks.qa.pages.IphoneAndMobilePhonesPage;

public class IphoneAndMobilePhonesPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TechnologyPage technologypage;
	IphoneAndMobilePhonesPage iphoneandmobilephonespage;
	
	public IphoneAndMobilePhonesPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage =new HomePage();
		technologypage = new TechnologyPage();
		iphoneandmobilephonespage = new IphoneAndMobilePhonesPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		technologypage = homepage.selectTechnologyOption();
		iphoneandmobilephonespage=technologypage.selectiphoneandmobilephones();
	}	
	
	//Test to validate the technology page title
	@Test (priority=1)
	public void verifyiphoneandmobilephonesTitleTest()
	{
		String iphoneandmobilephonespageTitle = iphoneandmobilephonespage.verifyiphoneandmobilephonesTitle();
		Assert.assertEquals(iphoneandmobilephonespageTitle, "iPhones & Mobile Phones | Officeworks", "iPhone and Mobile phones Page Title is not matched"); //this message is only displayed if the test case fails
	}
	
	@Test (priority=2)
	public void selectiphonesTest()
	{
		iphoneandmobilephonespage.selectiphones();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
