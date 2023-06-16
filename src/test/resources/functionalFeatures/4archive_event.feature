Feature: test archive and restore event functionality
 
  Scenario: photographer can archive any event
    Given photographer should login with his credentials email as "a@gmail.com" and password as "Admin123!!" and create an event
    When photographer click on the three buttouns
    And Choose archive the event
    Then the event is archived

  Scenario: photographer can restore event
    Given photographer should login with his credentials email as "a@gmail.com" and password as "Admin123!!"
    When photographer should go to the archive event
    And Choose restore the event
    Then the event is restored

