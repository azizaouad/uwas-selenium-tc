Feature: test add event functionality
 
  Scenario: photographer can login and add event
    Given photographer should login
    When photographer should click on the button of add event
    And photographer should fill the title of event as "gggogo"
    And photographer should fill the location of event as "tunisia"
    And photographer should fill the date of event as "2023-06-08"
    And photographer put an image for the event
    And photographer should click on the button ok
    Then title of event as "gggogo" event in location of event as "tunisia" at the date of event as "2023-06-08" is created
 
  Scenario Outline: photographer can login and can't add event without filling the title of event
    Given photographer should login
    When photographer should click on the button of add event
    And photographer should fill the title of event as "<title_of_event>"
    And photographer should fill the location of event as "<location_of_event>"
    And photographer should fill the date of event as "<date_of_event>"
    And photographer put an image for the event
    And photographer should click on the button ok
    Then an error message appear under the title field

    Examples:
      | title_of_event | location_of_event | date_of_event |
      |                | lac               | 2022-12-28    |
      |                | amesterdam        |               |
      |                |                   | 2022-12-18    |

 Scenario: photographer can login and add event without filling the location of event
   Given photographer should login
   When photographer should click on the button of add event
   And photographer should fill the title of event as "locasesssss"
   And photographer should fill the location of event as ""
   And photographer should fill the date of event as "2023-05-31"
   And photographer should click on the button ok
   Then title of event as "locasesssss" event in location of event as "Not defined" at the date of event as "2023-05-31" is created



 Scenario: photographer can login and add event without filling the date of event
   Given photographer should login
   When photographer should click on the button of add event
   And photographer should fill the title of event as "workeer"
   And photographer should fill the location of event as "bruxelle"
   And photographer put an image for the event
   And photographer should click on the button ok
   Then title of event as "workeer" event in location of event as "bruxelle" is created with the date added

 Scenario: photographer can login and can't add event with filling a file not image type in the image field
   Given photographer should login
   When photographer should click on the button of add event
   And photographer should fill the title of event as "ulee1994"
   And photographer should fill the location of event as "rades"
   And photographer should fill the date of event as "2022-06-19"
   And photographer put a file in the image field for the event
   And photographer should click on the button ok
   Then an error message appear and the event is created without image