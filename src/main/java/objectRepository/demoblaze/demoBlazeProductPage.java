package objectRepository.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoBlazeProductPage {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Phones')]")
	WebElement category_phones;

	@FindBy(xpath = "//a[contains(text(),'Laptops')]")
	WebElement category_Laptops;

	@FindBy(xpath = "//a[contains(text(),'Monitors')]")
	WebElement category_Monitors;
	
	@FindBy(xpath = "//a[@id='cartur']")
	WebElement cart;	

	@FindBy(xpath = "//a[contains(text(),'Iphone 6 32gb')]")
	WebElement iphone6link;	
	
	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	WebElement addToCart;	
	
	// constructor method
	public demoBlazeProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement categoryPhonesLink() {
		return category_phones;
	}

	public WebElement categoryLaptopsLink() {
		return category_Laptops;
	}

	public WebElement categoryMonitorsLink() {
		return category_Monitors;
	}


	public WebElement cartLink() {
		return cart;
	}

	public WebElement iphone6Link() {
		return iphone6link;
	}

	public WebElement addToCartButton() {
		return addToCart;
	}
}
