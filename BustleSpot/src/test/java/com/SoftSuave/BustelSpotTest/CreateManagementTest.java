package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.CreateManagement;
import com.SoftSuave.BustelSpotMain.LoginPage;
import com.SoftSuave.BustelSpotMain.SignOutFunctionality;


@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class CreateManagementTest extends CreateManagement
{
	public void signOut() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SignOutFunctionality s=new SignOutFunctionality();
		s.clickOnSignOut();
	}
	@Test(priority =1)
	public void createOrganisation() throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.loginToApplicationValid();
		clickOnButton();
		enterOrganisationName("First Organisation");
		enterOrganisationDes("some discription");
		//fileImage();
		submitButton();
		signOut();
	}
	@Test(priority =1)
	public void organisationPressBack() throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.loginToApplicationValid();
		clickOnButton();
		clickOnBackButton();
		validationCreateManagement("Back");
		//fileImage();
		signOut();
	}
	@Test (priority=2)
	public void createOrganisationDublicates() throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.loginToApplicationValid();
		clickOnButton();
		enterOrganisationName("First Organisation");
		enterOrganisationDes("some discription");
		//fileImage();
		String status=submitButtonDuplicate();
		validationCreateManagement(status);
		Thread.sleep(2000);
		driver.navigate().back();
		signOut();
	}
	@Test(priority =3)
	public void editManagementFunctionality() throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.loginToApplicationValid();
		Thread.sleep(5000);
		editManagement("First Organisation");
		enterOrganisationNameEdit("Demo");
		enterOrganisationDesEdit("some other des");
		submitButton();
		signOut();;
	}
	@Test (priority =5)
	public void deleteManagementFunctionality() throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.loginToApplicationValid();
		Thread.sleep(5000);
		deleteManagement("Demo");
		Thread.sleep(2000);
		clickOnYesButton();
		signOut();
	}
	@Test (priority =4)
	public void clickOnParticularManagementTest() throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.loginToApplicationValid();
		Thread.sleep(5000);
		clickOnParticularManagement("Demo Test Click");
		signOut();;
	}
	@Test (priority =4)
	public void clickOnParticularManagementTestAndResfresh() throws InterruptedException
	{
		LoginPage lp=new LoginPage();
		lp.loginToApplicationValid();
		Thread.sleep(5000);
		clickOnParticularManagement("Demo Test Click");
		driver.navigate().refresh();
		Thread.sleep(2000);
		validationCreateManagement("Refresh");
		signOut();;
	}
}
