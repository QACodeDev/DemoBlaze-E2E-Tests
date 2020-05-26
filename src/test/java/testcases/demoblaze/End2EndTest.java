package testcases.demoblaze;

import org.openqa.selenium.WebDriver;


import org.testng.annotations.Test;

import objectRepository.demoblaze.demoBlazeHomePage;
import objectRepository.demoblaze.demoBlazeCartPage;
import objectRepository.demoblaze.demoBlazeProductPage;
import static variables.demoblaze.UserVariables.*;

public class End2EndTest{

	@Test
	public void purchaseProduct() {

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings();
	try{
		Login(driver);
		ViewProducts(driver);
		placeProductOrder(driver);
		logOut(driver);
	}catch(Exception e)
	{
		System.out.println("Error!! --> "+e.toString());
	}

		driver.close();

	}

	private void Login(WebDriver driver) throws InterruptedException {
		// Login
		// homepage's object access
		//driver.get("https://www.demoblaze.com/");
		demoBlazeHomePage home_page = new demoBlazeHomePage(driver);		
		home_page.LoginLink().click();
		Thread.sleep(5000);
		home_page.loginUserNameText().sendKeys(LOGIN_USER_NAME);
		Thread.sleep(1000);
		home_page.loginPasswordText().sendKeys(LOGIN_PASSWORD);
		Thread.sleep(1000);
		home_page.logInButton().click();
		Thread.sleep(5000);
	}

	private void ViewProducts(WebDriver driver) throws InterruptedException {

		demoBlazeProductPage product_page = new demoBlazeProductPage(driver);
		product_page.categoryLaptopsLink().click();
		Thread.sleep(3000);
		product_page.categoryMonitorsLink().click();
		Thread.sleep(4000);
		product_page.categoryPhonesLink().click();
		Thread.sleep(4000);
		product_page.iphone6Link().click();
		Thread.sleep(4000);
		product_page.addToCartButton();
		Thread.sleep(11000);
		product_page.cartLink().click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	private void placeProductOrder(WebDriver driver) throws InterruptedException  {

		demoBlazeCartPage cart_page = new demoBlazeCartPage(driver);
		cart_page.placeOrderButton().click();
		Thread.sleep(2000);
		cart_page.nameTextBox().sendKeys(NAME);
		cart_page.countryTextBox().sendKeys(COUNTRY);
		cart_page.cityTextBox().sendKeys(CITY);
		cart_page.cardTextBox().sendKeys(CREDIT_CARD);
		cart_page.monthTextBox().sendKeys(CARD_MONTH);
		cart_page.yearTextBox().sendKeys(CARD_YEAR);
		cart_page.purchaseOrderButton().click();
		Thread.sleep(3000);
		cart_page.OKButton().click();
		Thread.sleep(3000);
	}

	private void logOut(WebDriver driver) {
		demoBlazeHomePage home_page = new demoBlazeHomePage(driver);	
		home_page.LogoutLink();
	}

}
