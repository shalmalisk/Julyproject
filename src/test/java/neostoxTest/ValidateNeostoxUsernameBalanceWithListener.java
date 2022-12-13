package neostoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import neostoxBase.BaseClassNew;
import neostoxPOM.NeostoxHomepg;
import neostoxPOM.NeostoxPasswordpg;
import neostoxPOM.Neostoxloginpg;

@Listeners(neostoxUtility.ListenerNew.class)

public class ValidateNeostoxUsernameBalanceWithListener extends BaseClassNew
  {
	Neostoxloginpg login;
	NeostoxPasswordpg password;
	NeostoxHomepg home;
	
	@BeforeClass
	public void launchNeostox() throws IOException 
	{
	launchBrowser();
	login =new Neostoxloginpg(driver);
	password=new NeostoxPasswordpg(driver);
	home=new NeostoxHomepg(driver);
	}
	
	@BeforeMethod
	public void loginToNeostox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.enterMobNum(driver, neostoxPOM.NeoUtilityNew.readDataFromPropertyFile("num"));
		login.clickOnSigninButton(driver);
		Thread.sleep(1000);
		password.sendPassword(driver, neostoxPOM.NeoUtilityNew.readDataFromPropertyFile("pswd"));
		password.clickOnSubmitButton(driver);
		Thread.sleep(2000);
		home.popUpHandle(driver);
	}
	
	
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	Assert.assertEquals(home.getUserName(driver), neostoxPOM.NeoUtilityNew.readDataFromPropertyFile("userName"),"Expected & actual userName Not matching TC failed");
	 Reporter.log("Actual userName is "+home.getUserName(driver), true);   
  }
  
  @Test
  public void validateBalance()
  {
	  Assert.assertNotNull(home.getBalance(driver),"Balance is Null TC failed");  
	  Reporter.log("Account balance is"+home.getBalance(driver), true);
  }
  
  @AfterMethod
  public void logout()
  {
	  home.logoutFromNeostox(driver);
  }
  
   @AfterClass
  public void closeapplication() throws InterruptedException
  {
	  closingBrowser(driver);
  }
}
