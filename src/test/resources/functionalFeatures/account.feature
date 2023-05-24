Feature: test fields validation

  Scenario: user want to edit his first name
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user edit his first name "tester"
    And user click on edit button
    Then first name should be changed to "tester"