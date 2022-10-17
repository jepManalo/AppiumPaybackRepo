package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import tests.BaseClass;

public class LandingPage{
	
	private BaseClass _baseClass;
	
	@FindBy(how = How.ID, using = "de.payback.client.android:id/coupon_center_dest")
	private WebElement CouponBtn;
	
	public LandingPage(BaseClass baseClass) {
		_baseClass = baseClass;
		PageFactory.initElements(_baseClass.driver, this);
	}	
	
	public void ClickCouponBtn() {
		_baseClass.wait.until(ExpectedConditions.elementToBeClickable(CouponBtn));
		CouponBtn.click();
	}

}
