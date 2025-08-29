package utilities;

import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	static WebDriver driver;
	
	
	public static void waitForVisibility(WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToBeCLickable(WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBeSelected(WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public static void waitForPollingTime(int timeout, int pollingtime, String msg)
	{
		FluentWait<WebDriver> wait = new FluentWait <>(driver)
				.pollingEvery(Duration.ofSeconds(pollingtime))
				.withTimeout(Duration.ofSeconds(timeout))
				.withMessage(msg)
				.ignoring(NoSuchElementException.class)
				.ignoreAll(Arrays.asList(
			            NoSuchElementException.class,
			            StaleElementReferenceException.class));
	}

}
