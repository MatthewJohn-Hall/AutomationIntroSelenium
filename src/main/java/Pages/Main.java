package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) {




        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://blazedemo.com/");

        BlzeHome homePick = new BlzeHome(driver);
        ReserveFlight reservePage = new ReserveFlight(driver);
        PurchasePage purPage = new PurchasePage(driver);

        homePick.chooseFlights(homePick.getDeparture(4), homePick.getDestination(4));
        homePick.clickFind();


        reservePage.selectFlight(2);



        purPage.fillName("Matthew");
        purPage.fillAddress("123 a long way");
        purPage.fillCity("A dream");
        purPage.fillState("A nightmare");
        purPage.fillZipCode("123456");
        purPage.chooseCard("visa");
        purPage.fillMonth("January");
        purPage.fillYear("1984");
        purPage.fillNameOnCard("Yo Dada");
        purPage.clickPurchase();


        System.out.println("this worked");

    }

}
