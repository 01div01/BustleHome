package com.SoftSuave.BustelSpotMain;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestData 
{
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static String data;
	public static XSSFCell cell;
	public static FileInputStream fis;
	
	public static String getCellValue(int rownum, int cellnum)
	{
		establishConnection();
		DataFormatter formatter = new DataFormatter();
		data=formatter.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
		
		
		return data;
	}
	public static void establishConnection()
	{
		try
		{
		fis =new FileInputStream("C:\\Users\\Divyanshu\\git\\repository\\BustleSpot\\TestData.xlsx");
		wb=new XSSFWorkbook(fis);
		
		}
		catch(Exception e)
		{
			
		}
		
		sheet=wb.getSheetAt(0);
	}
	public String getEmailData(String loginAs)
	{
		
		String data=null;
		switch(loginAs) 
		{
		  case "SuperAdmin":
			  data=getCellValue(1,3);
			  
			  break;
		  case "Admin":
			  data=getCellValue(3,3);
			  break;
		  case "ProjectManager":
			  data=getCellValue(5,3);
			  break;
		  case "Client":
			  data=getCellValue(7,3);
			  break;
		  case "User":
			  data=getCellValue(9,3);
			  break;
		}
		return data;
	}
	public String getPasswordData(String loginAs)
	{
		String data=null;
		switch(loginAs) 
		{
		  case "SuperAdmin":
			  data=getCellValue(2,3);
			  break;
		  case "Admin":
			  data=getCellValue(4,3);
			  break;
		  case "ProjectManager":
			  data=getCellValue(6,3);
			  break;
		  case "Client":
			  data=getCellValue(8,3);
			  break;
		  case "User":
			  data=getCellValue(10,3);
			  break;
		}
		return data;
	}

}
