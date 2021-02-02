package com.versionthree.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebElementLocation {

	static WebDriver dr = null;
	static WebElement element = null;

	public WebElementLocation(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);

	}

	public static void myClick(String type, String value) {

		getElement(type, value).click();
	}

	public static void typeValue(String type, String value, String text) {
		getElement(type, value).sendKeys(text);
	}

	public static WebElement getElement(String type, String value) {

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



}
