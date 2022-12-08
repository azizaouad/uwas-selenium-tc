


  Feature: test the login functionality

    Scenario: user to login with valid email and valid password
      Given user should navigate to the website
      When user write email and password and click on login
      Then user should navigate to home page

