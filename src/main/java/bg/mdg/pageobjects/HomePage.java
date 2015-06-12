package bg.mdg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {
	@CacheLookup
	@FindBy(css = "#lenta-login a")
	private WebElement loginButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public LoginPage goToLogin() {
		loginButton.click();

		return PageFactory.initElements(driver, LoginPage.class);
	}
}
