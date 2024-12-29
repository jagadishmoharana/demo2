package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	WebDriver driver ;
	WebDriverWait wait;
	//constructor
	public SignupPage(WebDriver driver){
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 PageFactory.initElements(driver, this);
	}
	
	
	//locators
	@FindBy(id = "signin2")
	WebElement signinBtnLoc;
	@FindBy(id = "sign-username")
	WebElement usernameFieldLoc;
	@FindBy(id = "sign-password")
	WebElement passwordFieldLoc;
	@FindBy(xpath = "//button[@onclick=\"register()\"]")
	WebElement registerBtnLoc;
	
	
	
	//actions
	
	public void visit_signup() {
	     wait.until(ExpectedConditions.elementToBeClickable(signinBtnLoc)).click();
	}
	public void setUsername(String str) {
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOf(usernameFieldLoc));
	     usernameField.sendKeys(str);
	}
	public void setPassword(String str) {
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOf(passwordFieldLoc));
        passwordField.sendKeys(str);
	}
	public void clickOnSignup() {
		wait.until(ExpectedConditions.elementToBeClickable(registerBtnLoc)).click();
	}
}
