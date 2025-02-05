package pl.inpost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='number']")
    private WebElement searchNumberInput;

    @FindBy(xpath = "//button//span[text()='Find']")
    private WebElement findButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillSearchNumberInput(String parcelNumber) {
        searchNumberInput.sendKeys(parcelNumber);
    }

    public void clickFindButton() {
        findButton.click();
    }
}
