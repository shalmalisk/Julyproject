package neostoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Neostoxloginpg {
	
	
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber")  private WebElement mobileNumField;
	@FindBy(id="lnk_signup1") private WebElement signinButton;
	
	public Neostoxloginpg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobNum(WebDriver driver,String num)
	{
		mobileNumField.sendKeys(num);
		
	}
	public void clickOnSigninButton(WebDriver driver)
	{
		signinButton.click();
		NeoUtilityNew.wait(driver, 2000);
	}
}
