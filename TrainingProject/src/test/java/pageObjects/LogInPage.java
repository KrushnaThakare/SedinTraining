package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

	WebDriver ldriver;

	public LogInPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="ap_email")
	WebElement emailId;

	@FindBy(id="continue")
	WebElement continueBtn;

	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signInBtn;
	
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	
	@FindBy(id="twotabsearchtextbox")  //  nav-search-field 
	WebElement searchBar;
	
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> mob;
	
	public void setUsername(String userId)
	{
		emailId.sendKeys(userId);
	}

	public void setPassword(String passw)
	{
		password.sendKeys(passw);
	}
	public void clickContinue()
	{
		continueBtn.click();
	}
	public void clickLogIn()
	{
		signInBtn.click();
	}
	
	public boolean checkLogo()
	{
		Boolean Display=logo.isDisplayed();
		return Display;
	}
	public void searchMob(String s)
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		
		//JavascriptExecutor executor = (JavascriptExecutor) ldriver;
	    //executor.executeScript("arguments[0].scrollIntoView(true);", searchBar);
		searchBar.sendKeys(s);
		searchButton.click();
	}
	
	public void mobNames()
	{
		for(WebElement name:mob)
		{
			System.out.println(name.getText());
		}
		
	}
	
	


}
