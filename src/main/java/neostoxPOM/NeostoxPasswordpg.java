package neostoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class NeostoxPasswordpg {
	@FindBy(id = "txt_accesspin")private WebElement passwordField;
	@FindBy(xpath = "//a[text()='Submit']")private WebElement submitButton;
	
	public NeostoxPasswordpg(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	public void sendPassword(WebDriver driver, String pswd)
	{
		NeoUtilityNew.wait(driver, 1000);
		passwordField.sendKeys(pswd);
		Reporter.log("sending password", true);
	}
	public void clickOnSubmitButton(WebDriver driver)
	{
		submitButton.click();
		Reporter.log("Clicking on submit button.", true);
	}
}
