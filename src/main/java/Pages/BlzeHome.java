package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BlzeHome extends BasePage{

 /**---------Variables------------------*/
    private ArrayList<String> depFlightsLocation = new ArrayList<>();
    private ArrayList<String> desFlightsLocation = new ArrayList<>();


    /**------------------Statics----------------*/
    //private static final By SELECT_FLIGHT_DEPARTURE_DROPDOWN = By.cssSelector("select[name=\"fromPort\"]");
    private static final By SELECT_FLIGHT_DEPARTURE_DROPDOWN = By.xpath("//select[@name='fromPort']");
    //private static final By SELECT_FLIGHT_DESTINATION_DROPDOWN = By.cssSelector("select[name=\"toPort\"]");
    private static final By SELECT_FLIGHT_DESTINATION_DROPDOWN = By.xpath("//select[@name='toPort']");
    //private static final By FIND_FLIGHTS_BUTTON = By.cssSelector("input[value='Find Flights']");
    private static final By FIND_FLIGHTS_BUTTON = By.xpath("//input[@value='Find Flights']");
    private static String URL = "https://blazedemo.com/";


    /**--------------------------Constructor--------------------------*/
    public BlzeHome(WebDriver driver) {super(driver);
        depFlightsLocation.addAll(dropDownArrayPopulate(SELECT_FLIGHT_DEPARTURE_DROPDOWN));
        desFlightsLocation.addAll(dropDownArrayPopulate(SELECT_FLIGHT_DESTINATION_DROPDOWN));
    }


    /**--------------------------Methods--------------------------*/
    public String getDeparture(int choice){
        return depFlightsLocation.get(choice);
    }

    public String getDestination(int choice){
        return desFlightsLocation.get(choice);
    }
    public void chooseFlights(String a, String b){
        selectValueFromDropDown(SELECT_FLIGHT_DEPARTURE_DROPDOWN, a);
        selectValueFromDropDown(SELECT_FLIGHT_DESTINATION_DROPDOWN, b);
    }

    public void chooseDeparture(String a){
        selectValueFromDropDown(SELECT_FLIGHT_DEPARTURE_DROPDOWN, a);
    }

    public void chooseDestination(String a){
        selectValueFromDropDown(SELECT_FLIGHT_DESTINATION_DROPDOWN, a);
    }
    public void clickFind(){
        genericClick(FIND_FLIGHTS_BUTTON);
    }

    public void goTo() {
        driver.get(URL);
    }


}
