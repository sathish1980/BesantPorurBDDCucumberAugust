package Elements;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonElements {
	
	
	public static void ClickOnBrowserBackButton(WebDriver browser)
	{
		browser.navigate().back();
	}
	public static void EnterText(WebElement element, String textToEnter)
	{
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(textToEnter);
		}
	}
	
	public static void ClickOnButton(WebElement element)
	{
		//if(element.isDisplayed())
		//{
			element.click();
		//}
	}
	
	public static String GetText(WebElement element)
	{
		if(element.isDisplayed())
		{
			return element.getText();
		}
		return null;
	}
	
	public static String GetAttribute(WebElement element,String expectedAttribute)
	{
		if(element.isDisplayed())
		{
			return element.getAttribute(expectedAttribute);
		}
		return null;
	}
	
	public static void WaitForElementvisible(WebDriver driver,By element,int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		
	}
	
	public static void WaitForElementtobeClickable(WebDriver driver,By element,int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static void WaitForElementisPresent(WebDriver driver,By element,int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		
	}
	
	public static String Screenshot(WebDriver driver,String filename)
	{
		TakesScreenshot tk =(TakesScreenshot) driver;
		File sourceFile = tk.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+filename+".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return destinationFile.toString();
	}
	
}
