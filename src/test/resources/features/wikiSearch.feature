Feature: Wikipedia search functionality and verification


  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on the Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" in the wiki title


    @scenarioOutline @wip
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on the Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" in the wiki title
    Then User sees "<expectedMainHeader>" in the wiki header
    Examples:
      | searchValue       | expectedTitle     | expectedMainHeader |
      | Steve Jobs        | Steve Jobs        | Steve Jobs         |
      | Cristiano Ronaldo | Cristiano Ronaldo | Cristiano Ronaldo  |
      | Bob Marley        | Bob Marley        | Bob Marley         |
      | Penélope Cruz     | Penélope Cruz     | Penélope Cruz      |



  # There is no need to write codes with repeated steps.
  # We can write the steps in a single line with using Example table.
  # You can check the example table in the dataTables.feature file.
  # Ignore below steps if you are not familiar with Example table.
  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on the Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" in the wiki title
