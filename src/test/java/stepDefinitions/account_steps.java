package StepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
// import io.cucumber.java.lu.an;

public class account_steps extends Base {

    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    String firstname = addRandomCharacter("first");
    String lastname = addRandomCharacter("last");

    @Before("@scenarioAvecAccount")
    public void goToAccount() {

        initializeChromeDriver();
        waitForVisibilityOfElement(By.id("email"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id(
                "password"));
        WebElement loginButton = driver.findElement(By.id("testLogin"));
        // System.out.println(props.getProperty("emailphotographe"));
        // System.out.println(props.getProperty("password"));
        emailField.sendKeys(props.getProperty("emailphotographe"));
        passwordField.sendKeys(props.getProperty("password"));
        loginButton.click();
        waitForVisibilityOfElement(By.id("user-dropdown"));

        driver.findElement(By.id("user-dropdown")).click();

        driver.findElement(By.id("account-nav")).click();

    }

    @After("@scenarioAvecAccount")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @And("user edit his first name")
    public void user_edit_his_first_name() {
        waitForVisibilityOfElement(By.id("firstName"));
        WebElement First_name = driver.findElement(By.id("firstName"));
        First_name.sendKeys(Keys.CONTROL, "a");
        First_name.sendKeys(Keys.DELETE);
        First_name.sendKeys(firstname);
    }

    @And("user edit his first name {string}")
    public void user_want_to_edit_his_first_name(String first_name) {
        waitForVisibilityOfElement(By.id("firstName"));
        WebElement First_name = driver.findElement(By.id("firstName"));
        First_name.sendKeys(Keys.CONTROL, "a");
        First_name.sendKeys(Keys.DELETE);
        First_name.sendKeys(first_name);
    }

    @And("user edit his last name")
    public void user_edit_his_last_name() {
        waitForVisibilityOfElement(By.id("lastName"));
        WebElement last_name = driver.findElement(By.id("lastName"));
        last_name.sendKeys(Keys.CONTROL, "a");
        last_name.sendKeys(Keys.DELETE);
        last_name.sendKeys(lastname);
    }

    @And("user edit his last name {string}")
    public void user_want_to_edit_his_last_name(String last_name) {
        waitForVisibilityOfElement(By.id("lastName"));
        WebElement First_name = driver.findElement(By.id("lastName"));
        First_name.sendKeys(Keys.CONTROL, "a");
        First_name.sendKeys(Keys.DELETE);
        First_name.sendKeys(last_name);
    }

    @And("user click on edit button")
    public void user_click_on_edit() {
        try {

            driver.findElement(By.id("edit-btn")).click();
            Thread.sleep(40);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the first name does not change to {string}")
    public void the_first_name_does_not_change(String first_name) {
        try {
            driver.navigate().refresh();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("firstName"));

            String newfirstname = driver.findElement(By.id("firstName")).getAttribute("value");

            boolean change = (first_name.toUpperCase()).contentEquals(newfirstname.toUpperCase());
            Assert.assertFalse(change);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("the last name does not change to {string}")
    public void the_last_name_does_not_change(String last_name) {
        try {
            driver.navigate().refresh();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("lastName"));

            String newlastname = driver.findElement(By.id("lastName")).getAttribute("value");

            boolean change = (last_name.toUpperCase()).contentEquals(newlastname.toUpperCase());
            Assert.assertFalse(change);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("first name should be changed")
    public void first_name_should_be_changed() {
        try {
            driver.navigate().refresh();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("firstName"));

            String newfirstname = driver.findElement(By.id("firstName")).getAttribute("value");

            boolean change = (firstname.toUpperCase()).contentEquals(newfirstname.toUpperCase());
            Assert.assertTrue(change);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("last name should be changed")
    public void last_name_should_be_changed() {
        try {
            driver.navigate().refresh();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("lastName"));

            String newlastname = driver.findElement(By.id("lastName")).getAttribute("value");

            boolean change = (lastname.toUpperCase()).contentEquals(newlastname.toUpperCase());
            Assert.assertTrue(change);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user click on change password {string}")
    public void user_click_on_change_password(String actual_password) {
        try {
            // waitForElementToBeClickable(By.id("user-dropdown"));
            // driver.findElement(By.id("user-dropdown")).click();
            // driver.findElement(By.id("testLogout")).click();
            initializeChromeDriver();
            waitForVisibilityOfElement(By.id("email"));
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id(
                    "password"));
            WebElement loginButton = driver.findElement(By.id("testLogin"));
            emailField.sendKeys("azizaouadi12@gmail.com");
            passwordField.sendKeys(actual_password);
            loginButton.click();
            waitForVisibilityOfElement(By.id("user-dropdown"));

            driver.findElement(By.id("user-dropdown")).click();

            driver.findElement(By.id("account-nav")).click();

            waitForVisibilityOfElement(By.id("changePwLink"));
            driver.findElement(By.id("changePwLink")).click();
            Thread.sleep(50);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on change password")
    public void user_click_on_change_password() {
        waitForVisibilityOfElement(By.id("changePwLink"));
        driver.findElement(By.id("changePwLink")).click();

    }

    @And("user fill his actuel password {string}")
    public void user_fill_his_acutuel_password(String actuel_password) {

        waitForVisibilityOfElement(By.id("oldPwd"));
        driver.findElement(By.id("oldPwd")).sendKeys(actuel_password);
    }

    @And("user fill his new password {string}")
    public void user_fill_his_new_password(String new_password) {

        driver.findElement(By.id("newPwd")).sendKeys(new_password);
    }

    @And("user confirm password {string}")
    public void user_confirm_password(String confirm_password) {

        driver.findElement(By.id("confirmPwd")).sendKeys(confirm_password);
    }

    @And("user click on confirm button")
    public void user_click_on_confirm_button() {
        driver.findElement(By.id("change-pw-btn")).click();
    }

    @And("user logout")
    public void user_logout() {
        try {
            Thread.sleep(10000);
            waitForElementToBeClickable(By.id("user-dropdown"));
            driver.findElement(By.id("user-dropdown")).click();
            driver.findElement(By.id("testLogout")).click();
            Thread.sleep(60);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user can connect with new credentials email {string} and password {string}")
    public void user_can_connect_with_new_credentials(String email, String password) {
        try {

            waitForVisibilityOfElement(By.id("email"));

            driver.findElement(By.id("email")).sendKeys(email);
            Thread.sleep(10);
            driver.findElement(By.id("password")).sendKeys(password);
            Thread.sleep(10);
            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
            waitForElementToBeClickable(By.id("user-dropdown"));

            boolean f = true;

            String current_url = driver.getCurrentUrl();
            if (current_url.contentEquals("https://uwas.fr/login")) {
                f = false;

            }
            Assert.assertTrue(f);
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear")
    public void an_error_message_appear() {
        Assert.assertTrue(driver.findElement(By.id("oldPwd")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("newPwd")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("confirmPwd")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("change-pw-btn")).isDisplayed());

        driver.quit();

    }

}
