package testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import utilities.ConfigReader;
import utilities.LogUtil;
import utilities.ReadExcelDDT;

public class LoginTestDDT extends BaseTest{
	
	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException
	{
		return ReadExcelDDT.getExcelData("Saucedemo");
		
	}
	
	
	@Test(dataProvider = "loginData")
	public void LoginWithValidCredentials(String username, String password) throws IOException
	{
		
		
		LogUtil.info("login with valid credentials");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLogin();
		LogUtil.info("Successfully logged in");
		
		
		
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	

}
