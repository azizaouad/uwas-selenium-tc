Feature: edit event

  Scenario: photographer can change the name of any event 
    Given photographer should log-in
    When photographer should click on the button of add-event
    And photographer should fill the title of event 
    # And photographer should fill the location of event as "tunisia"
    # And photographer should fill the date of event as ""
    # And photographer put an image for the event
    And photographer click on the ok button
    And photographer click on the three buttouns for updating
    And photographer choose edit
    And photographer should change the title of event as "ggos"
    And photographer click on the button of ok 
    Then title of event is updated


    Scenario: photographer can change the location of any event 
    Given photographer should log-in
    When photographer should click on the button of add-event
    And photographer should fill the title of event 
    And photographer should fill the location of event
    # And photographer should fill the date of event as ""
    # And photographer put an image for the event
    And photographer click on the ok button
    And photographer click on the three buttouns for updating
    And photographer choose edit
    And photographer should change the location of event
    And photographer click on the button of ok 
    Then location of event is updated 

        Scenario: photographer can change the date of any event 
    Given photographer should log-in
    When photographer should click on the button of add-event
    And photographer should fill the title of event 
    And photographer should fill the location of event
    # And photographer should fill the date of event as ""
    # And photographer put an image for the event
    And photographer click on the ok button
    And photographer click on the three buttouns for updating
    And photographer choose edit
    And photographer should change the date of event
    And photographer click on the button of ok 
    Then date of event is updated 

    
        Scenario: photographer can change the date, the name and the location of any event 
    Given photographer should log-in
    When photographer should click on the button of add-event
    And photographer should fill the title of event 
    And photographer should fill the location of event
    # And photographer should fill the date of event as ""
    # And photographer put an image for the event
    And photographer click on the ok button
    And photographer click on the ok button
    And photographer click on the three buttouns for updating
    And photographer choose edit
    And photographer should change the title of event as "ggos"
    And photographer should change the date of event
    And photographer should change the location of event
    And photographer click on the button of ok 
    Then details of event is updated