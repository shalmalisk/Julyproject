package neostoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import neostoxBase.BaseClassNew;


public class ListenerNew extends BaseClassNew implements ITestListener
{
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getName();
		Reporter.log("TC "+methodName+" is completed sucessfully ", true);
	}
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC "+result.getName() +" is failed", true);
		try {
			neostoxPOM.NeoUtilityNew.takeScreenshot(driver, null);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+" is skipped", true);
	}

}

