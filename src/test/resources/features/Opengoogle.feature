Feature: Page Loading successful
  As a product owner,
  I wan to open the a page in a Browser and validate title

  Scenario: Google Page is loaded successfully
    Given user open the browser
    When user navigate to url "https:\\www.google.com"
    Then user see the page successfully loaded with title "Google"

  Scenario: Amazon Page is loaded successfully
    Given user open the browser
    When user navigate to url "https:\\www.amazon.com"
    Then user see the page successfully loaded with title "Amazon"