package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	 WebDriver driver;
	 WebDriverWait wait;

	
	 // Constructor
	 public LoginPage(WebDriver driver) {
		 this.driver = driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 PageFactory.initElements(driver, this); // Initialize WebElements
	 }

	 
	 // Locators using @FindBy annotations
	 @FindBy(id = "login2")
	 WebElement loginButton;
	 @FindBy(id = "loginusername")
	 WebElement usernameField;
	 @FindBy(id = "loginpassword")
	 WebElement passwordField;
	 @FindBy(xpath = "//button[@onclick=\"logIn()\"]")
	 WebElement submitButton;

	 // Methods for actions
	 public void visitLogin() {
		 wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	 }

	 public void setUsername(String username) {
		 wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
	 }

	 public void setPassword(String password) {
		 wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
	 }

	 public void clickOnLogin() {
		 wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	 }
	 
}
