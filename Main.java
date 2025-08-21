package com.auto.practice;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ftf.automation.Main;

public class Main2 extends Methods
{
	public static String Keyword;
	public static String Flows;
	
@BeforeTest
public static void Starttest()
{
// Calling the object repository method	
 Main2.objectRepository();
 //Calling the open browser method
 Main2.openBrowser();	
}
	@Test
	public void startTesting() 
	 {
		
  try{ 
 
	  for(int i=1;i<=wb.getSheet("Flow").getLastRowNum();i++)
	  {	  
		  sht= wb.getSheet("Flow");
		  String Flows = sht.getRow(i).getCell(1).getStringCellValue();
		  this.Flows=Flows;
		  System.out.println(Flows);
		 int x=  sht.getLastRowNum();
		 System.out.println(x);
	
		 //
	  for(int j=1;j<=wb.getSheet(Flows).getLastRowNum();j++)
			   { 
				   sht= wb.getSheet(Flows);
				// Getting the Keywords from an excel sheet   
			    String Keyword = sht.getRow(j).getCell(2).getStringCellValue();
			    System.out.println(Keyword);
			    
			    int y=  sht.getLastRowNum();
				 System.out.println(y);
			    
			 // Getting the Objects from an excel sheet  
			    try{
			  String object= sht.getRow(j).getCell(3).getStringCellValue();
			// Initializing local variable to global variable
			  this.object=object;
			  System.out.println(object);
				   } catch (Throwable e) {  
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
			    
			    // Getting select objects from the sheet 
				   try{
						  String selobj= sht.getRow(j).getCell(7).getStringCellValue();
						  this.selobj=selobj;
	                     System.out.println("selobj"+" "+selobj);
						   } catch (Throwable e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
						}	

			 // Getting alphabets from an excel sheet   
				   try{
			  String data= sht.getRow(j).getCell(5).getStringCellValue();
			  this.data=data;
			  System.out.println(data);
			   } catch (Throwable e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				   
 
				// Getting the page source from an excel sheet 
				   try{
						  String pagesource= sht.getRow(j).getCell(6).getStringCellValue();
						  this.pagesource=pagesource;
						  System.out.println(pagesource);
						   } catch (Throwable e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
						}	   
				 
				// Getting proceed on fail permissions from an excel sheet 
				   try{
						  String perm= sht.getRow(j).getCell(4).getStringCellValue();
						  this.perm=perm;
						  System.out.println(perm);
						   } catch (Throwable e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
						}	 			   
				    			   
				// Calling the methods from an excel sheet   
	            Main2 obj1 = new Main2();
				Method m = Main2.class.getMethod(Keyword);
				m.invoke(obj1);
              
			    }// second for-loop ending bracket
  }// first for-loop ending bracket
	  
  } catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	
	/*@AfterTest
	public static void Stoptest()
	{
		driver.quit();
	}*/
}