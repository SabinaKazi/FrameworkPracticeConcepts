package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.BrowserUtils;
import utilities.ConfigReader;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		ConfigReader.loadProperties();
		
		String browser = ConfigReader.getProperties("browser");
		String url = ConfigReader.getProperties("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			 driver = BrowserUtils.launchChromeBrowser();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else{
			 throw new RuntimeException("Browser not supported: " + browser);
		}
		
		
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		  if (driver != null) {
		//driver.close();
		  }
	}
	
	public void randomString()
	{
		
	}

	public static void randonNumber()
	{
		
	}
}
