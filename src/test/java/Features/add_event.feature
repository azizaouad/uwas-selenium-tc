Feature: test add event functionality

  Scenario: photographer can login and add event
    Given photographer should login
    When photographer should click on the button of add event
    And photographer should fill the title of event as "noel"
    And photographer should fill the location of event as "paris"
    And photographer should fill the date of event as "2022-12-25"
    And photographer put an image for the event
    And photographer should click on the button ok
    Then the event is created

#  Scenario Outline: photographer can login and add event without filling all the input
#    Given photographer should login
#    When photographer should click on the button of add event
#    And photographer should fill the title of event as "<title>"
#    And photographer should fill the location of event as "<location>"
#    And photographer should fill the date of event as "<date>"
#    And photographer put an image for the event
#    And photographer should click on the button ok
#    Then the event is created
#
#    Examples:
#      | title              | location   | date       |
#      |                    | lac        | 28/12/2022 |
#      | party              | amesterdam |            |
#      | final of world cup |            | 18/12/2022 |



