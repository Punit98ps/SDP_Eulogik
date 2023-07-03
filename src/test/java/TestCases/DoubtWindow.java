package TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import BaseClass.BaseSetup;
import Utility.WaitUtility;

public class DoubtWindow extends BaseSetup{

	
  @Test
  public static void Chat() throws Exception {
	  Properties db = new Properties();
//	  FileInputStream fip = null;
	  
	  Thread.sleep(3000);
	  //ReportsWindow.Reports();
	  SdpAdminLogin.Login();
	  //FacultyWindow.AddFaculty();
	  Actions action = new Actions(driver);
	  
	  //To Refresh the page  
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
	  
	  //Click on the doubts
	  Thread.sleep(2000);
	  WebElement Doubts=driver.findElement(By.xpath(loc.getProperty("DoubtsMenu")));
	  WaitUtility.Explicitwati(driver, 30, Doubts);
	  action.moveToElement(Doubts).click().perform();
	  
	  //Close icon of menu
	  Thread.sleep(3000);
	  WebElement close=driver.findElement(By.cssSelector(loc.getProperty("Closemenu")));
	  WaitUtility.Explicitwati(driver, 50, close);
	  close.click();
	  System.out.println("menu close successfully");
	  
	  //Verifying the heading text
	  Thread.sleep(1000);
	  
//	  fip = new FileInputStream("/home/eulogik/Desktop/counselling app/NewProject/SDP/src/test/resources/Configfiles/db.properties");
//      db.load(fip);
	  
	  
	  WebElement heading_Doubts = driver.findElement(By.cssSelector("//*[@id=\"root\"]/div/section/div[2]/div[1]/a/span"));
	  String text1 = heading_Doubts.getText();					
	  System.out.println(text1);
	  
	  //Explore search input box
	  Thread.sleep(1000);
	  WebElement search=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div[2]/div[1]/span/input"));
	  search.click();
	  
	  String entered = "ph";
	  search.sendKeys(entered);
	  Thread.sleep(1000);
	  
	  for(int i=0; i<=entered.length();i++)
	  {
	  search.sendKeys(Keys.BACK_SPACE);
	  }
	  
	  System.out.println("Cleared");
	 
	  //click on the doubt
	  Thread.sleep(3000);
	  WebElement accessDoubt=driver.findElement(By.xpath("//*[@id=\"screen\"]/div/div[1]/div[8]/div/div[2]/div[3]"));
	  accessDoubt.click();
	  System.out.println("click on doubt successfully");
	  
	  //Click on the answer and query button
	  Thread.sleep(3000);
	  WebElement answerButton = driver.findElement(By.xpath("//*[@id=\"screen\"]/div/div[2]/div/div[3]/div/button[1]"));	  
	  String Answer =answerButton.getText();
	  System.out.println(Answer);
	  
	  if(Answer.equals("Answer?")) 
	  {
		  answerButton.click();
	  }
	  else {
		  System.out.println("Not an answer key");
	  }
	  
	  //Entering input text 
	  Thread.sleep(1000);
	  WebElement text=driver.findElement(By.xpath("//*[@id=\"screen\"]/div/div[2]/div/div[3]/span/input"));
	  text.click();
	  text.sendKeys("Hi this is punit sahu have some doubt on the sdp doubt flow");
	  
	  //Click on the send button
	  Thread.sleep(1000);
	  WebElement button=driver.findElement(By.xpath("//*[@id=\"screen\"]/div/div[2]/div/div[3]/span/span/button"));
	  button.click();
	  
	  //Click on the close doubt button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div/div[2]/div/div[3]/div/button[2]")).click();
	  
	  //Click on the reopen doubt
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div/div[2]/div/div[3]/p/span")).click();  
	  
	  //click on the filter  
	  Thread.sleep(2000);  
	  WebElement Filter=driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div[1]/div/div"));
	  WaitUtility.Explicitwati(driver, 60, Filter);
	  action.moveToElement(Filter).click().perform();
  
	  Thread.sleep(1000);
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
	  
	  
	  
	  
  }
}
