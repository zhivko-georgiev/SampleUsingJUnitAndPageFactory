package bg.mdg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {
	private final String expectedPageTitle = "Българският Интернет портал!";
	
	@CacheLookup
	@FindBy(css = "#lenta-login a")
	private WebElement loginButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyBasePageTitle() {
		return getPageTitle().contains(expectedPageTitle);
	}

	public LoginPage clickLoginButton() {
		waitForElementToBeDisplayed(loginButton);
		loginButton.click();

		return PageFactory.initElements(getDriver(), LoginPage.class);
	}
}
