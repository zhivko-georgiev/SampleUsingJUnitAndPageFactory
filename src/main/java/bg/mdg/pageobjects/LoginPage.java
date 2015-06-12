package bg.mdg.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject {
	private final String logoutValue = "Изход";

	@FindBy(id = "login_name")
	private WebElement inputUserName;

	@FindBy(id = "login_pass")
	private WebElement inputPassword;

	@FindBy(id = "submit_but")
	private WebElement loginButton;

	@FindBy(className = "fpBlock2")
	private WebElement loginFormLocator;

	@FindBy(id = "usernick")
	private WebElement successMessageLocator;

	@FindBy(css = ".fpBlockBody2 b")
	private WebElement failureMessageLocator;

	@FindBy(id = "details")
	private WebElement logoutArea;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void with(String username, String password) {
		inputUserName.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();
	}

	public boolean successMessagePresent() {
		return successMessageLocator.isDisplayed();
	}

	public boolean failureMessagePresent() {
		return failureMessageLocator.isDisplayed();
	}

	public void logout() {
		successMessageLocator.click();
		selectValueFromUnorderedList(logoutArea, logoutValue);
	}

	private void selectValueFromUnorderedList(WebElement unorderedList,
			final String value) {
		List<WebElement> options = unorderedList.findElements(By.tagName("li"));

		for (WebElement option : options) {
			if (value.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}
}