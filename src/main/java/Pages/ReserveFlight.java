package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReserveFlight extends BasePage {
    public ReserveFlight(WebDriver c) {
        super(c);
    }

    private static final By SELECT_FLIGHTS_FROM_CITY_TO_CITY = By.xpath("/html/body/div[2]/h3");
    public void selectFlight(int flightNumber) {
        //String cssSelector = "tr:nth-of-type("+a+") input[value='Choose This Flight']";
        //genericClick(By.cssSelector(cssSelector));
        //String xpathSelector = "//tr["+(a+1)+"]//input[contains(@value,'Choose')]";
        String xpathSelector ="//td[contains(text(),'"+flightNumber+"')]/preceding-sibling::td/input[contains(@value,'Choose')]" ;
        genericClick(By.xpath(xpathSelector));
    }

    public String getDestinationAndDepartureCities(){
        String title = driver.findElement(SELECT_FLIGHTS_FROM_CITY_TO_CITY).getText();
        return title;

    }



}
