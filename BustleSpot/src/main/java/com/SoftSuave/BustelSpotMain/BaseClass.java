package com.SoftSuave.BustelSpotMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void driverInitialization() throws IOException{
	initilization();
	}


	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	

	public static void initilization() throws IOException{
		prop=new Properties();
		fis=new FileInputStream("C:\\Users\\Divyanshu\\git\\repository\\BustleSpot\\src\\main\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
	
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();	
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	
	
	public void waitForElement(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
	}
	
	
	public void waitForElementClickable(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	
	}
	
	public WebElement returnWebElement(By locator)
	{
	WebElement ele = driver.findElement(locator);
	return ele;
	}
	
	
	public boolean xpathPresent(By element)
	{
		boolean flag=false;

			try 
			{
				driver.findElement(element);
				flag=true;
			}
			catch(Exception e) 
			{
				
			}
		return flag;
	}
	public static void takeSnapShot(String fileWithPath) throws Exception{

	      TakesScreenshot scrShot =((TakesScreenshot)driver);
	      File SrcFile= scrShot.getScreenshotAs(OutputType.FILE);
	      File DestFile=new File(fileWithPath);
	      FileUtils.copyFile(SrcFile, DestFile);

	    }
	@AfterSuite
	public void close()
	{
		driver.quit();
	}
	

}
