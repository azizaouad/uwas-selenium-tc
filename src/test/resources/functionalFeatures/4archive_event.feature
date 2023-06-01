Feature: test archive and restore event functionality
 
  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Admin123!" and create an event title as "ml"
    When photographer click on the three buttouns
    And Choose archive for the event name as "ml"
    Then the event as "ml" is archived

  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Admin123!"
    When photographer should go to the archive event
    And photographer click on the three buttouns
    And Choose restore for the event "ml"
    Then the title of event as "ml" is restored

