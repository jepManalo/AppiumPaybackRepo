package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import tests.BaseClass;

public class SearchResultsPage {
	
	private BaseClass _baseClass;
	
	@FindBy(how = How.XPATH, using = "(//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout)[3]")
	private WebElement ReweBtn;
	
	public SearchResultsPage(BaseClass baseClass) {
		_baseClass = baseClass;
		PageFactory.initElements(_baseClass.driver, this);
	}	
	
	public void ClickCouponBtn(String coupon) {
		
		switch (coupon) {
			case "REWE":
				_baseClass.wait.until(ExpectedConditions.elementToBeClickable(ReweBtn));
				ReweBtn.click();
				break;
			
			case "":
				//Add additional coupons here
				break;
		}
	}

}
