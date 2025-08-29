package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
	public static Properties prop;
	
	public static void loadProperties() throws IOException
	{
		
	try {
		
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\Config";
	FileInputStream fis = new FileInputStream(filepath);
	prop = new Properties();
	prop.load(fis);
	}catch(FileNotFoundException e)
	{
		System.out.println(e.getMessage());
	}
	}
		
	
	public static String getProperties(String key)
	{
		if (prop == null) {
            throw new IllegalStateException("Properties not loaded. Call loadProperties() first.");
        }
        return prop.getProperty(key);

}
}
