Feature: use case
  Scenario: photographer should login, then he should create an event and logout
    Given user should navigate to the website
    When user write email as "qa@gmail.com" and password as "Aziz1996@" and click on login
    And photographer click on the button of add event
    And photographer should fill the title of event as "test"
    And photographer should fill the location of event as "rades"
    And photographer should fill the date of event as "2022-12-31"
    And photographer put an image for the event
    And photographer should click on the button ok
    And title of event as "test" event in location of event as "paris" at the date of event as "2022-12-31" is created
    Then photographer should logout