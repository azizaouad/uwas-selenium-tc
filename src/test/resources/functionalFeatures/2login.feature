


  Feature: test the login functionality
    @SmokeTest
    Scenario: user to login with valid email and valid password
      Given user should navigate to the website
      When user write email as "azizaouadi12@gmail.com" and password as "Aziz1996@" and click on login
      Then user should navigate to home page

    @SmokeTest
    Scenario Outline: login with invalid credentials
      Given user should navigate to the website
      When user write email as "<email>" and password as "<password>" and click on login
      Then error message should appear

      Examples:
        | email            | password  |
        | qa@gmail.com     | Admin123! |
        | aaaa@outlook.fr  | Aziz1996@ |
        | lllll@outlook.fr | Mo123!!   |
        |                  | Aziz1996@ |
        | ph@gmail.com     |           |
        |                  |           |



