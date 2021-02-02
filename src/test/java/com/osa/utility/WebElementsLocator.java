package com.osa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementsLocator {


	//public static WebDriver dr = null;
	public static WebElement element = null;

//	public WebElementsLocation(WebDriver dr) {
//		this.dr = dr;
//		// PageFactory.initElements(dr, this);
//	}

	public static void myClick(WebDriver dr,String type, String value) {
		
		getElement(dr,type, value).click();
		
	}

	public static void typeValue(WebDriver dr,String type, String value, String text) {
		getElement(dr,type, value).sendKeys(text);
	}

	public static WebElement getElement(WebDriver dr,String type, String value) {

		if (type.toLowerCase().equals("xpath")) {
			element = dr.findElement(By.xpath(value));
		} else if (type.toLowerCase().equals("cssselector")) {
			element = dr.findElement(By.cssSelector(value));
		} else if (type.toLowerCase().equals("id")) {
			element = dr.findElement(By.id(value));
		} else if (type.toLowerCase().equals("linktext")) {
			element = dr.findElement(By.linkText(value));
		} else if (type.toLowerCase().equals("name")) {
			element = dr.findElement(By.name(value));
		} else if (type.toLowerCase().equals("partiallinktext")) {
			element = dr.findElement(By.partialLinkText(value));
		} else if (type.toLowerCase().equals("tagname")) {
			element = dr.findElement(By.tagName(value));
		} else if (type.toLowerCase().equals("classname")) {
			element = dr.findElement(By.className(value));
		}
		return element;
	}

	public static void myClickdemo(WebDriver dr,String type, String value) {
		getElement(dr,type, value);
		// dr.findElement(By.xpath(xpath)).click();

	}

	public static void myClickWithWebElement(WebElement ele) {

		ele.click();

	}

	public static void myClickWithBy(WebDriver dr,By by) {

		dr.findElement(by).click();

	}

	public static void sendKeyWithXpathAndValue(WebDriver dr,String xpath, String value) {

		dr.findElement(By.xpath(xpath)).sendKeys(value);

	}

	public static void sendKeyWithEle(WebElement ele, String value) {

		ele.sendKeys(value);

	}

	public static void sendKeyByAndString(WebDriver dr,By by, String value) {

		dr.findElement(by).sendKeys(value);

	}


}
