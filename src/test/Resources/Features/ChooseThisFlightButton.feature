@ChooseFlightsReservePage
Feature: Choose this Flight

  Background: Blazedemo reserve page (blazedemo.com/reserve.php) is open within the driver
    Given I have selected a departure and destination city and clicked find flights

  @SelectCities
  Scenario Outline: Selecting Cities
    When A "<Flight#>" is chosen and the choose this flight button is clicked
    Then The purchase page will be displayed with a descriptive header

    Examples:
      | Flight#       |
      | 43            |
      | 234           |
      | 9696          |
      | 12            |
      | 4346          |