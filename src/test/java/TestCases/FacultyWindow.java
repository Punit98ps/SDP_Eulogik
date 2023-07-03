package TestCases;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import BaseClass.BaseSetup;
import TestCases.SdpAdminLogin;
import Utility.WaitUtility;

public class FacultyWindow extends BaseSetup {
	
  @Test
  public static void AddFaculty() throws InterruptedException {
	  Thread.sleep(1000);
	  SdpAdminLogin.Login();
	  //ReportsWindow.Reports(); 
	  Actions action = new Actions(driver);
	  
	  Thread.sleep(1000);
	  driver.get("http://192.168.1.12:3000/admin/report");
	  driver.navigate().refresh();
	  System.out.println("Refresh successfully");
	  
	  //Find the menu
	  Thread.sleep(1000);
	  WebElement anchor = driver.findElement(By.cssSelector(loc.getProperty("menu")));
	  WaitUtility.Explicitwati(driver, 20, anchor);
	  action.moveToElement(anchor).click().perform();
	  System.out.println("clicked on menu");
	  
	  //Click on faculty
	  Thread.sleep(1000);
	  WebElement Faculty=driver.findElement(By.cssSelector("#root > div > section > div.bg-\\[\\#FFFFFF\\].min-h-screen.w-1\\/6.duration-500.text-black-100 > div > div.flex.flex-row.justify-center.align-center.mt-8 > ul > li:nth-child(2) > a > a > span"));
	  WaitUtility.Explicitwati(driver, 30, Faculty);
	  action.moveToElement(Faculty).click().perform();
	  
	  //Close icon of menu
	  Thread.sleep(3000);
	  WebElement close=driver.findElement(By.cssSelector(loc.getProperty("Closemenu")));
	  WaitUtility.Explicitwati(driver, 50, close);
	  close.click();
	  System.out.println("menu close successfully");
	  
	  //Add faculty button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(fty.getProperty("AddFaculty"))).click();
	  
	  //Faculty name input box
	  Thread.sleep(1000);
	  WebElement Name=driver.findElement(By.xpath(fty.getProperty("FacultyName")));
	  Name.click();
	  Name.sendKeys("Punit Sahu");
	  
	  //Faculty Email input box
	  Thread.sleep(1000);
	  WebElement Email=driver.findElement(By.xpath(fty.getProperty("FacultyEmail")));
	  Email.click();
	  Email.sendKeys("Raj@Apt.com");
	  
	  //Faculty mobile number input box
	  Thread.sleep(1000);
	  WebElement MobNo=driver.findElement(By.xpath(fty.getProperty("FacultyMob")));
	  MobNo.click();
	  MobNo.sendKeys("9981964532");
	  
	  // Clicking on SUBJECT DROPDOWN ....
	  Thread.sleep(1000); 
	  WebElement dropdown =  driver.findElement(By.xpath("//*[@id=\"rc_select_0\"]"));
	  dropdown.click();

//	  WebElement last_element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[1]/div/div/div[4]/div"));
//	 
//
//     // Click an option in the dropdown
//     WebElement option = WaitUtility.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown-options']/div[5]")));
//     action.moveToElement(option).click().perform();
//	 
	 
	  
	  List <WebElement> subjects = driver.findElements(By.className("ant-select-item-option-content"));
	  System.out.println(subjects.size());
	 
	  Thread.sleep(2000); 
	  WebElement last = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[1]/div/div/div[3]/div"));
	  new Actions(driver)
      .moveToElement(last)
      .click()
      .perform();
	  
  
	  //Add faculty button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(fty.getProperty("AddFacultyButton"))).click();
	  
	  //close error message
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(fty.getProperty("CloseErrorMsg"))).click();
	  
	  //Close add faculty window
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(fty.getProperty("CloseAddFacutly"))).click();
	  
	  //page navigation bar
	  Thread.sleep(1000);
	  WebElement pageBar=driver.findElement(By.cssSelector(loc.getProperty("SideArrowClick")));
	  action.moveToElement(pageBar).click().perform();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(loc.getProperty("DirectSelect"))).click();
	    
	  //Change the status of the faculty
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(fty.getProperty("ActionStatus"))).click();
	  
	  	 
	  List <WebElement> pagination = driver.findElements(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div[2]/div/div[2]/div[2]/ul/li"));
	  System.out.println("Total pages are:"+ pagination.size());
	  
	  for(WebElement ele: pagination)
	  {
		 Iterator<WebElement> r=  pagination.iterator();
		 Thread.sleep(1000);
		 ele.click();
		 r.next();
	  }
	  
	  
	  
//      boolean b = last.isDisplayed();
//      
//      if(b){
//          System.out.println("Element is visible");
//       }
//      else
//      {
//          System.out.println("Element is not visible");
//      }
//  
//		 for (WebElement suggestion : subjects)
//		 {
//		   System.out.println(suggestion.getText());
//	       System.out.println(suggestion.getAccessibleName());
//	     }
		 
		 
		 
////		 
////	 Thread.sleep(1000);
////	 driver.findElement(By.cssSelector(fty.getProperty("AddFacultyButton"))).click();
//	 
//	 
////		 for(int i=0; i<subjects.size(); i++)
////		 {
////		 subjects.get(i).getAccessibleName();
////		 subjects.get(i).click();
////		 }

  

	    
  }
}
