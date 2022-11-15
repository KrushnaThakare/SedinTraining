package testCases;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import testCases.TC_LogIn_001;
import utilities.ExtentReport;


public class TC_LogIn_001 extends baseClass{

	
	@Test
	public void LogInTest() throws InterruptedException
	{

		ExtentReport.test=ExtentReport.extent.createTest("LogInTest");
		LogInPage lp= new LogInPage(driver);
		lp.setUsername(username);
		lp.clickContinue();
		lp.setPassword(password);
		lp.clickLogIn();

		Thread.sleep(5000);
		String title=driver.getTitle();
		System.out.println(title);


		if(title.equalsIgnoreCase("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			assertTrue(true);;
		}
		else {
			assertTrue(false);
		}
	}
	
	@Test
	public void logoDisplayed() throws InterruptedException
	{
		LogInPage lp= new LogInPage(driver);
		lp.setUsername(username);
		lp.clickContinue();
		lp.setPassword(password);
		lp.clickLogIn();
		Thread.sleep(5000);
		if(lp.checkLogo()==true)
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void searchMobile() throws InterruptedException
	{
		LogInPage lp= new LogInPage(driver);
		lp.setUsername(username);
		lp.clickContinue();
		lp.setPassword(password);
		lp.clickLogIn();
		Thread.sleep(5000);
		
		lp.searchMob("Iphone13");
		lp.mobNames();
		assertTrue(true);
	}
	
	
	
}
