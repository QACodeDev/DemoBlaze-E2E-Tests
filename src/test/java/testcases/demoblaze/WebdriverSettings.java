package testcases.demoblaze;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import static variables.demoblaze.UserVariables.*;

public class WebdriverSettings {
	
	 String nodeURL;
	 WebDriver driver;

	public WebDriver driverSettings(String strbrowser) throws MalformedURLException{
		nodeURL="http://"+GRID_HOST+"/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		if(strbrowser.equalsIgnoreCase("chrome"))
		{
			cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
			cap.setCapability("name", "DemoBlaze-Test-Chrome-05292020");
			System.out.println("Launching Chrome Browser..............");
		}
		else if(strbrowser.equalsIgnoreCase("firefox"))
		{
			cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.FIREFOX);
			cap.setCapability("name", "DemoBlaze-Test-Firefox-05292020");
			System.out.println("Launching firefox Browser..............");
		}
		else
		{
			System.out.println("Error - Invalid browser !!!");
		}
		//For remote system execution by Zalenium
		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);		
		cap.setCapability("build", "DemoBlaze-Build-05292020");
		cap.setCapability("testFileNameTemplate", "{testName}_{browser}_{timestamp}");
		cap.setCapability("idleTimeout", 120);
		cap.setCapability("recordVideo", true);
		cap.setCapability("tz", "Asia/Kolkata");
		driver = new RemoteWebDriver(new URL(nodeURL),cap);
		return driver;
	}

}
