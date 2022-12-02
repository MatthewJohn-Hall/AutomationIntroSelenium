@ChooseFlightsHomePage
Feature: Find Flights DropDown

  Background: Blazedemo home page (blazedemo.com) is open within the driver
    Given I have navigated to the Blaze Homepage


  @SelectCities
  Scenario: Select Two cities and click Find Flights
    Given the following selection of departure and destination cities to choose from
      | Paris         | Buenos Aires  |
      | Philadelphia  | Rome          |
      | Boston        | London        |
      | Portland      | Berlin        |
      | San Diego     | New York      |
      | Mexico City   | Dublin        |
      | São Paolo     | Cairo         |
    When A depature and destination city are selected and find flights is clicked
    Then The reserve page will display the correct flights within the Flights from city to city string

  @SelectCities
  Scenario Outline: Selecting Cities in an outline
    When The "<Departure>" and "<Destination>" cities are chosen and find flights is clicked
    Then The reserve page will display the correct flights within the Flights from city to city string

    Examples:
      | Departure     | Destination   |
      | Paris         | Buenos Aires  |
      | Philadelphia  | Rome          |
      | Boston        | London        |
      | Portland      | Berlin        |
      | San Diego     | New York      |
      | Mexico City   | Dublin        |
      | São Paolo     | Cairo         |

  @SelectCitiesUsingaMap
  Scenario: Selecting Cities
    Given the following datatable
      | Paris         | Buenos Aires  |
      | Philadelphia  | Rome          |
      | Boston        | London        |
      | Portland      | Berlin        |
      | San Diego     | New York      |
      | Mexico City   | Dublin        |
      | São Paolo     | Cairo         |

    When The cities are chosen and find flights is clicked when using a map
    Then The reserve page will display the correct flights within the Flights from city to city string







