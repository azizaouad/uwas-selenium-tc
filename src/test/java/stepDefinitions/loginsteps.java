package stepDefinitions;

// import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

import java.time.Duration;

public class loginsteps {
    private final Driver driver;

    public loginsteps(Driver driver) {
        this.driver = driver;
        this.driver.setupController();
    }

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    // @AfterAll
    // public static void close(){
    // this.driver.getWebDriver().quit();
    // }

    @Given("user should navigate to the website")
    public void user_should_navigate_to_the_website() {
        WebDriver webDriver = driver.getWebDriver();
        webDriver.get(driver.getBaseUrl() + "/login");
    }

    @When("user write email as {string} and password as {string} and click on login")
    public void user_write_email_and_password_and_click_on_login(String email, String password) {
        WebDriver webDriver = driver.getWebDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement passwordField = webDriver.findElement(By.id("password"));
        WebElement loginButton = webDriver.findElement(By.id("testLogin"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {
        WebDriver webDriver = driver.getWebDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        WebElement userDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-dropdown")));
        String currentUrl = webDriver.getCurrentUrl();

        Assert.assertNotEquals("https://recette.uwas.fr/login", currentUrl);
        Assert.assertTrue(userDropdown.isDisplayed());
    }

    @Then("error message should appear")
    public void error_message_should_appear() {
        WebDriver webDriver = driver.getWebDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        Assert.assertTrue(emailField.isDisplayed());
        Assert.assertTrue(passwordField.isDisplayed());
    }
}
