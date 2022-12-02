package Tests;

import Pages.BlzeHome;
import Pages.PurchasePage;
import Pages.ReserveFlight;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;


public class FlightPickerTest {

    public static WebDriver driver;
    private static BlzeHome homePick;
    private ReserveFlight reservePage = new ReserveFlight(driver);
    private PurchasePage purPage = new PurchasePage(driver);


    @RegisterExtension
    ScreenshotWatcher5 watcher = new ScreenshotWatcher5(driver, "D:\\ten10\\programming\\AutomationIntroSelenium");


    @BeforeAll
    public static void globalBefore() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().addArguments("headless");
        //ChromeOptions options = new ChromeOptions().addArguments("start-maximized");
        //options.addArguments("incognito");
        //options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.get("https://blazedemo.com/");
        homePick = new BlzeHome(driver);
    }

    @BeforeEach
    public void testBefore(){
        driver.get("https://blazedemo.com/");
    }


    @Test
    public void test1() {
        homePick.chooseFlights(homePick.getDeparture(2), homePick.getDestination(4));
        homePick.clickFind();
        Assertions.assertEquals("https://blazedemo.com/reserve.php", driver.getCurrentUrl());
    }

    @Test
    public void test2() {
        homePick.chooseFlights(homePick.getDeparture(2), homePick.getDestination(4));
        homePick.clickFind();
        reservePage.selectFlight(9696);
        String check = "Your flight from TLV to SFO has been reserved.";
        Assertions.assertTrue(check.equals(purPage.getTitle()));

    }

    @AfterEach
    public void individualTearDown() {





        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void globalAfter() throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("D:\\ten10\\programming\\AutomationIntroSelenium");
        FileUtils.copyFileToDirectory(SrcFile, DestFile);
    }


}
