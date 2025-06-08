Feature: Login to Application
  
  @Test_001 @Sanity
  Scenario: Valid login
    Given I launch the page
    When I enter username "standard_user" and password "secret_sauce"
    Then I should be logged in successfully and inventory list displayed

  @Test_002 @Sanity
  Scenario Outline: Invalid login
    Given I launch the page
    When I enter username "<UserName>" and password "<Password>"
    Then I should get error message as "<Error Message>"
    Examples:
      |UserName      |Password     |Error Message                      |
      |              |             |Epic sadface: Username is required |
      |standard_user |             |Epic sadface: Password is required |
      |              |secret_sauce |Epic sadface: Username is required |
      |asdfvg        |jdskjgfalsd  |Epic sadface: Username and password do not match any user in this service|
      |standard_user |sdfasd4564   |Epic sadface: Username and password do not match any user in this service|
      |*^&*67hkj     |secret_sauce |Epic sadface: Username and password do not match any user in this service|
