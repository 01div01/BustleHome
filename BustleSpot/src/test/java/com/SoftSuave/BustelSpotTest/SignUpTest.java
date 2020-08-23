package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.SignUp;
import com.SoftSuave.BustelSpotMain.SignUpText;

@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class SignUpTest extends SignUp
{
	@Test(priority =1)
	public void signUpAppNewUser()
	{
		clickOnSignUp();
		double n=Math.random();
		System.out.println("diddf"+n+"s@gmail.com");
		enterEmail("diddf"+n+"s@gmail.com");
		enterName("div");
		enterPass("1234567@aA");
		enterConfirmPass("1234567@aA");
		String status=clickOnSubmit();
		validationSignUp(status);
	}
	@Test(priority =1)
	public void signUpAppOldUser()
	{
		clickOnSignUp();
		enterEmail("ind1div@gmail.com");
		enterName("div");
		enterPass("1234567@aA");
		enterConfirmPass("1234567@aA");
		String status=clickOnSubmit();
		validationSignUp(status);
	}
	@Test(priority =1)
	public void signUpAppInvalid()
	{
		SignUpText st=new SignUpText();
		st.clickOnSignUp();
		st.enterEmail("");
		st.enterName("div");
		st.enterPass("1234567");
		st.enterConfirmPass("12fd34567");
		st.clickOnSubmit();
		st.sizeText();
		st.getText();
		validationSignUp("Required");
	}
	@Test (priority =2)
	public void signUpAppLoginLink()
	{
		SignUpText st=new SignUpText();
		st.clickOnSignUp();
		clickOnSigninLink();
		validationSignUp("LoginUrl");
	}
	

}