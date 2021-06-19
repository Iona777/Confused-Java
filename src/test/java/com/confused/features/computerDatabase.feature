Feature: Add and delete entries from comptuer database

  Scenario Outline: Add a computer to the database
    Given I have navigated to the Computer Database page
    When I click on the Add a new computer button
    And I enter new computer details "<Computer Name>", "<IntroducedDate>", "<Company>"
    Then Then I get a success message for "<Computer Name>"
    Examples:
      | Computer Name | IntroducedDate | Company |
      | HAL           | 2001-01-01     | 6       |

    Scenario: Select a computer and delete it from list
      Given I have navigated to the Computer Database page
      When I select row 1
      Then the Edit computer screen is displayed
      When I click on Delete this computer button
      Then Then I get a deletion successful message

    Scenario: I filter by computer name
      Given I have navigated to the Computer Database page
      When I filter by "HAL"
      Then list is filtered by name "HAL"