Feature: Buying a product and finalizing transaction
  As a logged user
  i want to buy a product
  choose size, method of payment and delivery options
  and finalise the transaction

  Scenario: Buying a product
    Given the user is on Home Page while he is logged
    And the user chooses a product, size and quantity
    And the user places it in the cart
    And the user chooses delivery address and payment method
    When the user places the order
    Then the confirmation of transaction is visible
    #And screenshot of confirmation and price is taken