package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver ;
	
	//constructor
	public ProductPage(WebDriver driver){
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	//locators
	@FindBy(xpath = "//a[text()=\"Add to cart\"]")
	WebElement addToCartBtnLoc;
	
	//actions
	public void addToCart() {
		addToCartBtnLoc.click();
	   
	}
}
