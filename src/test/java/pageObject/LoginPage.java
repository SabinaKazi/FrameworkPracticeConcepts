package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement passWord;
	
	@FindBy(id = "login-button")
	WebElement login_Btn;
	
	public void enterUsername(String username)
	{
		userName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passWord.sendKeys(password);
	}
	
	public void clickLogin()
	{
		login_Btn.click();
	}
	
	
	
	
	
	
	
	

}
