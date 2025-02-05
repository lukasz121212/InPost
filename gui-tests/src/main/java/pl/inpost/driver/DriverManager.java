package pl.inpost.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pl.inpost.utils.ConfigReader;

public class DriverManager {

    private static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        String browser = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        logger.info("Starting browser: {} with headless parameter set to: {}", browser, headless);

        if (browser == null) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
            }
            case "chrome", default -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
            }
        }

        driver.manage().window().maximize();

        logger.info("Opening Home Page: {}", ConfigReader.getBaseUrl());
        driver.get(ConfigReader.getBaseUrl());
    }

    public static void quitDriver() {
        logger.info("Closing the browser");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
