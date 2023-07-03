package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;


public class BaseSetup {
  
		public static WebDriver driver;
		public static Properties prop=new Properties();
		public static Properties loc=new Properties();
		public static Properties filt=new Properties();
		public static Properties fty=new Properties();
		//public static Properties db=new Properties();
		public static FileReader fr;
		public static FileReader fr1;
		public static FileReader fil;
		public static FileReader faculty;
		//public static FileReader dbt;
		
		@BeforeMethod
		public void setup() throws IOException {
			
			if(driver==null) {
				fr=new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/config.properties");
				fr1=new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/Reports.properties");
				fil=new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/Filter.properties");
				faculty=new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/Faculty.properties");
				//dbt=new FileReader(System.getProperty("user.dir")+"/src/test/resources/Configfiles/db.properties");
				prop.load(fr);	 //for config files
				loc.load(fr1);	 //for Reports	
				filt.load(fil);  //for filter
				fty.load(faculty);// Load faculty
				//db.load(dbt);  //Load doubt
			}
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				ChromeOptions option = new ChromeOptions(); //base
		        option.addArguments("--remote-allow-origins=*"); //base
				
				WebDriverManager.chromedriver().setup(); //base
				
				driver=new ChromeDriver(option);
				driver.get(prop.getProperty("url"));
				
			}
			else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
//				FirefoxOptions option = new FirefoxOptions(); //base
//		        option.addArguments("--remote-allow-origins=*"); //base
				
				WebDriverManager.firefoxdriver().setup(); //base
				WebDriver driver=new FirefoxDriver();
				driver.get(prop.getProperty("url"));
			}
		}
//  @AfterMethod
//  public void beforeTest() {
//	  driver.quit();
//	  
//  }

}
