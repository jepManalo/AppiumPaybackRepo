package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AndroidDriver driver = null;
	
	@BeforeTest
	public void Setup () throws MalformedURLException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
		capability.setCapability(MobileCapabilityType.UDID, "");
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capability.setCapability(MobileCapabilityType.APP, "");
		capability.setCapability("appPackage", "de.payback.client.android");
		capability.setCapability("appActivity", "de.payback.app.deeplinks.StarterActivity");

		driver = new AndroidDriver(new URL("https://127.0.0.1:4723/wd/hub"), capability);
	}
	
	
	@AfterTest
	public void TearDown() {
		
	}

}
