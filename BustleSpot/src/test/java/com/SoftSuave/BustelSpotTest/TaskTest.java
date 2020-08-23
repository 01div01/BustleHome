package com.SoftSuave.BustelSpotTest;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.SignOutFunctionality;
import com.SoftSuave.BustelSpotMain.TaskFunctionality;

@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class TaskTest extends TaskFunctionality
{
	@BeforeMethod
	public void clickOnTaskBeforeAllMethod() throws InterruptedException
	{
		LoginTest l=new LoginTest();
		l.loginToApplicationValid();
		
		clickOnTaskButton();
		
	}
	public void signOut() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SignOutFunctionality s=new SignOutFunctionality();
		s.clickOnSignOut();
	}
	
//	@AfterMethod
//	public void closeTheBrowser()
//	{
//		driver.quit();
//	}
	
	@Test (priority=1)
	public void addTaskTestFunctionality() throws InterruptedException
	{
		Thread.sleep(5000);
		searchFunctionality("Test Cases");
		clickOnAddTask();
		enterTaskNameTask("First Task");
		enterTaskDescription("First Task Description");
		String status=clickOnSaveButton();
		validationTaskFunctionality(status);
		signOut();
		
	}
//	@Test
//	public void cancleTaskTestFunctionality() throws InterruptedException
//	{
//		Thread.sleep(5000);
//		searchFunctionality("Test Cases");
//		clickOnAddTask();
//		enterTaskNameTask("First Task");
//		enterTaskDescription("First Task Description");
//		clickOnCancleButton();
//		validationTaskFunctionality("Cancle");
//		Thread.sleep(2000);
//		SignOutFunctionality s=new SignOutFunctionality();
//		s.clickOnSignOut();
//	}
	@Test (priority=2)
	public void editFunctionality() throws InterruptedException 
	{
		Thread.sleep(500);
		clickOnEditButton("First Task");
		sendEditedTaskNameText("1st Task");
		sendEditedTaskDescription("1st Task New Description");
		clickOnSaveButton();
		validationTaskFunctionality("Task Edited");
		signOut();
	}
	@Test (priority=3)
	public void deleteFunctionalityYes() throws InterruptedException 
	{
		Thread.sleep(500);
		clickOnDeleteButton("1st Task");
		Thread.sleep(5000);
		clickOnYesButton();
		
		validationTaskFunctionality("Task Deleted");
		signOut();
	}
//	@Test
//	public void deleteFunctionalityNo() throws InterruptedException 
//	{
//		
//		clickOnDeleteButtonClickOnNo("1st Task");
//	}



}
