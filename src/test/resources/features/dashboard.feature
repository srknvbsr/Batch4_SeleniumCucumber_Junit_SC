@login @regression
Feature: Dashboard Test


  Scenario: Dashboard Menu Tests(Usage of cucunber List)
    Given The user is on the login page
    When The user logs in with valid credentials "maho@hotmail.com" and "Maho123456789"
    Then The user should be able to login
    And Verify that the username on the dashboard page is "maho"
    And The user should be able to see all following tabs that shown on the page
      | Dashboard  |
      | Developers |
      | Components |
      | Forms      |
      | JavaScript |
      | maho       |

