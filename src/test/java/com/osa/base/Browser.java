package com.osa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.osa.common.App;

public class Browser {	
	static WebDriver dr=null;
	static String basePath=System.getProperty("user.dir");
	
	public static WebDriver openBrowser(String browser) {
		

		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			getBrowserForWindows(browser);
		}else {
			getBrowserForMac(browser);
			
		}
		 
		return dr;
	}
	public static void getBrowserForWindows(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\test\\resources\\drivers\\windows\\geckodriver.exe");
			 dr=new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", basePath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			 dr= new ChromeDriver();
			 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}else {
			System.out.println("You have entered "+ browser+" that does not exist. Please either chrome or firefox");
		}
		
	}
	public static void getBrowserForMac(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/mac/chromedriver");
			dr = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/mac/geckodriver");
			dr = new FirefoxDriver();
		}else {
			System.out.println("Please set the executable browser path");
		}
	}
	
	

}
