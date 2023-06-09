Feature: test fields validation

  Scenario: user want to edit his first name
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user edit his first name "testeur"
    And user click on edit button
    Then first name should be changed to "testeur"

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
    And user edit his last name "testeur"
    And user click on edit button
    Then last name should be changed to "testeur"

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

  Scenario Outline: user want to edit his password
    Given  user should navigate to the website of uwas
    When user fill email as "a@gmail.com" and password as "<actuel_password>" and click on the button of login
    And user should click on account
    And user click on change password
    And user fill his actuel password "<actuel_password>"
    And user fill his new password "<new_password>"
    And user confirm password "<confirm_password>" 
    And user click on confirm button
    And user logout
    Then user can connect with new credentials email "a@gmail.com" and password "<new_password>"

  Examples:
  | actuel_password | new_password  | confirm_password |
  | Admin123!!      | Admin123!     | Admin123!        |
  | Admin123!       | Admin123!!    | Admin123!!       |


Scenario: user want to edit his password with filling miss actuel password
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user click on change password
    And user fill his actuel password "Admin1234!"
    And user fill his new password "Aziz1919!"
    And user confirm password "Aziz1919!" 
    And user click on confirm button
    Then an error message appear 

Scenario Outline: user want to edit his password without accept validation critere 
    Given  user should navigate to the website of uwas
    When user fill email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on the button of login
    And user should click on account
    And user click on change password
    And user fill his actuel password "Admin123!"
    And user fill his new password "<new_password>"
    And user confirm password "<confirm_password>" 
    And user click on confirm button
    Then an error message appear     

    Examples:  
    | new_password| confirm_password  |
    | admin6542!  | admin6542!        |
    | Edmin65412  | Edmi65412         |
    | ADMIN6542!  | ADMIN6542!        |
    | ADMINadmi!  | ADMINadmi!        |
    | Admin1!     | Admin1!           |
    | Admin1!     | Admin123!         |
    | Admin123!   | Admin123456!      |
    |             | Admin123!         |
    | Admin123!   |                   |
    |             |                   |