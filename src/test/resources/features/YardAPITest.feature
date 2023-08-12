Feature: Validating Yard Api calls
  @MB-133 @regression @smoke @api

  Scenario: Validating POST Yard Api call
    Given User creates yard with post yard call with data
      | location | random      |
      | status   | active      |
      | Address  | 123 abc st. |
    When  user connects to database
    Then user validates created yard is persisted in DB
    