package com.osa.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.osa.base.AppContains;

public class Utilities {
	private static Logger log = Utilities.getLog(Utilities.class);

	/**
	 * This method will take screenshots
	 * 
	 * @param dr
	 */
	public static void takeScreenShot(WebDriver dr, String methodName) {
		try {
			
			
			TakesScreenshot screenshot = ((TakesScreenshot) dr);
			
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "\\screenshots\\"
					+ System.currentTimeMillis() + methodName  /*+".jpeg"*/+".png"));
		} catch (Exception e) {
			log.info("The error message from catch block: " + e.getMessage());
		}
	}

	/**
	 * This method will have all the username and password for testing our forum
	 * login page.
	 * 
	 * @return
	 */
	@DataProvider(name = "loginData")
	public Object[][] testData() {
		Object[][] ss = AppContains.getValue("C:\\Users\\obaidulla\\Desktop\\LoginTestData.xlsx", "forumLoginTestData");
		return ss;
	}

	/**
	 * This method has all he field value for completing the registration.
	 * 
	 * @return
	 */
	@DataProvider(name = "registration")
	public Object[][] registrationTestData() {
		Object[][] ss = AppContains.getValue("C:\\Users\\obaidulla\\Desktop\\LoginTestData.xlsx",
				"registrationTestData");
		return ss;
	}

	/**
	 * This method will take two string value, and verify the values are equals or
	 * not
	 * 
	 * @param expectedV
	 * @param actualV
	 */
	public static void verifyString(String expectedV, String actualV) {
		if (expectedV.equals(actualV)) {
			log.info("The test is passed");
		} else {
			log.info("The test is Failed");
			log.info("Expected value is : " + expectedV);
			log.info("Actual value is : " + actualV);
			Assert.assertEquals(actualV, expectedV);
		}
		
	}

	public static Logger getLog(Class clazz) {
		Logger log = Logger.getLogger(clazz);
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		return log;
	}

	public static void scrollMyScreen(WebDriver dr, String pixel) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		// js.executeScript(Script,Arguments);
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

}
