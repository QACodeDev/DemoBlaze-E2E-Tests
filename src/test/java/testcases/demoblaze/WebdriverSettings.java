package testcases.demoblaze;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;

public class WebdriverSettings {
	
	 String nodeurl;
	 WebDriver driver;

	public WebDriver driverSettings(String strbrowser) throws MalformedURLException{
		nodeurl="http://52.191.17.161/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		if(strbrowser.equalsIgnoreCase("chrome"))
		{
			cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
			cap.setCapability("name", "DemoBlaze-Test-Chrome-05292020_02");
		}
		else if(strbrowser.equalsIgnoreCase("firefox"))
		{
			cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.FIREFOX);
			cap.setCapability("name", "DemoBlaze-Test-Firefox-05292020_02");
		}
		else
		{
			System.out.println("Error - Invalid browser !!!");
		}
		//For remote system execution by Zalenium
		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);		
		cap.setCapability("build", "DemoBlaze-Build-05292020_02");
		cap.setCapability("testFileNameTemplate", "{testName}_{browser}_{timestamp}");
		cap.setCapability("idleTimeout", 120);
		cap.setCapability("recordVideo", true);
		driver = new RemoteWebDriver(new URL(nodeurl),cap);
		return driver;
	}

}
