package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import tests.BaseClass;

public class SearchPage {
	
	private BaseClass _baseClass;
	
	@FindBy(how = How.ID, using = "de.payback.client.android:id/filter_button")
	private WebElement FilterBtn;
	
	public SearchPage(BaseClass baseClass) {
		_baseClass = baseClass;
		PageFactory.initElements(_baseClass.driver, this);
	}	
	
	public void ClickFilterBtn() {
		_baseClass.wait.until(ExpectedConditions.elementToBeClickable(FilterBtn));
		FilterBtn.click();
	}

}
