package testcases.demoblaze;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import objectRepository.demoblaze.demoBlazeHomePage;
import objectRepository.demoblaze.demoBlazeProductPage;
import static variables.demoblaze.UserVariables.*;

public class viewProducts{

	@Test
	@Parameters("browserType")
	public void DemoBlaze_TC01_ViewProducts(String browserType) {

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings(browserType);
	try{
		fn_Login(driver);
		fn_ViewProducts(driver);
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

	private void fn_ViewProducts(WebDriver driver) throws InterruptedException {

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
		Thread.sleep(8000);
		product_page.cartLink().click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	private void fn_logOut(WebDriver driver) {
		demoBlazeHomePage home_page = new demoBlazeHomePage(driver);	
		home_page.LogoutLink();
	}

}
