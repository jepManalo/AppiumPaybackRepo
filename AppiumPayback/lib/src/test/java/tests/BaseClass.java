package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AndroidDriver driver = null;
	
	@BeforeTest
	public void Setup () throws MalformedURLException {
		
		try {			
			DesiredCapabilities capability = new DesiredCapabilities();
			
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
			capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
			capability.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			capability.setCapability("appPackage", "de.payback.client.android");
			capability.setCapability("appActivity", "de.payback.app.deeplinks.StarterActivity");
			
			URL url = new URL("http://localhost:4723/wd/hub"); //using 0.0.0.0
			
			driver = new AndroidDriver(url, capability);
		}
		catch(Exception e){
			System.out.println("Cause is " + e.getCause());
			System.out.println("Message is " + e.getMessage());
			e.printStackTrace();
		}
	}	
	
	@AfterTest
	public void TearDown() {
		
	}

}
