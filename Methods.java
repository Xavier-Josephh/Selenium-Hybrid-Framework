package com.auto.practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Methods extends Config1
{

	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	SoftAssert s_assert = new SoftAssert();	
	// Getting the page title
   public static void getTitle()
   {
	   driver.getTitle();
   }
   
   //Verifying whether the element is present
   public static void isElementPresent()
   {
	   
	   try{
		   driver.findElement(By.xpath(prop.getProperty(object)));
	   }catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();	
			APPLICATION_LOGS.debug(object+" Element not present");	
       if(perm.equals("N")){
    	   System.exit(0);
       }
	  }	   
    }

// Entering the alpha values to the field
   public static void input()
   {
	   try{
	   driver.findElement(By.xpath(prop.getProperty(object))).sendKeys(data);
	   }catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();		
	  }
   }   
   
  // Clicking 
  public static void clickLink()
   {
	  try{
	  driver.findElement(By.xpath(prop.getProperty(object))).click();
	  }catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();		
	  }
   }
  
  //To verify the page
  public static void getPageSource()
  {
	  boolean ele1 =  driver.getPageSource().contains(pagesource);  
		System.out.println(ele1);  
		//Assert.assertEquals(true, ele1);
		APPLICATION_LOGS.debug(pagesource+" "+ele1);
		 if(perm.equals("N")){
	    	   System.exit(0);
	       }
  }
  
  //Wait for ten seconds
  public static void waitTenSecs()
  {
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }
  
  //To clear the field
  public static void clear()
  {
	  driver.findElement(By.xpath(prop.getProperty(object))).clear();
  }
  
  //To navigate back
  public static void back()
  {
	  driver.navigate().back();
  }
  
  //To click on ok
  public static void accept()
  {
	  driver.switchTo().alert().accept();
	  
  }
  
  //Wait for a second
  public static void threadWait() throws Throwable
  {
	  Thread.sleep(2000);
  }
  
  //
  public static void dropdownSelect()
  {   
	  Select sel = new Select(driver.findElement(By.xpath(prop.getProperty(object))));
	  sel.selectByVisibleText(selobj);
  }
}