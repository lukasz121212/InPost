package pl.inpost.steps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.inpost.driver.DriverManager;
import pl.inpost.pages.SearchResultsPage;
import pl.inpost.utils.Common;

public class SearchResultsSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    private final Common common = new Common(driver);

    @Then("shipment number {string} is displayed in the header")
    public void parcelNumberIsDisplayedWithStatus(String shipmentNumber) {
        Assertions.assertThat(common.isElementVisible(searchResultsPage.getHeaderWithShipmentNumber(shipmentNumber)))
                .as("Page Header with shipment number '%s' is not visible", shipmentNumber)
                .isTrue();
    }

    @Then("active shipment status is {string}")
    public void activeShipmentStatusIs(String shipmentStatus) {
        Assertions.assertThat(common.isElementVisible(searchResultsPage.getExpectedActiveStatus(shipmentStatus)))
                .as("Expected active shipment status '%s' is not displayed", shipmentStatus)
                .isTrue();
    }

}
