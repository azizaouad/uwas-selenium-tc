Feature: test fields validation

  Scenario: user want to edit his first name
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user edit his first name "tester"
    And user click on edit button
    Then first name should be changed to "tester"

  Scenario Outline: user fill the first name fields without respecting the conditions of this field
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user edit his first name "<first_name>"
    And user click on edit button
    Then the first name does not change to "<first_name>"

    Examples:
    | first_name |
    | 3li        |
    | @li        |
    | @3la       |
    |            |
    | li         |

  Scenario: user want to edit his last name
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user edit his last name "tester"
    And user click on edit button
    Then last name should be changed to "tester"

  Scenario Outline: user fill the last name fields without respecting the conditions of this field
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user edit his last name "<last_name>"
    And user click on edit button
    Then the last name does not change to "<last_name>"

    Examples:
      | last_name  |
      | 3li        |
      | @li        |
      | @3la       |
      |            |
      | li         |
