@ChooseFlightsFormPage
Feature: Put details in Form

  Background: Blazedemo purchase page (https://blazedemo.com/purchase.php) is open within the driver
    Given I have selected my cities and chosen my flight

  @SelectCities
  Scenario Outline: Filling out the Purchase form
    When A "<Name>", "<Address>", "<City>", "<State>", "<Zip Code>", "<Card Type>", "<Credit Card Number>", "<Month>", "<Year>" and "<NameOnCard>" are inputed
    Then The confirmation page is displayed

    Examples:
      | Name    | Address   | City    | State           | Zip Code  | Card Type   | Credit Card Number  | Month | Year  | NameOnCard        |
      | Matthew | Here      | London  | Glamorgan       | 12345     | visa        | 987654321           | 01    | 2022  | Matthew John-Hall |
      | John    | There     | Moscow  | Greater London  | 54321     | amex        | 123456789           | 10    | 1998  | John Wick         |
      | Jack    | Wherever  | Paris   | York            | 85246     | dinersclub  | 654789123           | 11    | 1983  | Jack Jill         |
      | Sarah   | You       | Berlin  | Leeds           | 65482     | amex        | 963258741           | 08    | 2025  | Sarah Connor      |
      | Sandra  | Are       | Disco   | Liverpool       | 25846     | visa        | 357194682           | 05    | 2045  | Sandra Bullock    |