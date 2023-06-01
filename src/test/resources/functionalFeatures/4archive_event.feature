Feature: test archive and restore event functionality
  @Sanity
  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Admin123!" and create an event title as "eye"
    When photographer click on the three buttouns
    And Choose archive for the event name as "Eye"
    Then the event as "Eye" is archived
  @Sanity
  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "azizaouadi12@gmail.com" and password as "Admin123!"
    When photographer should go to the archive event
    And photographer click on the three buttouns
    And Choose restore for the event "Eye"
    Then the title of event as "Eye" is restored

