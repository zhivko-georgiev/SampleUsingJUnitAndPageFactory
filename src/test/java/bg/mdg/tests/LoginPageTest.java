package bg.mdg.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import bg.mdg.commons.TestBaseSetup;
import bg.mdg.pageobjects.HomePage;
import bg.mdg.pageobjects.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageTest extends TestBaseSetup {
	private final String chromeBrowser = "chrome";
	private final String firefoxBrowser = "firefox";
	private final String appUrl = "http://dir.bg";

	private WebDriver driver;
	private LoginPage login;
	private HomePage home;

	@Before
	public void setUp() {
		initializeTestBaseSetup(chromeBrowser, appUrl);
		driver = getDriver();
	}

	@Test
	public void _001_correctUserNameOrPassword() {
		home = new HomePage(driver);
		login = home.goToLogin();
		login.with("g5140549@trbvm.com", "2477261f");
		assertTrue("success message not present", login.successMessagePresent());
		login.logout();
	}

	@Test
	public void _002_wrongUserNameOrPassword() {
		home = new HomePage(driver);
		login = home.goToLogin();
		login.with("username", "password");
		assertTrue(
				"failure message wasn't present after providing bogus credentials",
				login.failureMessagePresent());
	}
}