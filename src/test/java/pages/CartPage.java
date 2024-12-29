package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver ;
	WebDriverWait wait;
	
	//constructor
	public CartPage(WebDriver driver){
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 PageFactory.initElements(driver, this);
	}
	
	//locator
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement PlaceOrderBtn;
	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement nameField;
	@FindBy(id = "country")
	WebElement countryField;
	@FindBy(id = "city")
	WebElement cityField;
	@FindBy(id = "card")
	WebElement cardField;
	@FindBy(id = "month")
	WebElement monthField;
	@FindBy(id = "year")
	WebElement yearField;
	@FindBy(xpath = "//button[normalize-space()='Purchase']")
	WebElement PurchaseBtn;
	
	
	//actions
	public void ClickOnPlaceOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(PlaceOrderBtn));
		PlaceOrderBtn.click();
	   
	}
	public void fillPlaceOrederForm(String string, String string2, String string3, String string4, String string5, String string6) {
		 wait.until(ExpectedConditions.visibilityOf(nameField));
	   nameField.sendKeys(string);
	   countryField.sendKeys(string2);
	   cityField.sendKeys(string3);
	   cardField.sendKeys(string4);
	   monthField.sendKeys(string5);
	   yearField.sendKeys(string6);
	}
	
	public void clickOnPurchase() {
		WebElement purchase =  wait.until(ExpectedConditions.elementToBeClickable(PurchaseBtn));
		purchase.click();
	}
}
