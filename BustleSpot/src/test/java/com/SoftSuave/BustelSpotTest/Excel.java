package com.SoftSuave.BustelSpotTest;

import org.testng.annotations.Test;

import com.SoftSuave.BustelSpotMain.ExcelTestData;

public class Excel {
	@Test
	public void ssss()
	{
		ExcelTestData n=new ExcelTestData();
		System.out.println(n.getCellValue(10,3));
	}

}
