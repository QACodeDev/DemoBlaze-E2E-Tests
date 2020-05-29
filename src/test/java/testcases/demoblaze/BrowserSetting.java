package testcases.demoblaze;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import static variables.demoblaze.UrlVariables.*;

public class BrowserSetting {
	
	WebDriver driver;

	public WebDriver BrowserSettings(String browser){
			
		try{
			WebdriverSettings wds = new WebdriverSettings();
			driver = wds.driverSettings(browser);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(BASE_URL);
			
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return driver;
	}

}
