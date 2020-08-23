package com.SoftSuave.BustelSpotMain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class SignUpText extends BaseClass{
	
	int n=0;
	By signUpLink=By.xpath("//a[@class='jss84' and text()='Sign Up']");
	By email=By.xpath("//input[@name='email-id']");
	By fullName=By.xpath("//input[@name='first-name']");
	By pass=By.xpath("//input[@name='password']");
	By confirmPass=By.xpath("//input[@name='confirm-password']");
	By signUpButton=By.xpath("//button[.='Sign Up']");
	
	By statusMsg = By.xpath("//div[@class='message-sec']/p");
	
	By errorText=By.xpath("(//label[@class='jss77'])");
	public void sizeText()
	{
		List<WebElement> ele=driver.findElements(errorText);
		n=ele.size();
		System.out.println(n);
		
	}
	public void getText()
	{
		
		for(int i=1;i<=n;i++)
		{
			
			String element=driver.findElement(By.xpath("(//label[@class='jss77'])"+"["+i+"]")).getText();
			
			System.out.println(element);
		}
		
	
	}
	
	public void clickOnSignUp()
	{
		driver.get("http://bustle-spot.com/");
		driver.findElement(signUpLink).click();
	}
	public void enterEmail(String emailid)
	{
		driver.findElement(email).sendKeys(emailid);;
	}
	public void enterName(String name)
	{
		driver.findElement(fullName).sendKeys(name);
	}
	public void enterPass(String pas)
	{
		driver.findElement(pass).sendKeys(pas);
	}
	public void enterConfirmPass(String cpass)
	{
		driver.findElement(confirmPass).sendKeys(cpass);
	}
	public void clickOnSubmit()
	{
		driver.findElement(signUpButton).click();
		
	}
	
}
