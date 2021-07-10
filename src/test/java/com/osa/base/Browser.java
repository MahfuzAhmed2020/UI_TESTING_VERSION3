package com.osa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.osa.common.App;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {	
	static WebDriver dr=null;
	static String basePath=System.getProperty("user.dir");
	public static void main(String[] args) {
		Browser.openBrowser("Edge");
	}
	
	public static WebDriver openBrowser(String browser) {
		

		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			getBrowserForWindows(browser);
		}else {
			getBrowserForMac(browser);
			
		}
		 
		return dr;
	}
	/*public static void getBrowserForWindows(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\test\\resources\\drivers\\windows\\geckodriver.exe");
			 dr=new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", basePath+"\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
			 dr= new ChromeDriver();
			 dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}else {

			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\test\\resources\\drivers\\windows\\geckodriver.exe");
			 dr=new FirefoxDriver();
		
			System.out.println("You have entered "+ browser+" that does not exist. Please either chrome or firefox");
		}
		
	}
	public static void getBrowserForMac(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
			dr = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/mac/geckodriver");
			dr = new FirefoxDriver();
		}else {
			System.out.println("Please set the executable browser path");
		}
	}*/
	
	//  bonigarcia
	  
	  public static void getBrowserForWindows(String browser) {
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dr = new FirefoxDriver();
		}else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			dr = new EdgeDriver();
		}else {
			System.out.println("The browser path is not executeble");
		}
		
	}
	
	public static void getBrowserForMac(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dr = new FirefoxDriver();
		}else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			dr = new EdgeDriver();
		}else {
			System.out.println("The browser path is not executeble");
		}
	}
	

}
