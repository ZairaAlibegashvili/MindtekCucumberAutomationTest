@regression @ui @smoke @elarLogin
Feature: Validation Yard button

  Background: Logging in yard button
    Given User will navigate to application
    When logs in with username "student@mindtekbootcamp.com" and password "ilovejava"
    And User clicks logged in
    And User clicks the Yard button
    And User clicks the Add Yard button


  @elarYardBtn
    @MB-107
  Scenario: Testing Apt field with valid characters

    When User enter Apt name "flowers,.-%#"
    Then  User should see created  apt name  "flowers,.-%#"




  @positive


  Scenario: Testing City field with 28 characters
    When User enter "New-York New-York New-York N" in the city field
    Then The city field should contain "New-York New-York New-York N"

  @negative
  Scenario:Entering an invalid City name
    When User type  "123" in the City field
    Then The city should show an error message "Invalid input"

  Scenario: Selecting a state from the State field
    When USer select "New York" from the States field
    Then the states field should contain "New York"


  Scenario: Testing a valid zip number
    When User enter "11229" in the Zip field
    Then the Zip field should contain "11229"

@zip
  Scenario: Testing invalid zip number (less than 5 digits)
    When User enter "1122" inside the zip field
    Then the Zip field should show an error message "Min length is 5 characters, currently it is 4"


  Scenario: Testing Zip with field empty
    When User leave the Zip field empty
    Then The website should display the message "This field is required."

  Scenario: Testing states withe empty field
    And User does not  select any state from the States field
    Then the website should display the message "This field is required."
