package neostoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseClassNew {
protected WebDriver driver;
	
	public void launchBrowser() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\wel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(neostoxPOM.NeoUtilityNew.readDataFromPropertyFile("url"));
		
		
		
		
		
		
		
		neostoxPOM.NeoUtilityNew.wait(driver, 1000);
	}
	public static void closingBrowser(WebDriver driver) throws InterruptedException
	{
		Reporter.log("Closing browser", true);
		Thread.sleep(1000);
		driver.close();
	}

}
