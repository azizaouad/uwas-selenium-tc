Feature: test archive event functionality

  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Aziz1996@"
    When photographer click on the three buttouns of the event he wants to archive
    And Choose archive
    Then the event is archived