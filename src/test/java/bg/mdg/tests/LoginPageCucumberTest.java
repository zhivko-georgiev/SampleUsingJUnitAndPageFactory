package bg.mdg.tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import bg.mdg.commons.TestBaseSetup;
import bg.mdg.pageobjects.HomePage;
import bg.mdg.pageobjects.LoginPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageCucumberTest {
	private final String chromeBrowser = "chrome";
	private final String firefoxBrowser = "firefox";
	private final String appUrl = "http://dir.bg";

	private WebDriver driver;
	private LoginPage login;
	private HomePage home;

	@Before
	public void setUp() {
		initializeTestBaseSetup(chromeBrowser, appUrl);
		driver = testbase.getDriver();
	}

	@Given("^the login page is opened$")
	public void openLoginPage() {
		home = new HomePage(driver);
		login = home.clickLoginButton();
	}

	@When("^I enter (.+) email in the email field$")
	public void enterEmail(String emailType) {
		if (emailType.contains("valid")) {
			login.enterUsername("g5140549@trbvm.com");
		}

		login.enterUsername("username");
	}

	@And("^I enter (.+) password in the password field$")
	public void enterPassword(String passwordType) {
		if (passwordType.contains("valid")) {
			login.enterPassword("2477261f");
		}
		
		login.enterPassword("123456");
	}

	@And("^I click on the Login button$")
	public void clickLoginButton() {
		login.clickLoginButton();
	}

	@Then("^my email should be displayed in the upper right corner$")
	public void emailDisplayedInTheUpperRightCorner() {
		assertTrue(login.successMessagePresent());
	}

	@And("^I should be able to logout$")
	public void logout() {
		login.logout();
	}
}
