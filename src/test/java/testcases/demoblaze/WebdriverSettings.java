package testcases.demoblaze;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;

public class WebdriverSettings {
	
	 String nodeurl;
	 WebDriver driver;

	public WebDriver driverSettings() throws MalformedURLException{
		nodeurl="http://localhost:4444/wd/hub";
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\EHOINZM\\Desktop\\DevOps\\DemoBlaze-E2E-Tests\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		driver = new RemoteWebDriver(new URL(nodeurl),cap);
		return driver;
	}

}
