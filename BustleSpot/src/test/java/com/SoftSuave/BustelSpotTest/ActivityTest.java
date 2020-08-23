package com.SoftSuave.BustelSpotTest;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.ActivityPage;
import com.SoftSuave.BustelSpotMain.LoginPage;
import com.SoftSuave.BustelSpotMain.SignOutFunctionality;
@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class ActivityTest extends ActivityPage {

	public void login() {

		LoginPage login = new LoginPage();
		login.loginToApplicationValid();
		selectProject("Test Cases");
		selectName("Divyanshu");
	}

	public void signOut() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SignOutFunctionality s = new SignOutFunctionality();
		s.clickOnSignOut();
	}

	@Test
	public void activityPagetest() throws AWTException, InterruptedException {
		login();
		selectDateFromCalendar("2", "July", "2019");
		selectDateToCalendar("15", "August", "2019");

		signOut();

	}

	@Test
	public void activityPagetestclickOnToday() throws AWTException, InterruptedException {
		login();
		selectDateFromCalendar("2", "July", "2019");

		clickOnToday();
		signOut();

	}

	@Test
	public void activityPagetestclickOnYestarday() throws AWTException, InterruptedException {
		login();
		selectDateFromCalendar("2", "July", "2019");

		clickOnYestarday();
		signOut();

	}

	@Test
	public void activityPagetestclickOnThisWeek() throws AWTException, InterruptedException {
		login();
		selectDateFromCalendar("2", "July", "2019");

		clickOnThisWeek();
		signOut();

	}

	@Test
	public void activityPagetestclickOnLastWeek() throws AWTException, InterruptedException {
		login();
		selectDateFromCalendar("2", "July", "2019");

		clickOnLastWeek();
		signOut();

	}

	@Test
	public void activityPagetestclickOnThisMonth() throws AWTException, InterruptedException {
		login();
		selectDateFromCalendar("2", "July", "2019");

		clickOnThisMonth();
		signOut();

	}

	@Test
	public void activityPagetestclickOnLastMonth() throws AWTException, InterruptedException {
		login();
		selectDateFromCalendar("2", "July", "2019");

		clickOnLastMonth();
		signOut();

	}

}