package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.*;

public class BaseClass {
	
	public AndroidDriver driver;
	public URL url;
	public WebDriverWait wait;
	
	public BaseClass() throws MalformedURLException {
		
		url = new URL("http://localhost:4723/wd/hub"); //using 0.0.0.0
	}
	
	@Before (order = 0)
	public void Setup () {
		
		try {			
			DesiredCapabilities capability = new DesiredCapabilities();
			
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
			capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
			capability.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			capability.setCapability("appPackage", "de.payback.client.android");
			capability.setCapability("appActivity", "de.payback.app.deeplinks.StarterActivity");
			capability.setCapability(MobileCapabilityType.NO_RESET, true);
						
			driver = new AndroidDriver(url, capability);
			
			System.out.println("Done");
		}
		catch(Exception e){
			System.out.println("Cause is " + e.getCause());
			System.out.println("Message is " + e.getMessage());
			e.printStackTrace();
		}
	}	
	
	@Before(order = 1)
	public void SetExplicitWait() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	@After
	public void TearDown() {
		
		//no action to be taken during teardown
	}

}
