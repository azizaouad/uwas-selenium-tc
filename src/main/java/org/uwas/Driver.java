package org.uwas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Driver {
    private WebDriver webDriver;
    final Logger logger = LoggerFactory.getLogger(Driver.class);

    public  Driver(WebDriver webDriver) {
        this.webDriver=webDriver;
    }
    public  Driver() {
    }



    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver driver) {
        this.webDriver = driver;
    }

    public void setupController(String driverType) {
        if (driverType == "firefox") {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            this.webDriver = new FirefoxDriver(options);
            this.webDriver.manage().window().maximize();
            this.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        else {
            if (driverType=="chrome"){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                this.webDriver = new ChromeDriver(options);
                this.webDriver.manage().window().maximize();
                this.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            }
            else {
                logger.error("driver type is not chrome or firefox");

            }
        }



    }

    public void teardownController() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
