package com.SoftSuave.BustelSpotMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BaseClass {
	WebElement emailIDElement;
	WebElement passwordElement;
	By emailID = By.xpath("//input[@placeholder='Enter your email address']");
	By password = By.xpath("//input[@placeholder='Enter your password']");
	By login = By.xpath("//button[text()='Login']");
	By statusMsg = By.xpath("//div[@class='message-sec']/p[1]");
	By statusTxt = By.xpath("//div[@class='message-sec']/p[2]");
	By errormessage = By.xpath("//label[@class='jss77']");
	PerformActions performAction = new PerformActions();

	public void loginToApplicationValid() {
		ExcelTestData getDataFromExcel=new ExcelTestData();
		String email=getDataFromExcel.getEmailData("ProjectManager");
		String paas=getDataFromExcel.getPasswordData("ProjectManager");
		loginToApplicationValid(email, paas);
	}

	private void launch() {
		driver.get("http://bustle-spot.com/");

	}

	public String loginToApplicationValid(String email, String pwd) {
		launch();

		performAction.sendKeys(emailID, email);
		performAction.sendKeys(password, pwd);
		performAction.performClick(login);

		waitForElement(statusMsg);
		String actualMessage = performAction.getText(statusMsg);

		return actualMessage;
	}

// public void enteremailId(String email)
// {
// emailIDElement.sendKeys(email);
// }
// public void clickOnLogin()
// {
// driver.findElement(login).click();
// }
//

	public String loginToApplicationInvalidEmail(String email, String pwd) {
		launch();
		performAction.sendKeys(emailID, email);
		performAction.sendKeys(password, pwd);
		performAction.performClick(login);

		waitForElement(statusMsg);
		String actualMessage = performAction.getText(statusMsg);

		return actualMessage;
	}

	public String loginToApplicationInvalidCredentials(String email, String pwd) {
		launch();
		performAction.sendKeys(emailID, email);
		performAction.sendKeys(password, pwd);
		performAction.performClick(login);

		waitForElement(statusMsg);
		String actualMessage = performAction.getText(statusMsg);
		return actualMessage;
	}

	public String loginToApplicationShortMail(String email, String pwd) {
		launch();
		performAction.sendKeys(emailID, email);
		performAction.sendKeys(password, pwd);
		performAction.performClick(login);
		waitForElement(errormessage);

		String actualMessage = performAction.getText(errormessage);

		return actualMessage;

	}

	public String loginToApplicationNoData(String email, String pwd) {
		launch();
		performAction.sendKeys(emailID, email);
		performAction.sendKeys(password, pwd);
		performAction.performClick(login);
		waitForElement(errormessage);
		String actualMessage = performAction.getText(errormessage);
		return actualMessage;
	}

	public void validationLoginPage(String status) {
		switch (status) {
		case "SUCCESS!":

			String actualTextSucess = performAction.getText(statusTxt);
			System.out.println(actualTextSucess);
			String expectedTextSucess = "SucessFully logged in";
			Assert.assertEquals(expectedTextSucess, actualTextSucess);
			break;
		case "ERROR!":

			String actualTextError = performAction.getText(statusTxt);
			if (actualTextError.contains("password")) {
				System.out.println(actualTextError);
				String expectedTextError = "Wrong password entered";
				Assert.assertEquals(actualTextError, expectedTextError);
			} else {

				String actualTextErrorNoUserFound = performAction.getText(statusTxt);
				System.out.println(actualTextErrorNoUserFound);
				String expectedTextError = "No User Found. Please Sign Up";
				Assert.assertEquals(actualTextErrorNoUserFound, expectedTextError);
			}
			break;
		case "enter a valid mail":

			String actualTextErrorEmailId = performAction.getText(errormessage);

			System.out.println(actualTextErrorEmailId);
			String expectedTextErrorEnterEmailId = "Please enter a valid mail id.";
			Assert.assertEquals(actualTextErrorEmailId, expectedTextErrorEnterEmailId);
			break;
		case "Required":
			String actualTextErrorEmailIdRequired = performAction.getText(errormessage);

			System.out.println("Mandotary Filed" + " " + actualTextErrorEmailIdRequired);
			String expectedTextErrorEmailIdRequired = "Required";
			Assert.assertEquals(actualTextErrorEmailIdRequired, expectedTextErrorEmailIdRequired);
			break;
		}
	}
}