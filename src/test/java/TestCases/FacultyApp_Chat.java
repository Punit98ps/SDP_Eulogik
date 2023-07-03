package TestCases;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import BaseClass.FacultyBase;


public class FacultyApp_Chat extends FacultyBase{
	
  @Test
  public void FacultyChat() throws Exception {
	  FacultyApp_Login.Login();
	  Actions a =new Actions(driver);
	  driver.manage().window().maximize();
	  
	   
	  //To verify the heading of Faculty application
	  Thread.sleep(1000);
	  WebElement heading_text = driver.findElement(By.xpath("//*[@id=\"screen\"]/div[1]/div[1]/div[1]/h1"));
	  String text = heading_text.getText();
	  System.out.println(text);
  
	  //Search filter
	  WebElement search=driver.findElement(By.xpath(Chat.getProperty("Search")));
	  search.click();

	  String searchtext="prin";	  
	  search.sendKeys(searchtext);
	  Thread.sleep(2000);
	  for(int i=0; i<=searchtext.length();i++)
	  {
		  search.sendKeys(Keys.BACK_SPACE);
	  }
	  System.out.println("Cleared");
	  
	  //Select the date form the date picker
	  WebElement startDate = driver.findElement(By.xpath("//*[@id=\"screen\"]/div[1]/div[2]/div/div[1]/input"));
	  a.moveToElement(startDate).click().perform();
	  Thread.sleep(2000);
	  
	  WebElement selectDate =driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/div[2]/table/tbody/tr[1]/td[7]/div"));
	  a.moveToElement(selectDate).click().perform();
	  Thread.sleep(1000);
	  
	  //Select the date automatically current date
	  LocalDate date = java.time.LocalDate.now();
	  System.out.println(java.time.LocalDate.now());
	  
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div[1]/div[2]/div/div[3]/input")).sendKeys(date.toString());
	  
	  //select the top chat automatically
	  List<WebElement> allChats = driver.findElements(By.xpath("//*[@id=\"screen\"]/div[2]/div[1]/div"));
	  System.out.println(allChats.size());
  
	  Thread.sleep(3000);
	  WebElement first_chat = driver.findElement(By.xpath("//*[@id=\"screen\"]/div[2]/div[1]/div[1]"));
	  first_chat.click();  
	
	  //Respected Chat input box 
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div[2]/div[1]/div[3]/div/div[2]/div[3]/p")).click();
	  
	  //click on the answer and query button
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div[2]/div[2]/div/div[3]/div/button[1]")).click();
	  
	  //Send keys in the input text
	  Thread.sleep(1000);
	  WebElement inputText = driver.findElement(By.xpath("//*[@id=\"screen\"]/div[2]/div[2]/div/div[3]/span/input"));
	  inputText.sendKeys("yes i can unsderstand the doubt");
	  
	  //click on send button
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div[2]/div[2]/div/div[3]/span/span/button")).click();
	  
	  //Click on close button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div[2]/div[2]/div/div[3]/div/button[2]")).click();
	  
	  //Click on reopen link tab
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"screen\"]/div[2]/div[2]/div/div[3]/p/span")).click();
	  
//	  //To select the camera
//	  Thread.sleep(1000);
//	  driver.findElement(By.cssSelector("#screen > div.w-full.flex.flex-1.p-2.overflow-hidden.gap-4 > div.chatBox.flex-auto.w-full.lg\\:block.rounded-md.bg-gray-50.shadow-md.overflow-hidden > div > div:nth-child(4) > div.mr-2.flex.justify-center.items-center > div > svg > path")).click();
//	  
	  //mover mouse to logout
	  WebElement Logout=driver.findElement(By.xpath("//*[@id=\"screen\"]/div[1]/div[1]/div[3]/span/span"));
	  a.moveToElement(Logout).click().perform();	
	  
	  WebElement clickLogout= driver.findElement(By.xpath("//*[@id=\"screen\"]/div[1]/div[1]/div[3]/div/div[2]/button"));
	  a.moveToElement(clickLogout).click().perform();
	  
	  
	  
	  
	  
	  
	  
  }
}
