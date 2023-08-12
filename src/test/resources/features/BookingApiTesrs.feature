Feature: Validating booking api calls
  @MB-188  @api
  Scenario Outline: Validating POST booking Api call
    Given user creates booking with POST api call with data
      | firstname       | <firstname>       |
      | lastname        | <lastname >       |
      | totalprice      | <totalprice>      |
      | checkin         | <checkin>         |
      | checkout        | <checkout>        |
      | additionalneeds | <additionalneeds> |
    When  user gets created booking with GET api call
    Then user validates <statusCode> status code
    And user validates created data matches with response of get call
    Examples:
      | firstname | lastname | totalprice | checkin    | checkout   | additionalneeds |statusCode|
      | Jim       | Brown    | 111        | 2018-01-01 | 2019-01-01 | Breakfast       |200       |
      | Patel     | Harsh    | 1000       | 2019-01-01 | 2019-02-02 | Bicycle         |200       |
      | Kim       | Yan      | 2000       | 2020-01-01 | 2019-01-02 | Sushi           |404       |
@MB8-102  @smoke @regression @api
    Scenario: Validating PUT booking Api call
      Given user creates booking with POST api call with data
        | firstname       | Harsh      |
        | lastname        | Patel      |
        | totalprice      | 100        |
        | checkin         | 2018-01-01 |
        | checkout        | 2019-02-02 |
        | additionalneeds | Breakfast  |
      When user updates booking with PUT api call with data
        | firstname       | Jim      |
        | checkin         | 2023-01-01 |
        | checkout        | 2023-02-02 |

      And user gates updated booking with GET api call
      Then user validates 200 status code
      And user validates updated data matches with response of get call
