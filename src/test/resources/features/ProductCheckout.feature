Feature: Product Sort and Checkout

  @Test_003 @Sanity
  Scenario: Product Checkout
    Given I launch the page
    When I enter username "standard_user" and password "secret_sauce"
    And I should be logged in successfully and inventory list displayed
    Then I add "Sauce Labs Backpack" and "Sauce Labs Bike Light" to the cart
    And I should see "Sauce Labs Backpack" and "Sauce Labs Bike Light" in the cart
    And I should checkout the items
    And I should enter "Test1" in "FirstName"
    And I should enter "Engineer" in "LastName"
    And I should enter "123456" in "PostalCode"
    And I should click "CheckOutContinueButton"
    And I should click "FinishButton"

  @Test_004 @Sanity
  Scenario: Product Sort
    Given I launch the page
    When I enter username "standard_user" and password "secret_sauce"
    And I should be logged in successfully and inventory list displayed
    And I sort products by "Price (low to high)"
    And The products should be sorted by price in low to high order



