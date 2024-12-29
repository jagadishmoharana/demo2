package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	static WebDriver driver;
	public static void initializeBrowser(String browsername) {
		browsername = browsername.toLowerCase();
		switch (browsername) {
		case "chrome":
			driver = new ChromeDriver(); 
			break;
		case "edge":
			driver = new EdgeDriver(); 
			break;
		case "firefox":
			driver = new FirefoxDriver(); 
			break;

		default:
			driver = new ChromeDriver();
		}
		
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
