package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

public class account {
    Driver driver;
    String firstname;
    String lastname;

    public account(Driver driver) {
        // System.out.println(System.getProperty("environment"));
        this.driver = driver;
        this.firstname = addRandomCharacter("firstname");
        this.lastname = addRandomCharacter("lastname");
        this.driver.setupController();

    }

    private void waitForVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    @Given("user should navigate to the website of uwas")
    public void user_should_navigate_to_the_website() {
        try {
            WebDriverManager.chromedriver().setup();
            /*
             * this.driver = new ChromeDriver();
             * this.driver.manage().window().maximize();
             */
            // System.out.println(this.driver.getBaseUrl());
            this.driver.getWebDriver().get(this.driver.getBaseUrl() + "/login");
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user fill email as {string} and password as {string} and click on the button of login")
    public void user_fill_email_and_password_and_click_on_login(String email, String password) {
        try {

            waitForVisibilityOfElement(By.id("email"));

            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user should click on account")
    public void user_should_click_on_account() {
        try {
            waitForVisibilityOfElement(By.id("user-dropdown"));

            this.driver.getWebDriver().findElement(By.id("user-dropdown")).click();
            Thread.sleep(10);

            this.driver.getWebDriver().findElement(By.id("account-nav")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user edit his first name")
    public void user_edit_his_first_name() {
        waitForVisibilityOfElement(By.id("firstName"));
        WebElement First_name = this.driver.getWebDriver().findElement(By.id("firstName"));
        First_name.sendKeys(Keys.CONTROL, "a");
        First_name.sendKeys(Keys.DELETE);
        First_name.sendKeys(this.firstname);

    }

    @And("user edit his first name {string}")
    public void user_edit_his_first_name(String first_name) {
        waitForVisibilityOfElement(By.id("firstName"));
        WebElement First_name = this.driver.getWebDriver().findElement(By.id("firstName"));
        First_name.sendKeys(Keys.CONTROL, "a");
        First_name.sendKeys(Keys.DELETE);
        First_name.sendKeys(first_name);
    }

    @And("user click on edit button")
    public void user_click_on_edit() {
        try {

            this.driver.getWebDriver().findElement(By.id("edit-btn")).click();
            Thread.sleep(40);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("first name should be changed")
    public void first_name_should_be_changed() {
        try {
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("firstName"));

            String newfirstname = driver.getWebDriver().findElement(By.id("firstName")).getAttribute("value");

            boolean change = (this.firstname.toUpperCase()).contentEquals(newfirstname.toUpperCase());
            Assert.assertTrue(change);

            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("the first name does not change to {string}")
    public void the_first_name_does_not_change(String first_name) {
        try {
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("firstName"));

            String newfirstname = driver.getWebDriver().findElement(By.id("firstName")).getAttribute("value");
            // System.out.println(first_name);
            // System.out.println(newfirstname);

            boolean change = (first_name.toUpperCase()).contentEquals(newfirstname.toUpperCase());
            Assert.assertFalse(change);

            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user edit his last name")
    public void user_edit_his_last_name() {

        waitForVisibilityOfElement(By.id("lastName"));

        WebElement Lastname = this.driver.getWebDriver().findElement(By.id("lastName"));
        Lastname.sendKeys(Keys.CONTROL, "a");
        Lastname.sendKeys(Keys.DELETE);
        Lastname.sendKeys(this.lastname);
    }

    @Then("last name should be changed")
    public void last_name_should_be_changed() {
        try {
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("lastName"));

            String newlastname = driver.getWebDriver().findElement(By.id("lastName")).getAttribute("value");

            boolean change = (this.lastname.toUpperCase()).contentEquals(newlastname.toUpperCase());
            Assert.assertTrue(change);

            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user edit his last name {string}")
    public void user_edit_his_last_name(String last_name) {

        waitForVisibilityOfElement(By.id("lastName"));

        WebElement Lastname = this.driver.getWebDriver().findElement(By.id("lastName"));
        Lastname.sendKeys(Keys.CONTROL, "a");
        Lastname.sendKeys(Keys.DELETE);
        Lastname.sendKeys(last_name);
    }

    @Then("the last name does not change to {string}")
    public void the_last_name_does_not_change(String last_name) {
        try {
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(20);
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("lastName"));

            String newlastname = driver.getWebDriver().findElement(By.id("lastName")).getAttribute("value");
            // System.out.println(last_name);
            // System.out.println(newlastname);

            boolean change = (last_name.toUpperCase()).contentEquals(newlastname.toUpperCase());
            Assert.assertFalse(change);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on change password")
    public void user_click_on_change_password() {
        try {

            waitForVisibilityOfElement(By.id("changePwLink"));
            this.driver.getWebDriver().findElement(By.id("changePwLink")).click();
            Thread.sleep(50);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user fill his actuel password {string}")
    public void user_fill_his_acutuel_password(String actuel_password) {

        waitForVisibilityOfElement(By.id("oldPwd"));
        this.driver.getWebDriver().findElement(By.id("oldPwd")).sendKeys(actuel_password);
    }

    @And("user fill his new password {string}")
    public void user_fill_his_new_password(String new_password) {

        this.driver.getWebDriver().findElement(By.id("newPwd")).sendKeys(new_password);
    }

    @And("user confirm password {string}")
    public void user_confirm_password(String confirm_password) {

        this.driver.getWebDriver().findElement(By.id("confirmPwd")).sendKeys(confirm_password);
    }

    @And("user click on confirm button")
    public void user_click_on_confirm_button() {
        this.driver.getWebDriver().findElement(By.id("change-pw-btn")).click();
    }

    @And("user logout")
    public void user_logout() {
        try {
            Thread.sleep(10000);
            waitForElementToBeClickable(By.id("user-dropdown"));
            this.driver.getWebDriver().findElement(By.id("user-dropdown")).click();
            this.driver.getWebDriver().findElement(By.id("testLogout")).click();
            Thread.sleep(60);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user can connect with new credentials email {string} and password {string}")
    public void user_can_connect_with_new_credentials(String email, String password) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(Keys.ENTER);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-dropdown")));

            boolean f = true;

            String current_url = this.driver.getWebDriver().getCurrentUrl();
            if (current_url.contentEquals("https://recette.uwas.fr/login")) {
                f = false;

            }
            Assert.assertTrue(f);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear")
    public void an_error_message_appear() {
        Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("oldPwd")).isDisplayed());
        Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("newPwd")).isDisplayed());
        Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("confirmPwd")).isDisplayed());
        Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("change-pw-btn")).isDisplayed());

        this.driver.getWebDriver().quit();
    }
}
