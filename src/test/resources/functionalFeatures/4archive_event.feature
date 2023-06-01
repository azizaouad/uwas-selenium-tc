Feature: test archive and restore event functionality
  @Sanity
  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Admin123!" and create an event title as "evve"
    When photographer click on the three buttouns
    And Choose archive for the event name as "Evve"
    Then the event as "Evve" is archived
  @Sanity
  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Admin123!"
    When photographer should go to the archive event
    And photographer click on the three buttouns
    And Choose restore for the event "Evve"
    Then the title of event as "Evve" is restored

