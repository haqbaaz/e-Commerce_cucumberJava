Feature: Ordering Items
  Scenario: Add to cart and Order the items
    When User opens url "https://www.saucedemo.com/v1/index.html"
    And User enters Email as "standard_user" and password as "secret_sauce"
    And Click on login
    And Add items to cart
    Then Checkout the items in cart
    And Fill customer details
    Then Finish the order
    Then Verify the msg "THANK YOU FOR YOUR ORDER"
    When user click logout link
