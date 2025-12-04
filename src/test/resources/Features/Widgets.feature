@tag
Feature: Widgets Activity

  Scenario: Verify that the Auto Suggestion activity is functional
    Given I am in the DEMO homepage for Auto Suggestion activity
    When I navigated to the Auto Suggestion activity page
    And verify that I can enter multiple color
    Then I must be able to enter single color only

  Scenario: Verify that the Date Picker activity is functional
    Given I am in the DEMO homepage for Date Picker activity
    When I navigated to the Date Picker activity page
    And I verify the Date Picker as functional by typing
    Then the Date Picker Selector must be functional

  Scenario: Verify that the Progress Bar activity is functional
    Given that I am in the DEMO homepage for Progress Bar activity
    When I navigated to the Progress bar activity page
    And I click the button to start the progress bar and pause at 50%
    And I resume the progress bar by clicking Start again
    And I verify that the progress bar is finished
    Then I must be able to reset the progress bar

  Scenario: Verify that the Select Menu activity is functional
    Given that I am in the DEMO homepage for Select Menu activity
    When I navigated to the Select Menu activity page
    Then I must be able to verify the value field
    And I must be able to verify the one value field
    And I must be able to verify the select one value field
    And I must be able to verify the old style value field as functional
    And I must be able to verify the multiple select value field
    And I must be able to verify the standard multi select value field

