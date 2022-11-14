package testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class baseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChropath());
			driver= new ChromeDriver();
		}else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver= new FirefoxDriver();
		}else if(br.equals("msedge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getedgepath());
			driver= new EdgeDriver();
		}

		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
