package pl.inpost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;

public class CommonPage {
    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(CommonPage.class);

    @FindBy(xpath = "//div[@id='onetrust-group-container']")
    private WebElement cookiesInfoAlert;


    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookiesInfoButton;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (wait.until(ExpectedConditions.visibilityOf(cookiesInfoAlert)).isDisplayed()) {
                acceptCookiesInfoButton.click();
                logger.info("Accepting Cookies Alert");
            }
        } catch (Exception e) {
            logger.warn("Cookies Alert was not displayed");
        }
    }
}
