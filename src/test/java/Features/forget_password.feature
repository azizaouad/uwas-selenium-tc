Feature: test forget password functionality

  Scenario: user forget password and receive an email to reset her password
    Given user open the website and click on forget password
    When user fill email as "a.aouadi@coral-io.fr"
    And user confirm the mail
    And user visit the mail and click on the link
    And user fill password as "Aziz1996@"
    And user fill confirm_password as "Aziz1996@ "
    Then the password is changed user can login with new password as "Aziz1996@" and email as "a.aouadi@coral-io.fr"