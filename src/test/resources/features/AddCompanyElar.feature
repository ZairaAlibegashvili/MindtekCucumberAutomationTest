Feature:Validating edited information in company in database
  @smoke @regression @api @project

    Scenario: Validating if edited information exists in company database
    Given :User opens Elar web page with username "student@mindtekbootcamp.com" and password "ilovejava"
    And User clicks on companies BTN
    And User clicks on Add Company Btn
    And User creates company with data
      | Name    | MC#       | DOT#    | Phone        | Street     | City     | State   | Zip Code | Email           | Insurance name | Prod Phone   | Prod Street | Prod City | Prod State | Prod ZipCode | Prod Email    | Empl ID number |
      | AABBCC | 405654345 | 1000010 | 372-222-2222 | 852 Street | New York | Alabama | 11229    | 45698@gmail.com | Metlife        | 222-222-2233 | 1111 Street | Hollywood | FL         | 33009        | 123@yahoo.com | 123456789      |
    When User changes company Name to "ABBCC"
    Then User validates with JDBC if company name is changed
