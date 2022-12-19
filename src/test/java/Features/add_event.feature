Feature: test add event functionality

  Scenario: photographer can login and add event
    Given photographer should login
    When photographer should click on the button of add event
    And photographer should fill the title of event as "noel"
    And photographer should fill the location of event as "paris"
    And photographer should fill the date of event as "2022-12-25"
    And photographer put an image for the event
    And photographer should click on the button ok
    Then title of event as "noel" event in location as "paris" at date as "2022-12-25" is created

  Scenario Outline: photographer can login and add event without filling the title of event
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



