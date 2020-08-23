package com.SoftSuave.BustelSpotMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class CreateManagement extends BaseClass
{
	By clickOnButton=By.xpath("//div[@class='hmi-div']");
	By organiseButton=By.xpath("//span[@class='MuiButton-label']");
	By addOrganisationLink=By.xpath("//button[@class='jss307']");
	By organisationName=By.xpath("//input[@name='organisation-name']");
	By organisationDes=By.xpath("//textarea[@name='organisation-description']");
	//By fileimg=By.xpath("//div[@class='fu-cont']");
	By submitBut=By.xpath("//button[@class='of-submit-btn']");
	By statusMsg = By.xpath("//div[@class='message-sec']/p[1]");
	By statusTxt=By.xpath("//div[@class='message-sec']/p[2]");
	
	By editButton=By.xpath("(//li[@role='menuitem'])[1]");
	By deleteButton=By.xpath("(//li[@role='menuitem'])[2]");
	
	By yesButoon=By.xpath("//button[@class='jss117']");
	By noButton=By.xpath("//button[@class='jss116']");
	
	By backButton=By.xpath("//button[@class='prev-btn act-prev-btn']");
	
	
	
	public void clickOnButton() throws InterruptedException
	{
		Thread.sleep(5000);
		
		driver.findElement(clickOnButton).click();
		driver.findElement(organiseButton).click();
		driver.findElement(addOrganisationLink).click();
	}
	public void clickOnBackButton()
	{
		driver.findElement(backButton).click();
		
	}
	public void enterOrganisationName(String name)
	{
		driver.findElement(organisationName).sendKeys(name);
	}
	public void enterOrganisationDes(String name)
	{
		driver.findElement(organisationDes).sendKeys(name);
	}
	//public void fileImage()
	//{
	//	driver.findElement(fileimg).sendKeys("C:\\Users\\Softsuave\\Desktop\\BustelSpot\\BustleMaven\\src\\test\\java\\com\\softsuave\\resources\\Screenshot (4).png");;
	//}
	public void submitButton()
	{
		driver.findElement(submitBut).click();
		
	}
	public String submitButtonDuplicate()
	{
		driver.findElement(submitBut).click();
		waitForElement(statusMsg);
		String actualMessage = driver.findElement(statusMsg).getText();
		return actualMessage;
	}
	public void editManagement(String managementName)
	{
		driver.findElement(clickOnButton).click();
		driver.findElement(organiseButton).click();
		String xpath="((//span[text()='Replace'])/../following-sibling::div[1]/button/span)[1]";
		xpath = xpath.replace("Replace", managementName);
		
		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();
		driver.findElement(editButton).click();
		
	}
	public void deleteManagement(String managementName)
	{
		driver.findElement(clickOnButton).click();
		driver.findElement(organiseButton).click();
		String xpath="((//span[text()='Replace'])/../following-sibling::div[1]/button/span)[1]";
		xpath = xpath.replace("Replace", managementName);
		
		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();
		driver.findElement(deleteButton).click();
	}
	public void clickOnYesButton()
	{
		driver.findElement(yesButoon).click();
	}
	public void enterOrganisationNameEdit(String name)
	{
		driver.findElement(organisationName).clear();
		driver.findElement(organisationName).sendKeys(name);
	}
	public void enterOrganisationDesEdit(String name)
	{
		driver.findElement(organisationDes).clear();
		driver.findElement(organisationDes).sendKeys(name);
	}
	
	public void clickOnParticularManagement(String managementName)
	{
		driver.findElement(clickOnButton).click();
		String xpath="//*[text()='Replace']";
		xpath=xpath.replace("Replace", managementName);
		WebElement managementOption = driver.findElement(By.xpath(xpath));
		managementOption.click();
		
	}
	public void validationCreateManagement(String status)
	{
		switch(status) 
		{
		  case "SUCCESS!":
			String actualTextSucess=driver.findElement(statusTxt).getText();
		    System.out.println(actualTextSucess);
		    String expectedTextSucess="SucessFully created";
		    Assert.assertEquals(actualTextSucess, expectedTextSucess);
		    break;
		  case "ERROR!":
			  String actualText=driver.findElement(statusTxt).getText();
			    System.out.println(actualText);
			    String expectedText="Duplicate entry 'First Organisation' for key 'name_UNIQUE'";
			    Assert.assertEquals(actualText, expectedText);
			    break;
		  case "Back":
			  String actualURL=driver.getCurrentUrl();
			  System.out.println(actualURL);
			  String expectedURL="http://bustle-spot.com/organisation";
			  Assert.assertEquals(actualURL, expectedURL);
			    break;
		  case "Refresh":
			  String actualManagementText=driver.findElement(By.xpath("//div[@class='hmi-div']/parent::span/following-sibling::span")).getText();
			  String expectedManagementText="Demo Test Click";
			  Assert.assertEquals(actualManagementText, expectedManagementText);
			    break;
		}
	}
	

}
