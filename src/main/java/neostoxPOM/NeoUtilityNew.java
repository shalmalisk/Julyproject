package neostoxPOM;


	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

	import java.time.Duration;

import java.util.Properties;


import org.apache.poi.EncryptedDocumentException;
	
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.io.FileHandler;
	import org.testng.Reporter;




	public class NeoUtilityNew 
	{
		public static String readDataFromPropertyFile(String key) throws EncryptedDocumentException, IOException
		{
			Properties prop=new Properties();
			FileInputStream myfile=new FileInputStream("C:\\Users\\wel\\eclipse-workspace\\23JulyMorning\\neostoxPropertyfile.propertis");
			prop.load(myfile);
			String value=prop.getProperty(key);
			Reporter.log("reading value of"+key+"from proprty file", true);
			return value;
			
	     }
		public static void takeScreenshot(WebDriver driver, String filename) throws IOException
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			 File dest= new File("C:\\Program Files\\Selenium\\screenshot\\ss.jpg"+ filename +"jpg");
		
			FileHandler.copy(src, dest);
			Reporter.log("Taking screenshot", true);
			
		}
		public static void wait(WebDriver driver, int waittime)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
			Reporter.log("Waiting for"+waittime+"milisec", true);
		}
		public static void ScrollIntoViewt(WebDriver driver, WebElement element) throws IOException
		{
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView[true]",element);
			 Reporter.log("Scrolling to view"+element.getText(), true);
		}
	}



