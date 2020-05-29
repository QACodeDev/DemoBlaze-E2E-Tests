package testcases.demoblaze;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


import org.testng.annotations.*;

import objectRepository.demoblaze.demoBlazeHomePage;
import objectRepository.demoblaze.demoBlazeCartPage;
import objectRepository.demoblaze.demoBlazeProductPage;
import static variables.demoblaze.UserVariables.*;

public class purchaseProduct {

	Cookie cookie;

	@Test
	@Parameters("browserType")
	public void DemoBlaze_TC02_purchaseProduct(String browserType) {

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings(browserType);
	try{
		fn_Login(driver);
		fn_ViewProducts(driver);
		fn_placeProductOrder(driver);
		fn_logOut(driver);
	}catch(Exception e)
	{
		System.out.println("Error!! --> "+e.toString());
	}

		driver.close();

	}

	private void fn_Login(WebDriver driver) throws InterruptedException {
		// Login
		// homepage's object access
		System.out.println("Login.............");
		demoBlazeHomePage home_page = new demoBlazeHomePage(driver);		
		home_page.LoginLink().click();
		Thread.sleep(5000);
		home_page.loginUserNameText().sendKeys(LOGIN_USER_NAME);
		Thread.sleep(1000);
		home_page.loginPasswordText().sendKeys(LOGIN_PASSWORD);
		Thread.sleep(1000);
		cookie = new Cookie("zaleniumMessage", "Click Log In Button");
		driver.manage().addCookie(cookie);
		home_page.logInButton().click();
		Thread.sleep(5000);
	}

	private void fn_ViewProducts(WebDriver driver) throws InterruptedException {
		
		System.out.println("View Products.............");
		demoBlazeProductPage product_page = new demoBlazeProductPage(driver);
		cookie = new Cookie("zaleniumMessage", "View Laptops");
		driver.manage().addCookie(cookie);
		product_page.categoryLaptopsLink().click();
		Thread.sleep(3000);
		cookie = new Cookie("zaleniumMessage", "View Monitors");
		driver.manage().addCookie(cookie);
		product_page.categoryMonitorsLink().click();
		Thread.sleep(4000);
		cookie = new Cookie("zaleniumMessage", "View Phones");
		driver.manage().addCookie(cookie);
		product_page.categoryPhonesLink().click();
		Thread.sleep(4000);
		product_page.iphone6Link().click();
		Thread.sleep(4000);
		cookie = new Cookie("zaleniumMessage", "Click Add to Cart");
		driver.manage().addCookie(cookie);
		product_page.addToCartButton();
		Thread.sleep(8000);
		product_page.cartLink().click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	private void fn_placeProductOrder(WebDriver driver) throws InterruptedException  {

		System.out.println("Purchase Order.............");
		demoBlazeCartPage cart_page = new demoBlazeCartPage(driver);
		cart_page.placeOrderButton().click();
		Thread.sleep(2000);
		cart_page.nameTextBox().sendKeys(NAME);
		cart_page.countryTextBox().sendKeys(COUNTRY);
		cart_page.cityTextBox().sendKeys(CITY);
		cart_page.cardTextBox().sendKeys(CREDIT_CARD);
		cart_page.monthTextBox().sendKeys(CARD_MONTH);
		cart_page.yearTextBox().sendKeys(CARD_YEAR);
		cookie = new Cookie("zaleniumMessage", "Click Purchase Order");
		driver.manage().addCookie(cookie);
		cart_page.purchaseOrderButton().click();
		Thread.sleep(3000);
		cart_page.OKButton().click();
		Thread.sleep(3000);
	}

	private void fn_logOut(WebDriver driver) {
		System.out.println("Logout.............");
		cookie = new Cookie("zaleniumMessage", "Logout");
		driver.manage().addCookie(cookie);
		demoBlazeHomePage home_page = new demoBlazeHomePage(driver);	
		home_page.LogoutLink();
	}

}
