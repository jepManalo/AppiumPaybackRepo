package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.BasePage;
import io.cucumber.java.en.*;
import tests.BaseClass;

public class BaseStep{
	
	BaseClass _baseClass;
	BasePage _basePage;
	WebDriverWait wait;
	
	
	public BaseStep (BaseClass baseClass,
			BasePage basePage) {
		_baseClass = baseClass;
		_basePage = basePage;
		wait = new WebDriverWait(_baseClass.driver, Duration.ofSeconds(60));
	}
	
	@Given("I open PayBack application in android")
	public void IOpenPayBackApplicationInAndroid() {
		
		//Nothing to do here since @BeforeTest Already opens the application
	}

	@When("I click coupon button")
	public void IClickCouponButton() {

		WebElement couponBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("de.payback.client.android:id/coupon_center_dest")));
		couponBtn.click();
	}
	
	@And("I filter and activate first REWE coupon")
	public void IFilterAndActivateFirstREWECoupon() {

		WebElement filterBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("de.payback.client.android:id/filter_button")));
		filterBtn.click();
		
		WebElement reweBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout)[3]")));
		reweBtn.click();
		
		WebElement firstCouponBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index = '1'][@resource-id = 'de.payback.client.android:id/coupon']")));
		firstCouponBtn.click();
		
		WebElement activateBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index = '0']/descendant::android.widget.Button")));
		activateBtn.click();
		
	}

	@Then("I have activated the coupon")
	public void IHaveActivatedTheCoupon() {

		boolean isActivated = wait.until(ExpectedConditions.textToBe(By.xpath("//android.widget.FrameLayout[@index = '0']/descendant::android.widget.Button"), "Vor Ort einlösen"));
		
		Assert.assertEquals(isActivated, true);
	}

}
