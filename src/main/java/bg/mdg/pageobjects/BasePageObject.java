package bg.mdg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected String getPageTitle() {
		return this.driver.getTitle();
	}
}
