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
		nodeurl="http://52.191.17.161/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		cap.setCapability("name", "DemoBlaze-E2E-Test");
		cap.setCapability("build", "DemoBlaze-Build");
		cap.setCapability("testFileNameTemplate", "{testName}_{browser}_{timestamp}");
		cap.setCapability("idleTimeout", 120);
		cap.setCapability("recordVideo", true);
		driver = new RemoteWebDriver(new URL(nodeurl),cap);
		return driver;
	}

}
