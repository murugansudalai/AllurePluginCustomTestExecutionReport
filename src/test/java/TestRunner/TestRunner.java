package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"StepDefinition"},
        plugin = {"pretty", "html:build/cucumber-html-reports/",
                "json:build/cucumber-html-reports/cucumber.json",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
        }
        )
public class TestRunner {

}
