package BaseClass;

import org.testng.annotations.BeforeMethod;

import Utility.WaitUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class FacultyBase {
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static Properties Chat=new Properties();
	
	public static FileReader fr;
	public static FileReader FacChat;
	
	
	
	
  @BeforeMethod
  public static void FacultyBaseSetup() throws IOException {
	  
	  if(driver==null) 
	  {
		  fr=new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/config.properties");
		  FacChat=new FileReader(System.getProperty("user.dir")+"src/test/resources/Configfiles/ChatFaculty.properties");
		  prop.load(fr);
		  Chat.load(FacChat);
		  
	  }
	  if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
	  {
			ChromeOptions option = new ChromeOptions(); //base
	        option.addArguments("--remote-allow-origins=*"); //base
			
			WebDriverManager.chromedriver().setup(); //base
			
			driver=new ChromeDriver(option);
			driver.get(prop.getProperty("URL"));
	  }
	  else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
//			FirefoxOptions option = new FirefoxOptions(); //base
//	        option.addArguments("--remote-allow-origins=*"); //base
			
			WebDriverManager.firefoxdriver().setup(); //base
			WebDriver driver=new FirefoxDriver();
			driver.get(prop.getProperty("URL"));
		}	  
  }

  	@AfterMethod
  	public void afterMethod() throws InterruptedException{
// // Click on the Ok button to logout
  		Actions act1=new Actions(driver);
  		
		WebElement OK=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div/div[2]/button[2]"));
		Thread.sleep(1000);
		act1.moveToElement(OK).click().perform();
  
		driver.close();
		
  	}

}
