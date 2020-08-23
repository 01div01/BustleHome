package com.SoftSuave.BustelSpotMain;

import org.openqa.selenium.By;


public class DownloadTracker extends BaseClass
{
	By downloadTracker=By.xpath("(//span[@class='MuiIconButton-label'])[1]");
	public void clickDownloadTracker()
	{
		LoginPage l=new LoginPage();
		l.loginToApplicationValid();
		driver.findElement(downloadTracker).click();
	}

}
