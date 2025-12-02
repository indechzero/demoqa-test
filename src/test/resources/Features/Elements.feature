Feature: Elements Activity

  Scenario: Verify that the Button activity is functional
    Given that I am in the DEMO homepage for Buttons activity
    When I navigated to the Buttons activity page
    Then I must be able to perform double click action on button
    And I must be able to perform right click action on right click button
    And I must be able to verify that dynamic button is functional

  Scenario: Verify that the Checkbox activity is functional
    Given that I am in the DEMO homepage for Checkbox activity
    When I navigated to the Checkbox activity page
    Then I must be able to select all checkbox
    And verify all checkbox
    And validate the results

  Scenario: Verify that the Dynamic Properties activity is functional
    Given that I am in the DEMO homepage for Dynamic Properties activity
    When I navigated to the Dynamic Properties activity page
    Then I must be able to verify dynamicButtonColor
    And I must be able to verify disabledButton
    And I must be able to verify dynamicBtnDisplay
    And I must be able to verify dynamicButtonColorChange
    And I must be able to verify dynamicBtnText

  Scenario: Verify that the Links activity is functional
    Given that I am in the DEMO homepage for Links activity
    When I navigated to the Links activity page
    Then I must be able to verify the window links
    And I must be able to verify the API links

  Scenario: Verify that the Radio activity is functional
    Given that I am in the DEMO homepage for Radio Button activity
    When I navigated to the Radio activity page
    Then I was able to verify unselected Radio Button
    And I was able to select Yes Radio Button
    And I was able to select Impressive Radio Button
    And I was not able to select No Radio Button

  Scenario Outline: Verify that the Text Box activity is functional

    Given that I am in the DEMO homepage for Text Box activity
    When I navigated to the Text Box activity page
    Then I must be able to verify the text boxes successfully by submitting username "<username>", email "<email>", address "<address>" and permanent address "<permanentAddress>"

    Examples:
      | username | email             | address               | permanentAddress  |
      | John Doe | testdoe@gmail.com | 123 Playground Street | 456 Sesame Street |

  Scenario Outline: Verify that the Web Tables activity is functional
    Given that I am in the DEMO homepage for Web Tables activity
    When I navigated to the Web Tables activity page
    Then I must be able to add new row entry by entering firstname "<firstname>", lastname "<lastname>", email "<email>", age "<age>", salary "<salary>", department "<department>"
    And edit the new row entry
    And delete the new row entry
    Examples:
      | firstname | lastname | email                    | age | salary | department         |
      | John      | Doe      | testemail@rocketmail.com | 24  | 45000  | Data Interrogation |
