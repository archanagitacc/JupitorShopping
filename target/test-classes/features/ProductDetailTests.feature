@RegressionAll
Feature: Product buy and Billing details
  As Customer, I can buy items and validate total amount in the cart.

  Background: Home page of Jupitor toys Shopping website
    Given User launches Jupitor toys shopping website

  Scenario: buy Jupitor toys and validate cart details
    And User navigates from Home page to Shop Page
    When User purchases different items from shopping bucket
      | items          | quantity | price |
      | Stuffed Frog   |        2 | 10.99 |
      | Fluffy Bunny   |        5 |  9.99 |
      | Valentine Bear |        3 | 14.99 |
    And User navigates to Cart page
    Then Validate product and bill amount details
