Feature: Laptop and notebooks Test
  As a user I want to go on Laptop and notebooks page

#  @smoke
#  Scenario: verify products price displyed hight to low successfully
#    Given I am on homepage
#    When I select currency ("£ Pound Sterling")
#    And I mouse hover on Laptops and notebooks tab and click
#    And I click on Show all Laptops and Notebooks
#    Then I select Product sortby option("Price (High > Low)") and I can see products are sorted high to low

  @sanity
  Scenario: verify that user place order successfully
    Given I am on homepage
    When I select currency("£ Pound Sterling")
    And I mouse hover on Laptops and notebooks tab and click
    And I click on Show all Laptops and Notebooks
    And Select sortby option("Price (High > Low)")
    And select product("MacBook")
    And I verify MacBook text is displyed
    And I click on add to cart button
    And Verify product added to cart message
    And I click on shopping cart link to message
    And I verify shopping cart text is displayed
    And I verify product name MacBook is displayed
    And I cleared quantity field
    And I changed quantity two in quantity field("2")
    And I click on quantity update button
    And I verify shopping cart update message is displayed
    Then I verify total is matched
