package com.SoftSuave.BustelSpotMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ExtraFunctionality extends ProjectFunctionality
{
	
	public void clickOnEdit(String projectNamen)
	{
		String xpath="(//*[text()='Test Cases']/following-sibling::button//span)[1]";
		xpath = xpath.replace("Replace", projectNamen);

		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();

		//driver.findElement(changeRoleButton).click();
	}
	public void validationProjectFunctionalityAsSuperAdmin(String status)
	{
		switch(status) 
		{
		  case "SUCCESS!":
			String actualTextSucess=driver.findElement(statusTxt).getText();
		    System.out.println(actualTextSucess);
		    String expectedTextSucess="Invitation is already sent to the User";
		    Assert.assertEquals(actualTextSucess, expectedTextSucess);
		    break;
		  case "ERROR!":
			  String actualText=driver.findElement(statusTxt).getText();
			    System.out.println(actualText);
			    String expectedText="Network Error";
			    Assert.assertEquals(actualText, expectedText);
			    break;
		}
	}

}
