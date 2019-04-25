package com.officeworks.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.officeworks.qa.base.TestBase;
import com.officeworks.qa.pages.HomePage;
import com.officeworks.qa.pages.LoginPage;
import com.officeworks.qa.pages.TechnologyPage;

public class TechnologyPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TechnologyPage technologypage;
	
	//Creation of construction to assign the properties
	public TechnologyPageTest()
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
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		technologypage = homepage.selectTechnologyOption();
	}	
	
	//Test to validate the technology page title
	@Test (priority=1)
	public void verifyTechnologyPageTitleTest()
	{
		String technologypageTitle = technologypage.verifyTechnologyPageTitle();
		Assert.assertEquals(technologypageTitle, "Technology | Officeworks", "Technology Page Title is not matched"); //this message is only displayed if the test case fails
	}
		
	@Test(priority=2)
	public void selectiphoneandmobilephonesTest()
	{
		technologypage.selectiphoneandmobilephones();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
