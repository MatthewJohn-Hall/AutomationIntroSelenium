package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinition"},
        /*plugin = { "pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-reports/Cucumber-test-results.html" },*/
        /*plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},*/
        plugin = {"pretty",
            "json:target/cucumber-reports/CucumberAllure.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        //tags = "@ChooseFlightsHomePage",
        monochrome = true)

public class RunnerTest {

}
