package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage extends BasePage {
    public PurchasePage(WebDriver c) {
        super(c);
    }

    public void fillName(String a){
        fillTextBox(By.cssSelector("#inputName"), a);
    }
    public void fillAddress(String a){
        fillTextBox(By.cssSelector("#address"), a);
    }
    public void fillCity(String a){
        fillTextBox(By.cssSelector("#city"), a);
    }
    public void fillState(String a){
        fillTextBox(By.cssSelector("#state"), a);
    }
    public void fillZipCode(String a){
        fillTextBox(By.cssSelector("#zipCode"), a);
    }
    public void chooseCard(String a){
        selectValueFromDropDown(By.cssSelector("#cardType"), a);
    }

    public void inputCardNumber(String a){fillTextBox(By.cssSelector("#creditCardNumber"), a);}
    public void fillMonth(String a){
        fillTextBox(By.cssSelector("#creditCardMonth"), a);
    }
    public void fillYear(String a){
        fillTextBox(By.cssSelector("#creditCardYear"), a);
    }
    public void fillNameOnCard(String a){
        fillTextBox(By.cssSelector("#nameOnCard"), a);
    }
    public void clickPurchase(){
        genericClick(By.cssSelector("input[value='Purchase Flight']"));
    }

    public String getTitle(){
        String title = driver.findElement(By.xpath("//h2[contains(text(),'Your flight')]")).getText();
        return title;

    }


}
