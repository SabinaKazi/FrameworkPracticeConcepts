package testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import utilities.ConfigReader;
import utilities.LogUtil;

public class LoginTest extends BaseTest{
	
	@Parameters({"username", "password"})
	@Test
	public void LoginWithValidCredentials(String username, String password) throws IOException, InterruptedException
	{
		//ConfigReader.loadProperties();
		//String username = ConfigReader.getProperties("username");
		//String password = ConfigReader.getProperties("password");
		
		LogUtil.info("login with valid credentials");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		Thread.sleep(3000);
		login.enterPassword(password);
		Thread.sleep(3000);
		login.clickLogin();
		LogUtil.info("Successfully logged in");
		
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Swag Labs","Login Failed");
	}
	

}
