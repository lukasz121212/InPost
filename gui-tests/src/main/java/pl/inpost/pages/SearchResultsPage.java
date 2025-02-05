package pl.inpost.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeaderWithShipmentNumber(String shipmentNumber) {
        return driver.findElement(By.xpath("//h3[contains(@class, 'header')]//b[text()='" + shipmentNumber + "']"));
    }

    public WebElement getExpectedActiveStatus(String expected) {
        return driver.findElement(By.xpath("//div[@class='single--status--block -active']//p[text()='" + expected + "']"));
    }

}
