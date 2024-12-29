package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login {

	WebDriver driver;
	WebDriverWait wait;
	
	LoginPage login;



    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
   	 driver = DriverFactory.getDriver();
     wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
     login = new LoginPage(driver);
    	login.visitLogin();
    }

    @When("User enter valid username {string} into username field")
    public void user_enter_valid_username_into_username_field(String string) {
    	login.setUsername(string);
    }

    @And("User enter valid password {string} into password field")
    public void user_enter_valid_password_into_password_field(String string) {
    	login.setPassword(string);
    }

    @And("User clicks login")
    public void user_clicks_login() {
    	login.clickOnLogin();
    }

    @Then("User should successfully login and {string} should be display")
    public void user_should_successfully_login_and_should_be_display(String string) {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))).getText();
        Assert.assertTrue(text.equals(string));
        driver.quit();
    }

    @When("User enter invalid password {string} into password field")
    public void user_enter_invalid_password_into_password_field(String string) {
    	login.setPassword(string);
    }

    @Then("User should not able to login and get an message {string}")
    public void user_should_not_able_to_login_and_get_an_message(String string) {
        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertTrue(alertText.equals(string));
        driver.quit();
    }

    @When("User enter invalid username {string} into username field")
    public void user_enter_invalid_username_into_username_field(String string) {
    	login.setUsername(string);
    }

    @And("User leave username field as blank")
    public void user_leave_username_field_as_blank() {
    	login.setUsername("");
    }

    @And("User leave password field as blank")
    public void user_leave_password_field_as_blank() {
    	login.setPassword("");
    }

    @Then("User should get {string} and not able to login")
    public void user_should_get_and_not_able_to_login(String string) {
        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertTrue(alertText.equals(string));
        driver.quit();
    }
}
