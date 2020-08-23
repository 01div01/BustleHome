package com.SoftSuave.BustelSpotMain;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;



public class ActivityPage extends BaseClass
{
	By calendarIcon = By.xpath("//img[@alt='date-selector']");
	By monthDropDown = By.xpath("//span[@class='rdrMonthPicker']/select");
	By yearDropDown = By.xpath("//span[@class='rdrYearPicker']/select");
	String dayInCalendar = "//span[@class='rdrDayNumber']/span[text()='Replace']";
	By claenderEnd=By.xpath("//*[@class='rdrDateInput rdrDateDisplayItem rdrDateDisplayItemActive']");
	By todayButton=By.xpath("//*[text()='Today']");
	By yestardayButton=By.xpath("//*[text()='Yesterday']");
	By thisWeekButton=By.xpath("//*[text()='This Week']");
	By lastWeekButton=By.xpath("//*[text()='Last Week']");
	By thisMonthButton=By.xpath("//*[text()='This Month']");
	By lastMonthButton=By.xpath("//*[text()='Yesterday']");
	By getDateValue=By.xpath("//input[@placeholder='Early']");
	PerformActions performAction=new PerformActions();
	

	public void selectDateFromCalendar(String day, String month, String year) throws AWTException
	{

	
		performAction.performClick(calendarIcon);
	
	WebElement monthDropDownElement = driver.findElement(monthDropDown);
	Select monthdd = new Select(monthDropDownElement);
	monthdd.selectByVisibleText(month);

	WebElement yearDropDownElement = driver.findElement(yearDropDown);
	Select yeardd = new Select(yearDropDownElement);
	yeardd.selectByVisibleText(year);
	dayInCalendar = dayInCalendar.replace("Replace", day);
	By dayElement =By.xpath(dayInCalendar);
	performAction.performClick(dayElement);
	
	//driver.findElement(totalNoofUsers).click();
	//calendarElement.click();

	}
	public void selectDateToCalendar(String day, String month, String year) throws AWTException{
		//performAction.performClick(calendarIcon);
		dayInCalendar="//span[@class='rdrDayNumber']/span[text()='Replace']";
		
		WebElement monthDropDownElement = driver.findElement(monthDropDown);
		Select monthdd = new Select(monthDropDownElement);
		monthdd.selectByVisibleText(month);

		WebElement yearDropDownElement = driver.findElement(yearDropDown);
		Select yeardd = new Select(yearDropDownElement);
		yeardd.selectByVisibleText(year);

		dayInCalendar = dayInCalendar.replace("Replace", day);
		By dayElement =By.xpath(dayInCalendar);
		performAction.performClick(dayElement);
		pressESC();
		

		}
		public void selectProject(String projectName)
		{
			By projectDropDown = By.xpath("//label[text()='Select Project']//parent::div/div/div/div/div[.='Select...']");
			performAction.performClick(projectDropDown);
			
			
		
			String xpath = "//*[text()='Replace']";
			xpath = xpath.replace("Replace", projectName);
		
			WebElement projectOption = driver.findElement(By.xpath(xpath));
			projectOption.click();
		}
		
		public void selectName(String person){
		By namesDropDown = By.xpath("//label[text()='Select Name']//parent::div/div/div/div/div[.='Select...']");
		performAction.performClick(namesDropDown);
	
		String xpath = "(//*[text()='Replace'])[2]";
		xpath = xpath.replace("Replace", person);
	
		WebElement namesOption = driver.findElement(By.xpath(xpath));
		namesOption.click();
	}
		public void clickOnLastMonth() throws AWTException {
			
			driver.findElement(lastMonthButton).click();
			pressESC();
		}

		public void clickOnThisMonth() throws AWTException {
			
			driver.findElement(thisMonthButton).click();
			pressESC();
		}

		public void clickOnLastWeek() throws AWTException {
			
			driver.findElement(lastWeekButton).click();
			pressESC();
		}

		public void clickOnThisWeek() throws AWTException {
			
			driver.findElement(thisWeekButton).click();
			pressESC();
		}

		public void clickOnYestarday() throws AWTException {
	
			driver.findElement(yestardayButton).click();
			pressESC();
		}

		public void clickOnToday() throws AWTException {
			
			driver.findElement(todayButton).click();
			pressESC();
		}
		public void pressESC() throws AWTException
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			try {
			Thread.sleep(1000);
			}
			catch(Exception e) {
				
			}
		}
	

}