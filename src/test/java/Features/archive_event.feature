Feature: test archive event functionality

  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Aziz1996@"
    When photographer click on the three buttouns
    And Choose archive
    Then the event is archived

  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Aziz1996@"
    When photographer should go to the archive event
    And photographer click on the three buttouns
    And Choose restore
    Then the event is restored

