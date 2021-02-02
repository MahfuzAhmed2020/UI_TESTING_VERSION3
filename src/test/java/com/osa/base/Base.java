package com.osa.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
  public WebDriver dr;
    @BeforeClass
	public void settingBrowser(ITestContext contex) {
	dr=	Browser.openBrowser("chrome");
	
	contex.setAttribute("WebDriver", dr);
	//contex.getAttribute("WebDriver");
	
//	System.setProperty("os.na", "abcd");
//	System.getProperty("os.na");
	
	}
    @AfterClass
	public void clossingBrowser() {
		//dr.close();
	}
}
