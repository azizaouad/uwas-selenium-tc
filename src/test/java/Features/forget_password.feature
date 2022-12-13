Feature: test forget password functionality

  Scenario: user forget password and receive an email to reset her password
    Given user open the website and click on forget password
    When user write email as "a.aouadi@coral-io.fr"
    And user confirm the email
    And user visit the mail and click on the link
    And user write password as "Aziz1996@"
    And user write confirm_password as "Aziz1996@"
    Then the password is changed user can login with new password as "Aziz1996@" and email as "a.aouadi@coral-io.fr"

  Scenario: user try to reset password without having an account
    Given user open the website and click on forget password
    When user write email as "aaw1996.f@gmail.com"
    And user confirm the email
    Then error message is displayed