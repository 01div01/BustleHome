package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.LoginPage;

@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class LoginTest extends LoginPage{
//	@Test
//	public void loginToApplicationValid()
//	{
//		LoginPage lp=new LoginPage();
//		lp.loginToApplicationValid();
//		validationLoginPage("");
//	}
	
	@Test
	public void loginToApplicationValid()
	{
		String inValidEmailid="ind1div@gmail.com";
		String validpass="25111994";
		String status=loginToApplicationInvalidCredentials(inValidEmailid, validpass);
		validationLoginPage(status);
	}
	@Test
	public void loginToApplicationInvalidEmail()
	{
		String inValidEmailid="ind1dfdiv@gmail.com";
		String validpass="25111994";
		String status=loginToApplicationInvalidCredentials(inValidEmailid, validpass);
		validationLoginPage(status);
	}
	@Test
	public void loginToApplicationInvalidPassword()
	{
		String validEmailid="ind1div@gmail.com";
		String invalidpass="2511199s4";
		String status=loginToApplicationInvalidCredentials(validEmailid, invalidpass);
		validationLoginPage(status);
	}
	@Test
	public void loginToApplicationShortMail()
	{
		String invalidEmailid="DDF";
		String invalidpass="FDS";
		loginToApplicationShortMail(invalidEmailid, invalidpass);
		validationLoginPage("enter a valid mail");
	}
	@Test
	public void loginToApplicationNoData()
	{
		String noEmailid="";
		String nopass="";
		loginToApplicationNoData(noEmailid, nopass);
		validationLoginPage("Required");
	}
	
}
