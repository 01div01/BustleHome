package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.ExtraFunctionality;
import com.SoftSuave.BustelSpotMain.LoginPage;
import com.SoftSuave.BustelSpotMain.SignOutFunctionality;

@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class ExtraFunctionalityTest extends ExtraFunctionality
{
	
	@BeforeMethod
	public void loginAsSuperAdmin()
	{
		LoginPage l=new LoginPage();
		l.loginToApplicationValid("divyanshu@softsuave.com","25111994");
		clickOnProjectButton();
	}
	@Test
	public void projectFunctionality() throws InterruptedException
	{
		Thread.sleep(4000);
		clickOnAddMembers();
		clickOnInviteMembers();
		sendInviteMembers("ind1v@gmail.com");
		Thread.sleep(1000);
		String status=clickOnSaveButton();
		validationProjectFunctionalityAsSuperAdmin(status);
		Thread.sleep(2000);
		SignOutFunctionality s=new SignOutFunctionality();
		s.clickOnSignOut();
	}
	@Test
	public void clickOnOptions() throws InterruptedException
	{
		clickOnEdit("SomeOther Project");
		Thread.sleep(2000);
		SignOutFunctionality s=new SignOutFunctionality();
		s.clickOnSignOut();
	}
	

}
