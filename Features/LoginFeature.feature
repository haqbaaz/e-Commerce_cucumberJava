Feature: Login feature
  Scenario: Login with valid credentials
    When User opens url "https://www.saucedemo.com/v1/index.html"
    And User enters Email as "standard_user" and password as "secret_sauce"
    And Click on login
    Then The page title should be "Swag Labs"
    When user click logout link
    Then The page title should be "Swag Labs"

