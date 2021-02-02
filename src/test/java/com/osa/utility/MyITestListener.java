package com.osa.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyITestListener implements ITestListener {
	WebDriver dr = null;
//	 public void onFinish(ITestContext arg0) {					
//	       System.out.println("onFinish");			
//	        		
//	    }		
//	    public void onStart(ITestContext arg0) {					
//	    	 System.out.println("onStart");			
//	        		
//	    }		
//
//	
//	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
//	    	 System.out.println("onTestFailedButWithinSuccessPercentage");					
//	        		
//	    }		

	public void onTestFailure(ITestResult result) {

		ITestContext context = result.getTestContext();
		dr= (WebDriver) context.getAttribute("WebDriver");
		Utilities.takeScreenShot(dr, result.getName());

	}

//
//	  
//	    public void onTestSkipped(ITestResult arg0) {					
//	    	 System.out.println("onTestSkipped");				
//	        		
//	    }		
//
//	    public void onTestStart(ITestResult arg0) {					
//	    	 System.out.println("onTestStart");				
//	        		
//	    }		
//
//	  	
//	    public void onTestSuccess(ITestResult arg0) {					
//	    	 System.out.println("onStart");					
//	        		
//	    }		

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
