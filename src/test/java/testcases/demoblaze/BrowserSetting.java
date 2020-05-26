package testcases.demoblaze;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import static variables.demoblaze.UrlVariables.*;

public class BrowserSetting {
	
	public WebDriver BrowserSettings(){
		
		WebdriverSettings wds = new WebdriverSettings();
		WebDriver driver = wds.driverSettings();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		return driver;
	}

}
