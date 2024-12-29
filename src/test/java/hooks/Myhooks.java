package hooks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class Myhooks {
	WebDriver driver;
	 @Before
	 public void setup() {
		DriverFactory.initializeBrowser(configReader.getProperty("browser"));
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(configReader.getProperty("url"));
	 }
	  @After
	    public void teardown(Scenario scenario) {

	            try {
	                Alert alert = driver.switchTo().alert(); // Switch to alert
	                alert.accept();// accept the alert
	            } catch (Exception e) {
	                System.out.println("No alert present: " + e.getMessage());
	            }

	            // Check if the scenario failed
	            if (scenario.isFailed()) {
	                // Capture screenshot as bytes
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	                //Get the scenario name
	                String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
	                // Attach the screenshot to the Cucumber report
	                scenario.attach(screenshot, "image/png", scenarioName);
	            }
	       
	            if (driver != null) {
	                driver.quit();
	            }
	     
	    }
	
}
