@login @regression
Feature: Add education Tests


  Scenario: Add education from label tests
    Given The user is on the login page
    When The user logs in with valid credentials "maho@hotmail.com" and "Maho123456789"
    Then Verify that the username on the dashboard page is "maho"
    When The user should be able to navigate tabs and Modules with "maho" and "My Profil"
    When The user should be able to navigate User Profil Page Tabs with "Add Education"
    Then The user should be able to see following labels at the Education Form
      | School or Bootcamp *    |
      | Degree or Certificate * |
      | Study                   |
      | From Date               |
      |                         |
      | To Date                 |
      | Program Description     |


  Scenario: Add education from label tests
    Given The user is on the login page
    When The user logs in with valid credentials "maho@hotmail.com" and "Maho123456789"
    Then Verify that the username on the dashboard page is "maho"
    When The user should be able to navigate tabs and Modules with "maho" and "My Profil"
    When The user should be able to navigate User Profil Page Tabs with "Add Education"
    Then The user should be able to see following labels at the Education Form_second
      | School or Bootcamp *    |
      | Degree or Certificate * |
      | Study                   |
      | From Date               |
      | To Date                 |
      | Program Description     |


  Scenario Outline: Add education from test with scenario outline
    Given The user is on the login page
    When The user logs in with valid credentials "<userEmail>" and "<password>"
    Then Verify that the username on the dashboard page is "<username>"
    When The user should be able to navigate tabs and Modules with "<tabname>" and "<moduleName>"
    When The user should be able to navigate User Profil Page Tabs with "<userProfilTabName>"
    Then The user should be able to see following labels at the Education Form_second
      | School or Bootcamp *    |
      | Degree or Certificate * |
      | Study                   |
      | From Date               |
      | To Date                 |
      | Program Description     |
    When The user fills the education form with "<school>","<degree>","<study>","<fromDate>","<toDate>","<description>"
    Then The user sholud be able to see last added record with "<school>"
    And The user should be able to delete last added record with "<school>"
    Examples:
      | userEmail        | password      | username    | tabname     | moduleName | userProfilTabName | school | degree | study    | fromDate | toDate | description  |
      | mgezer@gmail.com | Mg12345678    | Melih Gezer | Melih Gezer | My Profile | Add Education     | Gazi   | first  | Finance  | 11112012 | 020220 | Easy Program |
      | maho@hotmail.com | Maho123456789 | maho        | maho        | My Profile | Add Education     | İTU    | second | Engineer | 11112012 | 020220 | Hard Program |
