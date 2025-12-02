Feature: Practice Form Activity

  Scenario Outline: Verify that the Practice activity is functional
    Given that I am in the DEMO homepage for Practice activity
    When I navigated to the Practice activity page
    And I can enter my firstname "<firstname>", lastname "<lastname>", email "<email>", select my gender and type my number "<number>"
    And enter my birth date
    And enter my hobbies
    And upload picture
    And enter my location
    Then I must be able to submit the modal successfully

    Examples:
      | firstname | lastname | email                       | number       |
      | John      | Doe      | testdoeemail@rocketmail.com | 639991523341 |

