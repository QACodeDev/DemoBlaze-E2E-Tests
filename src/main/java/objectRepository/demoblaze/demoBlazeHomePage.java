package objectRepository.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoBlazeHomePage {

	WebDriver driver;

	@FindBy(xpath = "//a[@id='login2']")
	WebElement LoginLink;

	@FindBy(xpath = "//a[@id='signin2']")
	WebElement SignUpLink;

	@FindBy(id = "loginusername")
	WebElement loginUserName;

	@FindBy(id = "loginpassword")
	WebElement loginPassword;

	@FindBy(id = "sign-username")
	WebElement signUserName;

	@FindBy(id = "sign-password")
	WebElement signPassword;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	WebElement logInButton;

	@FindBy(xpath="//button[contains(text(),'Sign up')]")
	WebElement SignUpButton;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement Logoutlink;

	// constructor method
	public demoBlazeHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement LoginLink() {
		return LoginLink;
	}

	public WebElement loginUserNameText() {
		return loginUserName;
	}

	public WebElement loginPasswordText() {
		return loginPassword;
	}

	public WebElement SignUserNameText() {
		return signUserName;
	}

	public WebElement SignPasswordText() {
		return signPassword;
	}
	
	public WebElement logInButton() {
		return logInButton;
	}
	
	public WebElement SignUpButton() {
		return SignUpButton;
	}
	
	public WebElement LogoutLink() {
		return Logoutlink;
	}

}
