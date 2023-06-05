package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

public class loginsteps {
    Driver driver;

    public loginsteps(Driver driver) {

        this.driver = driver;
        this.driver.setupController();

    }

    @Given("user should navigate to the website")
    public void user_should_navigate_to_the_website() {
        try {
            WebDriverManager.chromedriver().setup();
            /*this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();*/
            System.out.println(this.driver.getBaseUrl());
            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            Thread.sleep(20);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user write email as {string} and password as {string} and click on login")
    public void user_write_email_and_password_and_click_on_login(String email , String password) {
        try {
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            // Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {
        try {

           
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown-event-link")));
            boolean f = false ;

            String current_url = this.driver.getWebDriver().getCurrentUrl();
            if (current_url.contentEquals("https://recette.uwas.fr/login")) {
                f = false;
                System.out.println("test fail");
            }
            else {
                f = true ;
            }
            Assert.assertTrue(f);
            Thread.sleep(10);
            this.driver.getWebDriver().quit();
            }   catch (InterruptedException e) {
            throw new RuntimeException(e);

        }




    }
    @Then("error message should appear")
    public void error_message_should_appear() {
        try {
            // Thread.sleep(1000);
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("email")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("password")).isDisplayed());
            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
    }
    }
}
