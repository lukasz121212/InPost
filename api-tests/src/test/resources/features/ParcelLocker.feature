Feature: Parcel Locker API tests

  Scenario Outline: Saving parcel locker's name, postal code and coordinates to json file
    When user sends request for parcel search with "<city>" parameter
    Then response returns data
    And json file for "<city>" is saved and present
    Examples:
      | city     |
      | Warsaw   |
      | Krakow   |
      | Gdansk   |
