package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	WebDriver driver ;
	WebDriverWait wait;
	
	//constructor
	public LogoutPage(WebDriver driver){
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 PageFactory.initElements(driver, this);
	}
	
	
	//locator
	@FindBy(xpath = "//a[@id=\"logout2\"]")
	WebElement logoutBtnLoc;
	
	
	
	//actions
	public void clickOnLogout() {
		WebElement pro = wait.until(ExpectedConditions.elementToBeClickable(logoutBtnLoc));
		pro.click();
	}
}
