Feature: Examples of Cucumber data table implementations

  Scenario: List of fruits I like
    Then User should see fruits I like
      | kiwi        |
      | banana      |
      | cucumber    |
      | orange      |
      | mango       |
      | grape       |
      | pomegranate |

  @wip
  Scenario: User should be able to see all 12 months of the year in the dropdown menu
    Given User is on the dropdowns page of practice tool
    When User should see below info in month dropdown menu
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |