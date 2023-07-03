package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.BaseSetup;
import Utility.WaitUtility;

public class SdpAdminLogin extends BaseSetup{
	
	
	@Test
	public static void Login() throws InterruptedException {
		WebElement email= driver.findElement(By.xpath("//input[@id='basic_username']"));
		WaitUtility.Explicitwati(driver, 10, email);
		email.sendKeys("admin@mis.com");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='basic_password']"));
		WaitUtility.Explicitwati(driver, 10, password);
		password.sendKeys("mis#123");
		
		WebElement Login=driver.findElement(By.xpath("//*[@id=\"basic\"]/div[3]/button"));
		Login.click();
		
		
	}
	
	@Test
	public static void VerifyTitle() {
	String ActualTitle="Student Doubt Panel";
	String ExpectedTitle=driver.getTitle();
	
	if(ExpectedTitle.equalsIgnoreCase(ActualTitle)) {
		System.out.println("Title verified successfully");
	}
	
	}

}
