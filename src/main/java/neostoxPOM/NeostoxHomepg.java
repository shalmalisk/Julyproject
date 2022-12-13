package neostoxPOM;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxHomepg {
	
	@FindBy(xpath = "(//a[text()='OK'])[2]")private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement closeButton;
	@FindBy(id = "lbl_username")private WebElement userName;
	@FindBy(id = "lbl_curbalancetop")private WebElement balance;
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logoutButton;

	public NeostoxHomepg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void popUpHandle(WebDriver driver) throws IOException
	{
		if(okButton.isDisplayed())
		{ 
		NeoUtilityNew.wait(driver, 3000);
		okButton.click();
		NeoUtilityNew.ScrollIntoViewt(driver, closeButton);
		closeButton.click();
		Reporter.log("handeling popUp", true);	
		}
		else
		{
			NeoUtilityNew.wait(driver, 2000);
			Reporter.log("There is no popUp", true);
		}
		
				
	}
	
	public String getUserName(WebDriver driver) throws IOException
	{
		
		String actualUserName=userName.getText();
		NeoUtilityNew.takeScreenshot(driver, actualUserName);
		Reporter.log("getting username", true);
		return actualUserName;
	}
	
	public String getBalance(WebDriver driver)
	{
		NeoUtilityNew.wait(driver, 1000);
		String actualBalance=balance.getText();
		Reporter.log("getting actual balance", true);
		return actualBalance;
		
	}
public void logoutFromNeostox(WebDriver driver)
{
	NeoUtilityNew.wait(driver, 1000);
	userName.click();
	NeoUtilityNew.wait(driver, 1000);
	logoutButton.click();
}



}

