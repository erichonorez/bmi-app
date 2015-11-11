Feature: Authenticate a retailer

  In order user retail solution
  As a retailer
  I want to consult retail name

  Scenario: the personal details of a registered patient are given
    Given a retailer with login "" and password ""
    When I click on login
    Then I am on the home page
