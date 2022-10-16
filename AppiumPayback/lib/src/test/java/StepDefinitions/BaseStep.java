package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Pages.BasePage;
import io.cucumber.java.en.*;
import tests.BaseClass;

public class BaseStep{
	
	BaseClass _baseClass;
	BasePage _basePage;
	
	public BaseStep (BaseClass baseClass,
			BasePage basePage) {
		_baseClass = baseClass;
		_basePage = basePage;
	}
	
	@Given("I open PayBack application in android")
	public void IOpenPayBackApplicationInAndroid() {
		
		//Nothing to do here since @BeforeTest Already opens the application
	}

	@When("I click coupon button")
	public void IClickCouponButton() {

		WebElement couponBtn = _baseClass.driver.findElement(By.id("de.payback.client.android:id/coupon_center_dest"));
		couponBtn.click();
	}
	
	@And("I filter for REWE coupon")
	public void IFilterForREWECoupon() {

		WebElement filterBtn = _baseClass.driver.findElement(By.id("de.payback.client.android:id/filter_button"));
		filterBtn.click();
		
		WebElement reweBtn = _baseClass.driver.findElement(By.xpath("(//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout)[3]"));
		reweBtn.click();
		
		WebElement firstCouponActivateBtn = _baseClass.driver.findElement(By.xpath("//android.widget.FrameLayout[@index = '1']/descendant::android.widget.Button"));
		firstCouponActivateBtn.click();
	}

	@Then("I have activated the coupon")
	public void IHaveActivatedTheCoupon() {

		WebElement firstCouponActivateBtn = _baseClass.driver.findElement(By.xpath("//android.widget.FrameLayout[@index = '1']/descendant::android.widget.Button"));
		String text = firstCouponActivateBtn.getText();
		
		Assert.assertEquals(text, "Vor Ort einlösen");

	}

}
