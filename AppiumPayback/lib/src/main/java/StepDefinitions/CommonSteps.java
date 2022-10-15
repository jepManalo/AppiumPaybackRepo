package StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import 	org.testng.annotations.*;

public class CommonSteps {

	AndroidDriver driver = null;

	@Given("I open PayBack application in android")
	public void IOpenPayBackApplicationInAndroid() throws MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "de.payback.client.android");
		capability.setCapability("appActivity", "de.payback.app.deeplinks.StarterActivity");

		driver = new AndroidDriver(new URL("https://127.0.0.1:4723/wd/hub"), capability);

	}

	@When("I complete action")
	public void ICompleteAction() {

	}

	@Then("I validate the outcomes")
	public void IValidateTheOutcomes() {

//		Assert.assertEquals();

	}

	@And("I close the driver")
	public void ICloseTheDriver() {

	}

}
