package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.baseClass;

public class ExtentReport extends TestListenerAdapter{

	public static  ExtentSparkReporter htmlreporter;
	public static  ExtentReports extent;
	public static  ExtentTest test;


	@BeforeTest
	public void setExtent()
	{
		htmlreporter =new ExtentSparkReporter(System.getProperty("user.dir"+"/test-output/myreport.html"));
		
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Functional Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		
		extent.setSystemInfo("Host", "Local Host");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Krushna");
		extent.setSystemInfo("Browser", "Chrome");



	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Fail", ExtentColor.RED));
			
			String screenshotpath = ExtentReport.takeScreenShot(baseClass.driver, result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case Skipped is "+ result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Pass", ExtentColor.GREEN));
		}
	}
	
	public static String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+screenshotName+ dateName +".png";
		File finalDesination = new File(destination);
		FileUtils.copyFile(src, finalDesination);
		return destination;
		
	}

}