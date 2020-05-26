package objectRepository.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoBlazeCartPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//td[contains(text(),'Iphone 6 32gb')]")
	WebElement phone;
	
	@FindBy(xpath="//Button[contains(text(),'Place Order')]")
	WebElement placeOrder;
	
	@FindBy(id="name")
	WebElement name;

	@FindBy(id="country")
	WebElement country;

	@FindBy(id="city")
	WebElement city;

	@FindBy(id="card")
	WebElement Creditcard;

	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;

	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchaseOrder;	
	
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	WebElement OK;
	
	// constructor method
	public demoBlazeCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement iphone6Link() {
		return phone;
	}
	
	public WebElement placeOrderButton() {
		return placeOrder;
	}
	
	public WebElement nameTextBox() {
		return name;
	}
	
	public WebElement countryTextBox() {
		return country;
	}
	public WebElement cityTextBox() {
		return city;
	}
	public WebElement cardTextBox() {
		return Creditcard;
	}
	public WebElement monthTextBox() {
		return month;
	}
	public WebElement yearTextBox() {
		return year;
	}
	public WebElement purchaseOrderButton() {
		return purchaseOrder;
	}
	public WebElement OKButton() {
		return OK;
	}

}
