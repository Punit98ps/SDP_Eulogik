package TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import BaseClass.FacultyBase;
import Utility.WaitUtility;

public class FacultyApp_Login extends FacultyBase {
		
  @Test
  public static void Login() {
	  
	  //Find the Mobile number input text bar
	  WebElement Mobile=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[4]/input"));
	  WaitUtility.Explicitwati(driver, 20, Mobile);
	  Mobile.click();
	  Mobile.sendKeys("1256458945");
	  
	  //Click on the GetOTP button
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[4]/div/button")).click();
	   
	  
  }
}
