@Regression
Feature: Librarian app login feature
  User story
  As as User I should be able to login with correct credentials to different accounts
  and dashboard should be displayed
  Accounts: Librarian, Student, Admin

  Background: Librarian app is up and running
    Given I am on the login page

  Scenario Outline: Login with correct credentials to different accounts
    When I enter valid "<username>" and "<password>"
    And I click on the login button
    Then I should be logged in to "<account>" account
    Examples:
      | username   | password | account   |
      | librarian1 | 123456   | librarian |
      | librarian2 | 123456   | librarian |
      | librarian3 | 123456   | librarian |
      | student1   | 123456   | student   |
      | student2   | 123456   | student   |
      | student3   | 123456   | student   |
      | admin1     | 123456   | admin     |

    Scenario Outline: Login with incorrect credentials
      Given I am on the login page
      When I enter valid "<username>" and "<password>"
      And I click on the login button
      Then I should see error message "Invalid username or password."
      Examples:
        | username   | password |
        |            | 987654   |
        | librarian8 |          |
        | librarian7 | 987654   |
        |            | 987654   |
        | student5   | 987654   |
        | student4   |          |
        | -admin0    | 987654   |