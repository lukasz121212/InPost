package pl.inpost.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.inpost.driver.DriverManager;
import pl.inpost.pages.HomePage;
import pl.inpost.utils.ConfigReader;

public class HomePageSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private final HomePage homePage = new HomePage(driver);
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    @Given("user enters InPost home page")
    public void userEntersInPostHomePage() {
        String currentUrl = driver.getCurrentUrl();
        String baseUrl = ConfigReader.getBaseUrl();
        if (!currentUrl.equals(baseUrl)) {
            driver.get(baseUrl);
            logger.info("Opening Home Page: {}", baseUrl);
        } else {
            logger.info("Home Page already opened: {}", baseUrl);
        }
    }

    @When("user enters parcel number {string} in search input")
    public void userEntersParcelNumberInSearchInput(String parcelNumber) {
        homePage.fillSearchNumberInput(parcelNumber);
    }

    @When("user clicks find button")
    public void userClicksFindButton() {
        homePage.clickFindButton();
    }
}
