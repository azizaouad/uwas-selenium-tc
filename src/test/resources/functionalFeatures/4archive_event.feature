Feature: test archive and restore event functionality
 
  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "k@gmail.com" and password as "Admin123!" and create an event title as "mon"
    When photographer click on the three buttouns
    And Choose archive for the event name as "mon"
    Then the event as "mon" is archived

  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "k@gmail.com" and password as "Admin123!"
    When photographer should go to the archive event
    And Choose restore for the event "mon"
    Then the title of event as "mon" is restored

