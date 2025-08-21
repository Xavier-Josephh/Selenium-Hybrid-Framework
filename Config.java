package com.auto.practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config1 

{

public static WebDriver driver;
public static String usn;
public static String pass;
public static FileInputStream fileInput;
public static File file;
public static Properties prop;
public static String object;
public static String selobj;
public static String data;
public static FileInputStream fis;
public static Workbook wb;
public static Sheet sht;
public static String pagesource;
public static String perm;
//public static Alert alt;

public static void objectRepository()//getting data from object repository
{
	//FileInputStream fileInput = null;
     file = new File("D:\\Automation demo\\object.properties");
	try {
		fileInput = new FileInputStream(file);
		 prop = new Properties();
		prop.load(fileInput);
	//	driver.findElement(By.id(prop.getProperty("Login_email_field"))).sendKeys("test");
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//To open the required browser
public static void openBrowser()
{
 try {
	   FileInputStream fis =new FileInputStream("D:\\Automation demo\\Flowcontroller.xls");
	    wb= WorkbookFactory.create(fis);
	    sht= wb.getSheet("Browser");
	   String data1 = sht.getRow(0).getCell(0).getStringCellValue();
	   System.out.println(data1);
	
	if(data1.equals("IE"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium files\\IEDriverServer_Win32_2.52.0\\IEDriverServer.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get(prop.getProperty("url")); 
	}
	else if(data1.equals("GC"))
	{
     	System.setProperty("webdriver.chrome.driver", "D:\\selenium files\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get(prop.getProperty("url")); 
	}
	
	else
	{
	    driver = new FirefoxDriver();
		driver.manage().window().maximize(); 
		driver.get(prop.getProperty("url")); 
	}
} catch (Exception  e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
