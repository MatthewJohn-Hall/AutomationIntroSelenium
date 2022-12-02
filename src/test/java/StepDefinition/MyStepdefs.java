package StepDefinition;

import Pages.BlzeHome;
import Pages.PurchasePage;
import Pages.ReserveFlight;
import Util.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStepdefs {

    public static DriverFactory driver = new Util.DriverFactory();
    private static BlzeHome homePick;
    private static final ReserveFlight reservePage = new ReserveFlight(driver.getDriver());
    private static final PurchasePage purPage = new PurchasePage(driver.getDriver());

    private List<String> departureCities = new ArrayList<>();
    private List<String> destinationCities = new ArrayList<>();
    private String departureCity;
    private String destinationCity;

    private Map<String, String> cities;





    @Given("I have navigated to the Blaze Homepage")
    public void iHaveNavigatedToTheBlazeHomepage() {
        driver.navDriver("https://blazedemo.com/");
        homePick = new BlzeHome(driver.getDriver());
    }

    @Given("the following selection of departure and destination cities to choose from")
    public void theFollowSelectionOfDepartureAndDestinationCitiesToChooseFrom(DataTable table) {
        for(int i=0; i < table.height(); i++ ){
            departureCities.add(table.cell(i,0));
            destinationCities.add(table.cell(i,1));
        }
    }

    @Given("I have selected a departure and destination city and clicked find flights")
    public void iHaveSelectedADepartureAndDestinationCityAndClickedFindFlights() {
        driver.navDriver("https://blazedemo.com/");
        homePick = new BlzeHome(driver.getDriver());
        homePick.chooseFlights(homePick.getDeparture(4), homePick.getDestination(4));
        homePick.clickFind();
    }

    @Given("I have selected my cities and chosen my flight")
    public void iHaveSelectedMyCitiesAndChosenMyFlights() {
        driver.navDriver("https://blazedemo.com/");
        homePick = new BlzeHome(driver.getDriver());
        homePick.chooseFlights(homePick.getDeparture(4), homePick.getDestination(4));
        homePick.clickFind();
        reservePage.selectFlight(234);
    }

    @Given("the following datatable")
    public void theFollowingDatatable() {

    }


    @When("A {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string} are inputed")
    public void aNameAddressCityStateZipCodeCardTypeCreditCardNumberMonthYearAndNameOnCardAreInputed(String arg0,String arg1,
    String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
        purPage.fillName(arg0);
        purPage.fillAddress(arg1);
        purPage.fillCity(arg2);
        purPage.fillState(arg3);
        purPage.fillZipCode(arg4);
        purPage.chooseCard(arg5);
        purPage.inputCardNumber(arg6);
        purPage.fillMonth(arg7);
        purPage.fillYear(arg8);
        purPage.fillNameOnCard(arg9);
        purPage.clickPurchase();
    }

    @When("A depature and destination city are selected and find flights is clicked")
    public void aDepatureAndDestinationCityAreSelectedAndFindFlightsIsClicked() {
        departureCity = departureCities.get(2);
        destinationCity = destinationCities.get(4);
        homePick.chooseFlights(departureCities.get(2), destinationCities.get(4));
        homePick.clickFind();
    }

      @When("The {string} and {string} cities are chosen and find flights is clicked")
    public void aDepartureAndDestinationChosenAndButtonClicked(String arg0, String arg1) {
        departureCity = arg0;
        destinationCity = arg1;
        homePick.chooseDeparture(arg0);
        homePick.chooseDestination(arg1);
        homePick.clickFind();
    }

    @When("The cities are chosen and find flights is clicked when using a map")
    public void theAndCitiesAreChosenAndFindFlightsIsClickedWhenUsingAMap() {
        homePick.chooseFlights(departureCities.get(2), cities.get("Portland"));
        homePick.clickFind();
    }

    @When("A {string} is chosen and the choose this flight button is clicked")
    public void aFlightNumIsChosenAndTheChooseThisFlightButtonIsClicked(String arg0) {
        reservePage.selectFlight(Integer.parseInt(arg0));
    }

    @Then("The reserve page will display the correct flights within the Flights from city to city string")
    public void theReservePageWillDisplayTheCorrectFlightsWithinTheFlightsFromCityToCityString() {
        String expected = "Flights from "+departureCity+" to "+destinationCity+":";
        Assertions.assertEquals(expected, reservePage.getDestinationAndDepartureCities());
    }

    @Then("The purchase page will be displayed with a descriptive header")
    public void thePurchasePageWillBeDisplayedWithADescriptiveHeader() {
        String check = "Your flight from TLV to SFO has been reserved.";
        Assertions.assertEquals(check, purPage.getTitle());
    }

    @Then("The confirmation page is displayed")
    public void theConfirmationPageIsDisplayed() {
    }


}
