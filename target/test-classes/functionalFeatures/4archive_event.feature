Feature: test archive and restore event functionality
  @Sanity
  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "mkd@outlook.fr" and password as "Aziz1996@" and create an event title as "event demo"
    When photographer click on the three buttouns
    And Choose archive for the event name as "demo"
    Then the event as "demo" is archived
  @Sanity
  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "mkd@outlook.fr" and password as "Aziz1996@"
    When photographer should go to the archive event
    And photographer click on the three buttouns
    And Choose restore for the event "demo"
    Then the title of event as "demo" is restored

