package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static JavaScriptUtility js;
	public static PropertyUtility utility=new PropertyUtility();
	
	@BeforeClass
	public void launchingBrowser()
	{
		if(utility.readingDataFromPropertyFile("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (utility.readingDataFromPropertyFile("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (utility.readingDataFromPropertyFile("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void navigateToApplication()
	{
		driver.get(utility.readingDataFromPropertyFile("url"));
	}
	
	@AfterMethod
	public void loginToApplication()
	{
	
	}
//	@AfterClass
//	public void tearDownTheBrowser()
//	{
//		driver.quit();
//	}
	
//	public static void main(String[] args) {
//		WebDriverManager.chromedriver().clearDriverCache().setup();
//		WebDriverManager.chromedriver().clearResolutionCache().setup();
//		 driver=new ChromeDriver();
//	}

}
