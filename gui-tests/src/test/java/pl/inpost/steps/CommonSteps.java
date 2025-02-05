package pl.inpost.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.assertj.core.api.Assertions;

import org.openqa.selenium.WebDriver;

import pl.inpost.driver.DriverManager;
import pl.inpost.pages.CommonPage;
import pl.inpost.utils.Common;

public class CommonSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private final Common common = new Common(driver);
    private final CommonPage commonPage = new CommonPage(driver);

    @Then("page header {string} is displayed")
    public void userGoesToPage(String headerText) {
        Assertions.assertThat(common.isElementVisible(common.getHeaderWithText(headerText)))
                .as("Page Header '%s' is not visible", headerText)
                .isTrue();
    }

    @Given("user clicks accept in Cookies Alert if displayed")
    public void userClicksAcceptInCookiesAlertIfDisplayed() {
        commonPage.acceptCookiesIfPresent();
    }
}
