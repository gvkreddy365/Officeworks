package com.officeworks.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.officeworks.qa.base.TestBase;
import com.officeworks.qa.pages.HomePage;
import com.officeworks.qa.pages.LoginPage;
import com.officeworks.qa.util.TestUtil;

public class LoginPageTest extends TestBase
{

	LoginPage loginpage;
	HomePage homepage;
	String sheetName = "login";
	//this constructor calls the super class constructor which is in TestBase class
	public LoginPageTest()
	{
		super();
	}
	
	//initializes the setup from test base class
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	//Test to validate the login page title
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
	String loginpagetitle = loginpage.verifyLoginPageTitle();
	Assert.assertEquals(loginpagetitle, "Office Supplies, Stationery & Office Furniture at the Lowest Prices | Officeworks", "Login Page Title is not matched");
	}
	
	//Test to validate the company logo is displayed or not
	@Test(priority=2)
	public void validateLogo()
	{
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object [][] getLoginTestData()
	{
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	//Test to login the application. Successful login validation is done is homepagetest.java
	@Test(priority=3, dataProvider="getLoginTestData")
	public void loginTest(String username, String password)
	{
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = loginpage.login(username, password);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
