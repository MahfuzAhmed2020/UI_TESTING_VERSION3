package com.osa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
	public static WebDriver driver;
	public static WebElement getWebElement(By locator) {
		
		return driver.findElement(locator);
	}
	public static void selectDropDownValue(By locator, String type, String value) {
		Select select = new Select(getWebElement(locator));

		switch (type) {
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		default:
			System.out.println("Plese pass the correct selection criteria.........");
			
		}
	}

}
