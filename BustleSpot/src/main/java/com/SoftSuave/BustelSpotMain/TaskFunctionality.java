package com.SoftSuave.BustelSpotMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class TaskFunctionality extends BaseClass
{
	By projectButton=By.xpath("//span[text()='Tasks']");
	By searchTextField=By.xpath("//input[@placeholder='Search Projects']");
	By addTaskLink=By.xpath("//button[@class='jss300']");
	By taskName=By.xpath("//input[@name='taskName']");
	By taskDescription=By.xpath("//input[@name='taskDescription']");
	By saveButton=By.xpath("//button[text()='Save']");
	By cancelButton=By.xpath("//button[text()='Cancel']");
	By statusMsg = By.xpath("//div[@class='message-sec']/p[1]");
	By statusTxt=By.xpath("//div[@class='message-sec']/p[2]");
	
	By editButton=By.xpath("(//li[@role='menuitem'])[1]");
	By deleteButton=By.xpath("(//li[@role='menuitem'])[2]");
	
	By yesButoon=By.xpath("//button[@class='jss117']");
	By noButton=By.xpath("//button[@class='jss116']");
	
	
	
	public void clickOnTaskButton()
	{
		driver.findElement(projectButton).click();	
	}
	public void searchFunctionality(String text)
	{
		driver.findElement(searchTextField).sendKeys(text);
	}
	public void clickOnAddTask() throws InterruptedException
	{
		driver.findElement(addTaskLink).click();
	}
	public void enterTaskNameTask(String taskNameText)
	{
		driver.findElement(taskName).sendKeys(taskNameText);
		
	}
	public void enterTaskDescription(String taskDescriptionText)
	{
		driver.findElement(taskDescription).sendKeys(taskDescriptionText);
		
	}
	public String clickOnSaveButton() throws InterruptedException
	{
		driver.findElement(saveButton).click();
		Thread.sleep(5000);
		
		waitForElement(statusMsg);
		String actualMessage = driver.findElement(statusMsg).getText();
		return actualMessage;
		
	}
	
	public void clickOnCancleButton() throws InterruptedException
	{
		driver.findElement(cancelButton).click();
		Thread.sleep(5000);
	}
	
	public void clickOnEditButton(String taskName)
	{
	
		String xpath = "(//*[text()='Replace']/../following-sibling::div[2]/button/span[1])[1]";
		xpath = xpath.replace("Replace", taskName);
	
		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();
		driver.findElement(editButton).click();
	}
	public void sendEditedTaskDescription(String taskDescriptionEdit) {
		
		driver.findElement(taskDescription).clear();
		driver.findElement(taskDescription).sendKeys(taskDescriptionEdit);
	}

	public void sendEditedTaskNameText(String taskNameEdit) {
		
		driver.findElement(taskName).clear();
		driver.findElement(taskName).sendKeys(taskNameEdit);
	}
	
	public void clickOnDeleteButton(String taskName)
	{
		String xpath = "(//*[text()='Replace']/../following-sibling::div[2]/button/span[1])[1]";
		xpath = xpath.replace("Replace", taskName);
	
		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();
		driver.findElement(deleteButton).click();
		
	}
	public void clickOnYesButton()
	{
		driver.findElement(yesButoon).click();
	}
	public void clickOnDeleteButtonClickOnNo(String taskName)
	{
		String xpath = "(//*[text()='Replace']/../following-sibling::div[2]/button/span[1])[1]";
		xpath = xpath.replace("Replace", taskName);
	
		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();
		driver.findElement(deleteButton).click();
		driver.findElement(noButton).click();
	}
	
	public void validationTaskFunctionality(String status)
	{
		switch(status) 
		{
		  case "SUCCESS!":
			String actualTextSucess=driver.findElement(statusTxt).getText();
		    System.out.println(actualTextSucess);
		    String expectedTextSucess="Task has been created sucessfully.";
		    Assert.assertEquals(actualTextSucess, expectedTextSucess);
		    break;
		  case "ERROR!":
			  	String actualText=driver.findElement(statusTxt).getText();
			    System.out.println(actualText);
			    String expectedText="Task has been not created sucessfully.";
			    Assert.assertEquals(actualText, expectedText);
			    break;
		  case "Cancle":
			//Assert.assertFalse(condition, message);
			//*[text()='first']
			  System.out.println("Task not created");
		  case "Task Edited":
			  String actualTextSucessEdit=driver.findElement(statusTxt).getText();
			    System.out.println(actualTextSucessEdit);
			    String expectedTextSucessEdit="This task was successfully edited.";
			    Assert.assertEquals(actualTextSucessEdit, expectedTextSucessEdit);
			    break;
		  case "Task Deleted":
		  String actualTextSucessDelete=driver.findElement(statusTxt).getText();
		    System.out.println(actualTextSucessDelete);
		    String expectedTextSucessDelete="Task was successfully deleted";
		    Assert.assertEquals(actualTextSucessDelete, expectedTextSucessDelete);
		    break;
		}
	}
}
