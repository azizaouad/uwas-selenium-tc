package org.uwas;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {
    private WebDriver webDriver;
    private String baseUrl;
    private String chromeDriverPath = "C://Users/Lenovo/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe";

    final Logger logger = LoggerFactory.getLogger(Driver.class);

    public Driver(WebDriver webDriver, String baseUrl) {

        this.webDriver = webDriver;
        this.baseUrl = baseUrl;

    }

    public Driver() {
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver driver) {
        this.webDriver = driver;
    }

    public void setupController() {
        String driverType = "";
        if (System.getProperty("webDriver") != null) {
            driverType = System.getProperty("webDriver");
        }

        else {
            driverType = "chrome";

            logger.error("webDriver not provided");
        }
        System.out.println(driverType);

        if (driverType.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            options.addArguments("no-sandbox");
            options.addArguments("start-maximized");
            options.addArguments("--remote-allow-origins=*");
            // WebDriverManager.firefoxdriver().setup();
            this.webDriver = new FirefoxDriver(options);
            this.webDriver.manage().window().maximize();
        } else {
            if (driverType.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("no-sandbox");
                // options.addArguments("start-maximized");
                options.addArguments("--window-size=1920,1080");

                options.addArguments("--remote-allow-origins=*");
                // WebDriverManager.chromedriver().setup();
                this.webDriver = new ChromeDriver(options);
                this.webDriver.manage().window().maximize();

            }
            // else if (driverType.equals("local")){
            // ChromeOptions options = new ChromeOptions();
            // options.addArguments("--remote-allow-origins=*");
            // this.webDriver = new ChromeDriver(options);
            // this.webDriver.manage().window().maximize();
            // this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        // else {
        // logger.error("driver type is not chrome or firefox");
        // }
        // }

        if (System.getProperty("environment") == null) {
            baseUrl = "https://coralio:cmVjZXR0ZWNvcmFsaW8yMDIyCg==@recette.uwas.fr";
        } else {
            if (System.getProperty("environment").equals("recette")) {
                baseUrl = "https://coralio:cmVjZXR0ZWNvcmFsaW8yMDIyCg==@" + System.getProperty("environment")
                        + ".uwas.fr";
            } else {
                baseUrl = "https://" + System.getProperty("environment") + ".uwas.fr";

            }

        }

        logger.info("BaseUrl to test is :" + baseUrl);

    }

    public void teardownController() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
