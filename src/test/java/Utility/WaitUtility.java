package Utility;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriver driver;
	//implicit wait
	public  static void implicitwait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	//page load wait
	public static void pageloadwait(WebDriver driver,int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	//Explicit wait
	public static void Explicitwati(WebDriver driver,int sec, WebElement ele) {
		WebDriverWait ww=new WebDriverWait(driver, Duration.ofSeconds(sec));
		ww.until(ExpectedConditions.visibilityOf(ele));
	}
	//Fluent wait
	//This defines the total amount of time to wait
	public static void fluentwait(WebDriver driver,int sec, WebElement ele, int pollingfrq) {
	Wait<WebDriver>fluentwait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)) // we make generic here to restrict the type
	//This defines the polling frequency
	.pollingEvery(Duration.ofSeconds(sec))
	//This defines the exception to ignore
	.ignoring(NoSuchElementException.class);
	
		fluentwait.until(new Function <WebDriver,WebElement>(){
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.id("fw"));
		}
		
	});
	
	}
	public static WebElement until(ExpectedCondition<WebElement> visibilityOfElementLocated) {
		// TODO Auto-generated method stub
		return null;
	}
}
