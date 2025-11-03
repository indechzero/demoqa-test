
Feature: Alerts and Windows activities

Scenario: Verify that the Alerts activity is functional
  Given that I am in the DEMO homepage
  When I navigated to the Alerts activity page
  And I click the first alert button to verify that it is functional
  And I click the second alert button to verify that it is functional
  And I click the third alert button to verify that it is functional
  Then the last alert button must be functional

  Scenario: Verify that the Windows activity is functional
    Given that I am in the DEMO homepage for the Windows Activity
    When I navigated to the Windows activity page
    Then I must be able to verify that the windows are functional