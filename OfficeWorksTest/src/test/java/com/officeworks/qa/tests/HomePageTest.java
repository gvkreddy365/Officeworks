package com.officeworks.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.officeworks.qa.base.TestBase;
import com.officeworks.qa.pages.HomePage;
import com.officeworks.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	//Creation of construction to assign the properties
	public HomePageTest()
	{
		super();
	}
	
	//This setup method helps to open the browser, launch the url, enter username and password and proceed to home page
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage =new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//Test to validate the home page title
	@Test (priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Office Supplies, Stationery & Office Furniture at the Lowest Prices | Officeworks", "Home Page Title is not matched"); //this message is only displayed if the test case fails
	}
	
	//Test to login and select the technology option
	@Test (priority=2)
	public void selectTechnologyOptionTest()
	{
		homepage.selectTechnologyOption();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
