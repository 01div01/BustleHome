package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.ForgetPassword;

@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class ForgetPasswordTest extends ForgetPassword
{
	@Test(priority=1)
	public void forgetPasswordValidEmailId()
	{
		String email="ind1div@gmail.com";
		String statusMessage=forgetPassword(email);
		validationForgetPassword(statusMessage);
	}
	@Test(priority=1)
	public void forgetPasswordInvalidEmailId()
	{
		String email="ind1dsdiv@gmail.com";
		String statusMessage=forgetPassword(email);
		validationForgetPassword(statusMessage);
	}
	@Test(priority=1)
	public void forgetPasswordShortEmailId()
	{
		String email="ind1div";
		forgetPasswordErrorMessage(email);
		validationForgetPassword("Please enter a valid mail id.");
	}
	@Test(priority=1)
	public void forgetPasswordNoData()
	{
		String email="";
		forgetPasswordErrorMessage(email);
		validationForgetPassword("required");
	}
	@Test(priority=1)
	public void clickOnLoginLinkInForgotPassword()
	{
		getLoginLink();
	}
	@Test(priority=2)
	public void clickOnLogin()
	{
		clickOnForgetPassword();
		clickOnLoginLink();
		validationForgetPassword("LoginUrl");
	}

}
