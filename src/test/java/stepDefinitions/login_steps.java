package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
// import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login_steps extends Base {

    @Before("@login")
    public void user_should_navigate_to_the_website() {
        launch_browser();

    }

    @After("@login")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @When("user write email as {string} and password as {string} and click on login")
    public void user_write_email_and_password_and_click_on_login(String email, String password) {
        try {

            Thread.sleep(10);
            waitForVisibilityOfElement(By.id("email"));

            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id(
                    "password"));
            WebElement loginButton = driver.findElement(By.id("testLogin"));

            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            loginButton.click();

        }

        catch (

        InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {
        waitForVisibilityOfElement(By.id("user-dropdown"));

        WebElement mee = driver.findElement(By.id("user-dropdown"));
        String currenturl = driver.getCurrentUrl();
        Assert.assertTrue(mee.isDisplayed());
        Assert.assertFalse(currenturl.contains("/login"));

    }

    @Then("error message should appear")
    public void error_message_should_appear() {

        waitForVisibilityOfElement(By.id("email"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id(
                "password"));
        WebElement loginButton = driver.findElement(By.id("testLogin"));

        Assert.assertTrue(emailField.isDisplayed());
        Assert.assertTrue(passwordField.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());

    }
}
