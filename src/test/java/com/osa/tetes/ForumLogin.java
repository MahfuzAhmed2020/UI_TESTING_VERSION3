package com.osa.tetes;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.osa.base.Base;
import com.osa.base.Browser;
import com.osa.utility.Utilities;

import osa.com.pages.ForumPage;
import osa.com.pages.HomePage;
@Listeners(com.osa.utility.MyITestListener.class)
public class ForumLogin extends Base {
	//WebDriver dr;
	HomePage hp;
	ForumPage fp;
	private static Logger log=Utilities.getLog(ForumLogin.class);
	
//  @Test
//  public void verifyHomeTitle() {
//		dr=Browser.openBrowser("chrome");
//		dr.get("https://www.osaconsultingtech.com");
//		String expectedValue="OSA Consulting Tech Corp || Best Available Resources For Software Industry";
//		Utilities.verifyString(expectedValue,dr.getTitle());
//		dr.close();
//  }
  @Test()
  public void verifyForumLogin() throws InterruptedException {
	  log.info("Opening chrome browser");
	 //dr=Browser.openBrowser("chrome");
	  log.info("Navigating to https://www.osaconsultingtech.com");
	  dr.get("https://www.osaconsultingtech.com"); 
	  hp=new HomePage(dr);
	  hp.clickOnForumButton();
	  Thread.sleep(4000);
	  fp=new ForumPage(dr);
	  String actualForumTitle="OSA Consulting Tech - All the projects.";
	  Thread.sleep(4000);
//	  if(actualForumTitle.equals(dr.getTitle())) {
//		  System.out.println("passes****************");
//		  
//	  }else {
//		  System.out.println("failed*****************");
//	  }
	 Utilities.verifyString(actualForumTitle, dr.getTitle());
	  fp.typeUsername("mahfuz23@gmail.com");
	  fp.typePassword("");
	  fp.clickOnLoginButton();
	 
	  Thread.sleep(4000);
	  String actualValue="Student Page1";
	  Utilities.verifyString(actualValue, dr.getTitle());

  }
  
  

}
