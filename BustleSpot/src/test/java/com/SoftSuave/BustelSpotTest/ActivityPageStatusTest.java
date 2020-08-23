package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.ActivityPageStatus;
import com.SoftSuave.BustelSpotMain.LoginPage;
import com.SoftSuave.BustelSpotMain.SignOutFunctionality;
@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)

public class ActivityPageStatusTest  extends ActivityPageStatus
{
	String text="";
	@BeforeClass
	public void login()
	{
		LoginPage login = new LoginPage();
		login.loginToApplicationValid();
	}
	@Test
	public void getActivityTextTotalHours()
	{

		
		//text=totalHours();
		validationActivityPage("Total Hours");
		
	}
	@Test
	public void getActivityTextTotalBillableHours()
	{

		
		
		validationActivityPage("Total Billable Hours");
		
	}
	@Test
	public void getActivityTextTotalActivity()
	{
		

		
		//text=totalActivity();
		validationActivityPage("Total Activity");
		
	}
	@Test
	public void getActivityTextTotalNoofUsers()
	{

		
		
		//text=totalNoofUsers();
		validationActivityPage("Total No of Users");
	}
	@AfterClass
	public void signout() throws InterruptedException
	{
		SignOutFunctionality s = new SignOutFunctionality();
		s.clickOnSignOut();
	}
	

}
