package TestCases;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;  
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import BaseClass.BaseSetup;

import org.openqa.selenium.JavascriptExecutor;

import TestCases.SdpAdminLogin;
import Utility.WaitUtility;

public class ReportsWindow extends BaseSetup  {
	//public static SdpAdminLogin login = new SdpAdminLogin();
	
	
  @Test
  public static void Reports() throws InterruptedException {
	  Thread.sleep(3000);
	  SdpAdminLogin.Login();

	 
	  Thread.sleep(2000);
	  Actions action = new Actions(driver);
	  
	  //To Refresh the page	  
	  Thread.sleep(1000);
	  driver.get("https://doubts.aptstudy.com/admin/report");
	  driver.navigate().refresh();
	  System.out.println("Refresh successfully");
	  
	//To close the message of successfully login
//	  Thread.sleep(1000);
//	  WebElement closemsg =driver.findElement(By.cssSelector(loc.getProperty("loginmsg")));
//	  action.moveToElement(closemsg).click().perform();
  
	  //To verify the heading of the landing page
	  Thread.sleep(1000);
	  WebElement heading_text = driver.findElement(By.xpath(loc.getProperty("ReprotHeading")));
	  String text = heading_text.getText();
	  System.out.println(text);
	 
	  //To perform action on menu bar
	
	  Thread.sleep(4000);
	  WaitUtility.Explicitwati(driver, 20, heading_text);
	  WebElement anchor = driver.findElement(By.cssSelector(loc.getProperty("menu"))); 
	  action.moveToElement(anchor).click().perform();
	  System.out.println("clicked on menu");
	
	  //Close icon of menu
	  Thread.sleep(3000);
	  WebElement close=driver.findElement(By.xpath(loc.getProperty("Closemenu")));
	  WaitUtility.Explicitwati(driver, 50, close);
	  close.click();
	  System.out.println("menu close successfully");
	  
	  //page navigation bar
	  Thread.sleep(1000);
	  WebElement pageBar=driver.findElement(By.cssSelector(loc.getProperty("SideArrowClick")));
	  action.moveToElement(pageBar).click().perform();
	  
	  Thread.sleep(1000);
	  //driver.findElement(By.xpath(loc.getProperty("DirectSelect"))).click();
	  
//	  Thread.sleep(1000);
//	  //Scroll Function
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,1000)");
	  
	  //click on the filter  
	  Thread.sleep(2000); 
	  WebElement Filter=driver.findElement(By.cssSelector(loc.getProperty("FilterIcon")));
	  WaitUtility.Explicitwati(driver, 60, Filter);
	  action.moveToElement(Filter).click().perform();
	  
	  
	  String from = "2023-04-01";

	  LocalDate l = java.time.LocalDate.now();
	  System.out.println(java.time.LocalDate.now());
	  Thread.sleep(1000);  
	    
	  // --------ENTER FROM DATE-----------
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(from);
	  //click on the date 
	  
	  // -------- ENTER TO DATE-----------
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div[2]/div/div[1]/div/div[3]/input")).sendKeys(l.toString());
	  
	  
	  // Filter properties
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(filt.getProperty("Student1"))).click();
  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(filt.getProperty("Student2"))).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(filt.getProperty("Student3"))).click();
	  
	  //Subject
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(filt.getProperty("Accounts"))).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(filt.getProperty("POBAA"))).click();
	    
	  //Faculty
	  driver.findElement(By.xpath(filt.getProperty("ShashankPatel"))).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(filt.getProperty("MadhavPrajapati"))).click();
	  
	  //Status 
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(filt.getProperty("Close")));
  
	  //Apply Button  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(filt.getProperty("Apply"))).click();
	  
	  Thread.sleep(1000);
	  System.out.println("Clicked on Apply successsfully");
	  
	  //Doubt Chart
	  Thread.sleep(1000);
	  WebElement chart=driver.findElement(By.cssSelector("#root > div > section > div.text-xl.text-gray-900.font-semibold.h-14.md\\:h-16.\\!w-full > div.flex.flex-wrap.items-center.justify-between.py-3.px-5 > div > div > svg:nth-child(1)"));
	  WaitUtility.Explicitwati(driver, 10, chart);
	  action.moveToElement(chart).click().perform();
	  System.out.println("click on chart");
	  
	  //
	  Thread.sleep(1000);
	  WebElement closeAddFaculty = driver.findElement(By.cssSelector("body > div:nth-child(3) > div > div.ant-modal-wrap > div > div.ant-modal-content > button > span > span > svg > path"));
	  action.moveToElement(closeAddFaculty).click().perform();
  
	  }
}
