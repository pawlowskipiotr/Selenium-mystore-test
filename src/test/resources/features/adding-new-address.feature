Feature: Changing information of logged user
  As a logged user
  I want to change address of delivery
  so that I can buy products with new address delivery

  Scenario Outline: Adding address in user account page
    Given the user is on the authentication page
    When the user gives correct login and password and clicks Sign In Button
    And the user clicks Addresses link and wants to create a new address
    And the user fills "<alias>", "<address>", "<city>", "<postalcode>", "<country>", "<phone>"
    And the user clicks save new address button
    Then the address should be added And the account should display success message

    Examples:
      | alias | address | city | postalcode | country | phone  |
      | ca    | ca      | ca   | 123123     | ca      | 123123 |
