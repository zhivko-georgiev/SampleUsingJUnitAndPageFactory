package bg.mdg.pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class BasePageObject {
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	protected String getPageTitle() {
		return this.driver.getTitle();
	}
}
