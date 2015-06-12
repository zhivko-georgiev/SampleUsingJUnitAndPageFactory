package bg.mdg.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject {
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	protected String getPageTitle() {
		return this.driver.getTitle();
	}
	
	protected Boolean waitForIsDisplayed(By locator, Integer... timeout) {
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
					(timeout.length > 0 ? timeout[0] : null));
		} catch (TimeoutException exception) {
			return false;
		}
		return true;
	}

	private void waitFor(ExpectedCondition<WebElement> condition,
			Integer timeout) {
		timeout = timeout != null ? timeout : 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(condition);
	}
	
	protected void wait(int seconds) {
		this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
