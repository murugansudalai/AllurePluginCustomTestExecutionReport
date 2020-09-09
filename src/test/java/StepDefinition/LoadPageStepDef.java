package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Allure;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoadPageStepDef {
    private WebDriver driver;

    @Given("^user open the browser$")
    public void user_open_the_browser() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaWorkSpace\\cucumber-java-selenium-webdriver-example\\target\\test-classes\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("^user navigate to url \"([^\"]*)\"$")
    public void user_navigate_to_home_page(String url) throws Exception{
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Allure.addAttachment("screenshot",InputStream.nullInputStream());

    }

    @Then("^user see the page successfully loaded with title \"([^\"]*)\"$")
    public void user_see_the_home_page_successfully_loaded(String title) throws Exception{
        //Check Title content
        assertTrue(driver.getTitle().contains(title));
        Allure.addAttachment("title", driver.getTitle());
        afterHooks();
    }

    @After()
    public void afterHooks() throws Exception{
        driver.close();
    }
}

