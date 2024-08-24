package Drivers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.PropertyFileRead;

public class BrowserDriver {
	public static WebDriver browser;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	    //helps to generate the logs in test report.
	public static ExtentTest test;
	
	public void launchTheBrowser() throws IOException
	{	
		String browserName = PropertyFileRead.ReadEnvData().getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		browser= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		browser = new FirefoxDriver();
		}
		else
		{
		browser = new EdgeDriver();
		}
		
		browser.manage().window().maximize();
		reportOpen();
	}
	
	
	public void CloseTheBrowser()
	{
		if(browser!=null)
		{
			browser.quit();
		}
		reportclose();
	}

	
	public void reportOpen()
	{
		String reportpath = System.getProperty("user.dir")+"\\Reports\\selenium.html";
		htmlReporter = new ExtentSparkReporter(reportpath);
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	}
	
	public void reportclose()
	{
		extent.flush();
	}
}
