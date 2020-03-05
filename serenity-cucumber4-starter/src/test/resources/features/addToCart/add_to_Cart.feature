Feature: Add to cart

  Background:
    Given an anonymus buyer opens gopro main page
    And he navigates to cameras
    And he adds 2 hero8 black bundle

  Scenario: Check the correct number of items is added in the cart
    When he navigates to cart
    Then he should see 2 items in the cart

  Scenario: Remove one camera from the cart
    When he navigates to cart
    Then he removes 1 camera from the cart
    Then he should see 1 items in the cart

  @remove
  Scenario: Remove all cameras from the cart
    When he navigates to cart
    Then he removes 2 camera from the cart
    Then he should see 0 items in the cart