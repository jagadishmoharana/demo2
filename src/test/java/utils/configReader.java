package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	public static String getProperty(String property ) {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		Properties prop = new Properties();
		
		try {
		FileInputStream fis = new FileInputStream(file);
		//loading properties file
		prop.load(fis);
		}
		catch(Exception e ) {
			e.getMessage();
		}
		//Reading data from properties file
		return prop.getProperty(property);
	}
}
