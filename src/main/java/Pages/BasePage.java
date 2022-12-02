package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

abstract public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    boolean elementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    public void selectValueFromDropDown(By selector, String dropDownValue){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select dropDown = new Select(driver.findElement(selector));
        dropDown.selectByValue(dropDownValue);
    }

    public void genericClick(By selector){
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

    public void fillTextBox(By selector, String someText ){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element = driver.findElement(selector);
        element.click();
        element.sendKeys(someText);
    }

    public void fillTextBox2(By selector, String someText ){
        wait.until(ExpectedConditions.elementToBeClickable(selector)).click();
        driver.findElement(selector).sendKeys(someText);
    }


    public ArrayList<String> dropDownArrayPopulate(By select){
        wait.until(ExpectedConditions.elementToBeClickable(select));
        List<WebElement> dropDownLoc = new Select(driver.findElement(select)).getOptions();
        ArrayList<String> dropDownList = new ArrayList<String>();

        for (WebElement eachPage : dropDownLoc) {
            dropDownList.add(eachPage.getText());
        }

        return dropDownList;
    }

}
