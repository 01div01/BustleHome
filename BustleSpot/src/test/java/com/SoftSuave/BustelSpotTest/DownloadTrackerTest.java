package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.DownloadTracker;

@Listeners(com.SoftSuave.BustelSpotTest.ListenerTest.class)
public class DownloadTrackerTest extends DownloadTracker
{
	@Test
	public void clickOnDownloadTracker()
	{
		clickDownloadTracker();
	}

}
