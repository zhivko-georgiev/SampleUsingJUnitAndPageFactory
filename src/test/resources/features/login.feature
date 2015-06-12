# Gherkin language structure

Feature: Login
  Scenario: Unsuccessful Login
    Given the login page is opened
    When I enter registered users's email in the email field
    Then an error text displays
