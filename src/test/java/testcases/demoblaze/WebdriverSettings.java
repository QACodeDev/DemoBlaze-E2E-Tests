package testcases.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSettings {
	
	public WebDriver driverSettings() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\EHOINZM\\Desktop\\DevOps\\selenium-maven-automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

}
