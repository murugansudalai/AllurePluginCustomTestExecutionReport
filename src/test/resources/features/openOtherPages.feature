Feature: Page1 Loading successful
  As a product owner,
  I wan to open the a page in a Browser and validate title

  Scenario: etsy Page is loaded successfully
    Given user open the browser
    When user navigate to url "https:\\www.etsy.com"
    Then user see the page successfully loaded with title "Etsy"

  Scenario: facebook Page is loaded successfully
    Given user open the browser
    When user navigate to url "https:\\www.facebook.com"
    Then user see the page successfully loaded with title "wave"