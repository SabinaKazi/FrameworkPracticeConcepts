package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {


	public static void captureScreenshot(String testname,WebDriver driver) throws IOException 
	{
		try {
			
			String filepath = System.getProperty("user.dir") + "/src/test/resources/screenshots/";
			
			 // Create folder if not exists
            File directory = new File(filepath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
                
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(filepath + testname + "_" + timestamp + ".png");
			FileUtils.copyFile(src, dest);

			System.out.println("✅ Screenshot saved at: " + dest.getAbsolutePath());
		}catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }
	}
	
}
