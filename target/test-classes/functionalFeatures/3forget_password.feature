Feature: test forget password functionality
  @SmokeTest
  Scenario: user forget his password and receive an email to reset it
    Given user open the website and click on forget password
    When user write email as "uwas@qa.team"
    And user confirm the email
    And user visit the mail and click on the link
    And user write password as "Aziz1996@!!"
    And user write confirm_password as "Aziz1996@!!"
    Then the password is changed user can login with new password as "Aziz1996@!!" and email as "uwas@qa.team"
#  @SmokeTest
#  Scenario: user try to reset his password without having an account
#    Given user open the website and click on forget password
#    When user write email as "aaw1996.f@gmail.com"
#    And user confirm the email
#    Then an error message is displayed
#  @SmokeTest
#  Scenario Outline: user forget his password and receive an email to reset it but doesn't accept the password conditions
#    Given user open the website and click on forget password
#    When user write email as "uwas@qa.team"
#    And user confirm the email
#    And user visit the mail and click on the link
#    And user write password as "<password>"
#    And user write confirm_password as "<confirm_password>"
#    Then the password is not changed and an error message appear

   // Examples:
     // | password  | confirm_password |
     // | admin123! | admin123!        |
    //  | Admin1234 | Admin1234        |
    //  | Admin!!!! | Admin!!!!        |
    //  | ADMIN123! | ADMIN123!        |
   //   | Admin1!   | Admin1!          |
   //   |           | Admin123!        |
   //   | Admin123! | Admin12345!      |
 //     | Admin123! |                  |

