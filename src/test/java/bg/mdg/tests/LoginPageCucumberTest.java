package bg.mdg.tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bg.mdg.commons.TestBaseSetup;
import bg.mdg.pageobjects.HomePage;
import bg.mdg.pageobjects.LoginPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageCucumberTest extends TestBaseSetup {
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
		home = PageFactory.initElements(driver, HomePage.class);
	}

	@Given("^the login page is opened$")
	public void openLoginPage() {
		login = home.goToLogin();
	}

	@When("^I enter (.+) email in the email field$")
	public void enterLoginEmailAndPassword() {
		login.with("username", "password");
	}

	@Then("^an error text displays$")
	public void checkWrongLoginMessages()  {
		assertTrue(
				"failure message wasn't present after providing bogus credentials",
				login.failureMessagePresent());
	}
}
