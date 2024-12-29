package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;

public class Signup {
	
	WebDriver driver;
	WebDriverWait wait;
	
	SignupPage signup;

    
	@Given("User is on the Sign up page")
	public void user_is_on_the_sign_up_page() {
	   	 driver = DriverFactory.getDriver();
         wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
         signup = new SignupPage(driver);
		 signup.visit_signup();
	}

	@When("User enter valid username {string} into Username field")
	public void user_enter_valid_username_into_username_field(String string) {
	
		 signup.setUsername(string);
	}

	@And("User enter valid password {string} into Password field")
	public void user_enter_valid_password_into_password_field(String string) {
		signup.setPassword(string);
	}

	@And("User clicks signup")
	public void user_clicks_signup() {
		signup.clickOnSignup();
	}

	@Then("User should successfully signup and {string} should be display")
	public void user_should_successfully_signup_and_should_be_display(String string) {
        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertTrue(alertText.equals(string));
        driver.quit();
	}

	@And("User enter invalid password {string} into Password field")
	public void user_enter_invalid_password_into_password_field(String string) {
		signup.setPassword(string);
	}

	@Then("User should not able to signup and get an message {string}")
	public void user_should_not_able_to_signup_and_get_an_message(String string) {
        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertTrue(alertText.equals(string));
        driver.quit();
	}

	@When("User leave Username field as blank")
	public void user_leave_username_field_as_blank() {
        signup.setUsername("");
	}

	@And("User leave Password field as blank")
	public void user_leave_password_field_as_blank() {
        signup.setPassword("");
	}

	@Then("User should get {string} and not able to signup")
	public void user_should_get_and_not_able_to_signup(String string) {
        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertTrue(alertText.equals(string));
        driver.quit();
	}
}
