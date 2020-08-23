package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.LoginPage;
import com.SoftSuave.BustelSpotMain.SignOutFunctionality;
@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)

public class SignOutTest extends SignOutFunctionality{
	@Test
	public void signOutFun() throws InterruptedException
	{
		LoginPage l=new LoginPage();
		l.loginToApplicationValid();
		
		clickOnSignOut();
	}
}
