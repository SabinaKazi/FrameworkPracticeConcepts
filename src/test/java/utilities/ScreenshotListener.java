package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testCases.BaseTest;

public class ScreenshotListener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String testname = result.getName();
		// Access the driver instance from BaseTest
	    WebDriver driver = ((BaseTest) result.getInstance()).driver;
		try {
			ScreenshotUtil.captureScreenshot(testname,driver);
		} catch (IOException e) {
			//check with message also
			e.printStackTrace();
		}
	}
	
	

}
