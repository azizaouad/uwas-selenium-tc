  Feature: test the login functionality
  @login
    Scenario: user to login with valid email and valid password
    
  
      When user write email as "azizaouadi12@gmail.com" and password as "Admin123!" and click on login
      Then user should navigate to home page

    @login
    Scenario Outline: login with invalid credentials


      When user write email as "<email>" and password as "<password>" and click on login
      Then error message should appear

      Examples:
        | email            | password  |
        | b@gmail.com      | Amine123! |
        | aaaa@outlook.fr  | Aziz1996@ |
        | lllll@outlook.fr | Mo123!!   |
        |                  | Aziz1996@ |
        | ph@gmail.com     |           |
        |                  |           |

