package com.SoftSuave.BustelSpotTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.Status;

import com.SoftSuave.BustelSpotMain.BaseClass;
import com.SoftSuave.BustelSpotMain.ExtentManager;

public class ListenerTest extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("The name of the testcase failed is :"+result.getName());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		  LocalDateTime now = LocalDateTime.now();  
		  String timeStamp = dtf.format(now);
		try {
		takeSnapShot("D:\\Screenshots\\"+result.getName()+timeStamp+".png");
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(("*** Test Suite " + context.getName()+ " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

}
