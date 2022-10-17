package StepDefinitions;

import Pages.CouponPage;
import Pages.LandingPage;
import Pages.SearchPage;
import Pages.SearchResultsPage;
import io.cucumber.java.en.*;

public class BaseStep{
	
	private LandingPage _landingPage;
	private SearchPage _searchPage;
	private CouponPage _couponPage;
	private SearchResultsPage _searchResultsPage;
	
	public BaseStep (LandingPage landingPage,
			SearchPage searchPage,
			SearchResultsPage searchResultsPage,
			CouponPage couponPage) {
		_landingPage = landingPage;
		_searchPage = searchPage;
		_searchResultsPage = searchResultsPage;
		_couponPage = couponPage;
	}
	
	@Given("I open PayBack application in android")
	public void IOpenPayBackApplicationInAndroid() {
		
		//Nothing to do here since @Before Already opens the application
	}

	@When("I click coupon button")
	public void IClickCouponButton() {

		_landingPage.ClickCouponBtn();
	}
	
	@And("I filter and activate first {string} coupon")
	public void IFilterAndActivateFirstREWECoupon(String coupon) {

		_searchPage.ClickFilterBtn();
		_searchResultsPage.ClickCouponBtn(coupon);
		_couponPage.ClickFirstCoupon();
		_couponPage.ClickActivateBtn();
		
	}

	@Then("I have activated the coupon")
	public void IHaveActivatedTheCoupon() {

		_couponPage.IsActivated();
	}

}
