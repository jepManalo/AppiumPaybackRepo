package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import tests.BaseClass;

public class CouponPage {
	
private BaseClass _baseClass;
	
	@FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@index = '1'][@resource-id = 'de.payback.client.android:id/coupon']")
	private WebElement FirstCouponBtn;
	
	@FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@index = '0']/descendant::android.widget.Button")
	private WebElement ActivateBtn;
	
	public CouponPage(BaseClass baseClass) {
		_baseClass = baseClass;
		PageFactory.initElements(_baseClass.driver, this);
	}	
	
	public void ClickFirstCoupon() {
		
		_baseClass.wait.until(ExpectedConditions.elementToBeClickable(FirstCouponBtn));
		FirstCouponBtn.click();
	}
	
	public void ClickActivateBtn() {
		
		_baseClass.wait.until(ExpectedConditions.elementToBeClickable(ActivateBtn));
		ActivateBtn.click();
	}
	
	public void IsActivated() {
		
		boolean isActivated = _baseClass.wait.until(ExpectedConditions.textToBe(By.xpath("//android.widget.FrameLayout[@index = '0']/descendant::android.widget.Button"), "Vor Ort einlösen"));
		
		Assert.assertEquals(isActivated, true);
	}

}
