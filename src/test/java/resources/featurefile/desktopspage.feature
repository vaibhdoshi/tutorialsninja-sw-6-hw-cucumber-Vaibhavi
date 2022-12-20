
#Feature: Desktop Test
#  As a user I want to go on different page
#  @smoke
#  Scenario: Verify products are arranged in Alphabetical order
#    Given I am on homepage
#    When I select currency("£ Pound Sterling")
#    And I mouse hover on Desktop tab and click
#    And I click on Show All Desktops
#    And I select sortby option name ("Name (Z - A)")
#    Then I should see product sorted in Z to A order
#  @sanity
#  Scenario: verify Product added to Shoppingcart successfully
#    Given I am on homepage
#    When I select currency("£ Pound Sterling")
#    And I mouse hover on Desktop tab and click
#    And I click on Show All Desktops
#    And I select sortby option("Name (A - Z)")
#    And I select product
#    And I verify product text
#    And I select delivery date
#    And I clear quantity in quantity field
#    And I enter quantity ("1")
#    And I click add to cart button
#    And I verfiy Success: You have added product to your shopping cart message
#    And I click on shopping cart link into message
#    And I verify message "Shopping Cart"
#    And I verify product name "HP LP3065"
#    And I verify product is displyed
#    Then I verify total is displyed
