package com.SoftSuave.BustelSpotMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class SignOutFunctionality extends BaseClass{
	
	By signOutButton=By.xpath("//*[text()='Signout']");
	public void clickOnSignOut() throws InterruptedException
	{
		By clcikOnProfile=By.xpath("(//*[@class='MuiIconButton-label'])[2]");
		waitForElementClickable(clcikOnProfile);
		try {
		Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		
		//xpathPresent(clcikOnProfile);
		
		
		
//		WebElement element = driver.findElement(clcikOnProfile);
//
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(element).click().perform();
		
		WebElement profileClick=driver.findElement(clcikOnProfile);
		profileClick.click();
		//waitForElement(clcikOnProfile);
		driver.findElement(signOutButton).click();
		
		
	}
}
