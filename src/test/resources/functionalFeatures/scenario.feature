Feature: use case


  Scenario: photographer should login, then he should create an event and logout
    Given user should navigate to the site
    When user write email as "k@gmail.com" and password as "Admin123!" and click on login button
    And photographer click on the button of add event
    And photographer fill the title of event as "-as-sds-sds-"
    And photographer fill the location of event as "homess-modess"
    And photographer fill the date of event as "2023-06-10"
    # And photographer put an image
    And photographer should click on the ok button
    And title of event as "-as-sds-sds-" in the location of event as "homess-modess" at the date of event as "2023-06-10" is created
    Then photographer should logout

  # Scenario: photographer should login, then he should upload some photos and logout
  #   Given user should navigate to the site
  #   When user write email as "b@gmail.com" and password as "Admin123!" and click on login button
  #   And user upload some photos
  #   And the photos are uploaded
  #   Then photographer should logout