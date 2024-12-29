package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductPage;

public class Demoblaze_e2e {
	WebDriver driver;
	WebDriverWait wait;
	
	LoginPage login;
	HomePage  home;
	ProductPage product;
	CartPage cart;
	LogoutPage logout;

    

    @Given("User navigate to  login page")
    public void user_navigate_to_login_page() {
       	driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
        login = new LoginPage(driver);
        home = new HomePage(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);
        logout = new LogoutPage(driver);
    	login.visitLogin();
    }

    @When("User enters valid username {string} into username field")
    public void user_enters_valid_username_into_username_field(String string) {
    	login.setUsername(string);
    }

    @When("User enters valid password {string} into password field")
    public void user_enters_valid_password_into_password_field(String string) {
    	login.setPassword(string);
    }

    @When("User clicks on login")
    public void user_clicks_on_login() {
    	login.clickOnLogin();
    }

    @Then("User should successfully login and {string} should be displays")
    public void user_should_successfully_login_and_should_be_displays(String string) {
    	String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))).getText();
        Assert.assertTrue(text.equals(string));
    }

	@Then("User selects a product {string}:")
	public void user_selects_a_product(String string) throws InterruptedException {
		home.clickonProduct(string);
	}

	@Then("The product details for {string} should be displayed:")
	public void the_product_details_for_should_be_displayed(String string) {
		WebElement td = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[@class=\"name\"]")
		));
	   String text = td.getText();
	   Assert.assertTrue(text.equals(string));
	}

	@When("User adds the product to the cart:")
	public void user_adds_the_product_to_the_cart() {
	   product.addToCart();

	}

	@Then("The cart should contain {string}:")
	public void the_cart_should_contain(String string) {
	   driver.findElement(By.id("cartur")).click();
	   WebElement td = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[normalize-space()='Samsung galaxy s6']")
		));
	   String text = td.getText();
	   Assert.assertTrue(text.equals(string));
	}

	@When("User click on place order button")
	public void user_click_on_place_order_button() {
	    cart.ClickOnPlaceOrder();
	}

	@When("Enter Name: {string} Country: {string} City: {string} Credit card: {string} Month: {string} Year: {string}")
	public void enter_name_country_city_credit_card_month_year(String string, String string2, String string3, String string4, String string5, String string6) {
		cart.fillPlaceOrederForm(string, string2, string3, string4, string5, string6);
	}
	@When("Click on purchase")
	public void click_on_purchase() {
		cart.clickOnPurchase();
	}

	@Then("Order should place successfully")
	public void order_should_place_successfully() throws InterruptedException {
	   String text = driver.findElement(By.xpath("//h2[text()=\"Thank you for your purchase!\"]")).getText();
	   Assert.assertTrue(text.equals("Thank you for your purchase!"));
	   WebElement pro = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class=\"confirm btn btn-lg btn-primary\"]")
		));
	   Thread.sleep(3000);
		pro.click();
	}

	@When("User clicks on the {string} button:")
	public void user_clicks_on_the_button(String string) {
		logout.clickOnLogout();
	}

	@Then("User should be logged out successfully:")
	public void user_should_be_logged_out_successfully() {
		WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(
				By.id("login2")
		));
		Assert.assertTrue(Login.getText().equals("Log in"));
		driver.quit(); 
	}
}
