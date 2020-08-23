package com.SoftSuave.BustelSpotMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class MembersFunctionality extends BaseClass
{
	By membersButton=By.xpath("(//span[text()='Members'])[1]");
	By searchMembersTextField=By.xpath("//input[@placeholder='Search Members']");
	By assignProjecButton=By.xpath("//button[text()='Assign Project']");
	
	By taskName=By.xpath("//input[@name='taskName']");
	By taskDescription=By.xpath("//input[@name='taskDescription']");
	
	By addMembers=By.xpath("//button[@class='snm-ap']");
	
	By saveButton=By.xpath("//button[text()='Save']");
	By cancelButton=By.xpath("//button[text()='Cancel']");
	By statusMsg = By.xpath("//div[@class='message-sec']/p[1]");
	By statusTxt=By.xpath("//div[@class='message-sec']/p[2]");
	
	By inviteButton=By.xpath("//span[text()='Invites']");
	
	By resendInvitationButton=By.xpath("(//li[@role='menuitem'])[1]");
	By removeInviteButton=By.xpath("(//li[@role='menuitem'])[2]");
	
	By memberList=By.xpath("(//span[text()='Members'])[2]");
	
	public void clickOnMembersButton()
	{
		driver.findElement(membersButton).click();	
	}
	public void searchFunctionality(String text)
	{
		driver.findElement(searchMembersTextField).sendKeys(text);
	}
	public void clickOnAssignProject() throws InterruptedException
	{
		driver.findElement(assignProjecButton).click();
	}
	
	
	public void selectProject(String projectName)
	{
		By projectDropDown = By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[1]");
		waitForElement(projectDropDown);
		WebElement projectElement = driver.findElement(projectDropDown);
		projectElement.click();
	
		String xpath = "//*[text()='Replace' and @class=' css-9x2jzj-option'] ";
		xpath = xpath.replace("Replace", projectName);
	
		WebElement projectOption = driver.findElement(By.xpath(xpath));
		projectOption.click();
	}
	public void selectRole(String roleName) throws InterruptedException
	{
		Thread.sleep(1000);
		By roleDropDown = By.xpath("//label[text()='Roles']//parent::div//div[span]");
		waitForElement(roleDropDown);
		WebElement roleElement = driver.findElement(roleDropDown);
		roleElement.click();
	
		String xpath = "//*[text()='Replace' and @class=' css-9x2jzj-option']";
		xpath = xpath.replace("Replace",roleName);
	
		WebElement roleOption = driver.findElement(By.xpath(xpath));
		roleOption.click();
	}
	
	public void clickOnAddMembers()
	{
		driver.findElement(addMembers).click();
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
	
	public void memberInviteFunctionality()
	{
		driver.findElement(inviteButton).click();
	}
	public void clickOnResendButton(String inviteeId)
	{
	
		String xpath = "(//span[text()='div9349@gmail.com']/../following-sibling::div[3]/button/span[1])[1]";
		xpath = xpath.replace("Replace", inviteeId);
	
		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();
		driver.findElement(resendInvitationButton).click();
	}
	public void clickOnRemoveIviteeButton(String inviteeId)
	{
		String xpath = "(//span[text()='div9349@gmail.com']/../following-sibling::div[3]/button/span[1])[1]";
		xpath = xpath.replace("Replace", inviteeId);
	
		WebElement taskOption = driver.findElement(By.xpath(xpath));
		taskOption.click();
		driver.findElement(removeInviteButton).click();
	}
	
	public void clickOnMemberList() throws InterruptedException
	{
		driver.findElement(memberList).click();
	}
	
	public void validationTaskFunctionality(String status)
	{
		switch(status) 
		{
		  case "SUCCESS!":
			String actualTextSucess=driver.findElement(statusTxt).getText();
		    System.out.println(actualTextSucess);
		    String expectedTextSucess="Members Added successfully";
		    Assert.assertEquals(actualTextSucess, expectedTextSucess);
		    break;
		  case "ERROR!":
			  	String actualText=driver.findElement(statusTxt).getText();
			    System.out.println(actualText);
			    String expectedText="Members is already in that project";
			    Assert.assertEquals(actualText, expectedText);
			    break;
		  case "Cancle":
			//Assert.assertFalse(condition, message);
			//*[text()='first']
			  System.out.println("Members not added");
		}
	}

}
