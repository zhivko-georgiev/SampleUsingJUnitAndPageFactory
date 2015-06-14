Feature: login to the site.
 	
 	Scenario: login successfully
		Given the login page is opened
		When I enter valid email in the email field
		And I enter valid password in the password field
		And I click on the Login button
		Then my email should be displayed in the upper right corner
		And I should be able to logout