@regression @ui @smoke @MB-70
Feature: Validating Login Functionality
  @regression

  Scenario: Validating login functionality with valid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "test"
    Then User is successfully logged in and lands on the homepage

    @regression
    Scenario: Validating login functionality with invalid credentials
      Given User navigates to application
      When User logs in with username "Tester" and password "tester"
      Then User validates error message "Invalid Login or Password."
