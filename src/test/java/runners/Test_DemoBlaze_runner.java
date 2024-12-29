package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//With TestNG
@CucumberOptions(
		features = "src/test/resources/features/",
		glue={"stepdefinitions","hooks"},
		dryRun=false,
		plugin={"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber.json"},
		monochrome= true,
		publish = true
	)
public class Test_DemoBlaze_runner extends AbstractTestNGCucumberTests{
	
}
