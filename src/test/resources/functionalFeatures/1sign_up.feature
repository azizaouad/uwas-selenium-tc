
Feature: test the sign up functionality

  Scenario: fill in all the mandatory fields respecting the conditions of each field
    Given user open the website and click on sign up now
    When user fill first_name as "aziz"
    And user fill last_name as "aouadi"
    And user fill email as "azizaouadi123@gmail.com"
    And user fill password as "Aziz1996@"
    And user fill confirm_password as "Aziz1996@"
    And user click on the captcha
    And user click on sign up
    Then user have an account he can login with this credentials email as "azizaouadi123@gmail.com" and password as "Aziz1996@"

  Scenario Outline: fill in all the mandatory fields without respecting the conditions of each field
    Given user open the website and click on sign up now
    When user fill first_name as "<first_name>"
    And user fill last_name as "<last_name>"
    And user fill email as "<email>"
    And user fill password as "<password>"
    And user fill confirm_password as "<confirm_password>"
    And user click on the captcha
    And user click on sign up
    Then user fail to create an account

    Examples:
      | first_name | last_name | email        | password  | confirm_password |
      | 3li        | ali       | l@gmail.com  | Admin123! | Admin123!        |
      | li@        | ali       | l@gmail.com  | Admin123! | Admin123!        |
      | 3@l        | ali       | l@gmail.com  | Admin123! | Admin123!        |
      |            | ali       | l@gmail.com  | Admin123! | Admin123!        |
      | ali        | 3li       | l@gmail.com  | Admin123! | Admin123!        |
      | ali        | li@       | l@gmail.com  | Admin123! | Admin123!        |
      | ali        | 3@l       | l@gmail.com  | Admin123! | Admin123!        |
      | ali        |           | l@gmail.com  | Admin123! | Admin123!        |
      | ali        | ali       | lqsklqk@lqm  | Admin123! | Admin123!        |
      | ali        | ali       | qa@gmail.com | Admin123! | Admin123!        |
      | ali        | ali       | l@gmail.com  | admin123! | admin123!        |
      | ali        | ali       | l@gmail.com  | Admin1234 | Admin1234        |
      | ali        | ali       | l@gmail.com  | Admin!!!! | Admin!!!!        |
      | ali        | ali       | l@gmail.com  | ADMIN123! | ADMIN123!        |
      | ali        | ali       | l@gmail.com  | Admin2!   | Admin2!          |
      | ali        | ali       | l@gmail.com  |           | Admin123!        |
      | ali        | ali       | l@gmail.com  | Admin123! | Admin12345!      |
      | ali        | ali       |              | Admin123! | Admin123!        |
      | ali        | ali       | l@gmail.com  | Admin123! |                  |
