@login @regression
Feature: Login Functionality
  #user Story = Feature:

  @user
  Scenario: Login as a user
    #Test Case =Scenario
    Given The user is on the login page
    ##Tes Steps= Given,When,Then..etc
    When The user logs in with Melih's credentials
    Then The user should be able to login

  @user
  Scenario: Login as a user
    Given The user is on the login page
    When The user logs in with Rosa's credentials
    Then The user should be able to login


  Scenario: Login With parameter
    Given The user is on the login page
    When The user logs in with valid credentials "maho@hotmail.com" and "Maho123456789"
    Then The user should be able to login
    * Verify that the username on the dashboard page is "maho"


  Scenario: Login With parameter
    Given The user is on the login page
    When The user logs in with valid credentials "rosa@test.com" and "Test123456"
    Then The user should be able to login
    * Verify that the username on the dashboard page is "Rosa"


  Scenario: Login With cucumberList
    Given The user is on the login page
    When The user logins with following list
      | maho@hotmail.com |
      | Maho123456789    |
      | maho             |
    Then The user should be able to login

  @wip
  Scenario: Login With cucumberMap
    Given The user is on the login page
    When The user logins with following map
      | userEmail | maho@hotmail.com |
      | password  | Maho123456789    |
      | name      | maho             |
    Then The user should be able to login

  @wip
  Scenario Outline: Login test with scenario outline
    Given The user is on the login page
    When The user logs in with valid credentials "<userEmail>" and "<password>"
    Then The user should be able to login
    And Verify that the username on the dashboard page is "<username>"
    Examples:
      | userEmail        | password      | username    |
      | maho@hotmail.com | Maho123456789 | maho        |
      | rosa@test.com    | Test123456    | Rosa        |
      | mgezer@gmail.com | Mg12345678    | Melih Gezer |


