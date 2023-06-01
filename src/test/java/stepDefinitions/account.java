package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.uwas.Driver;

import java.security.Key;
import java.util.List;

public class account {
    Driver driver;

    public account(Driver driver) {
        System.out.println(System.getProperty("environment"));
        this.driver = driver;
        this.driver.setupController();

    }

    @Given("user should navigate to the website of uwas")
    public void user_should_navigate_to_the_website() {
        try {
            WebDriverManager.chromedriver().setup();
            /*this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();*/
            System.out.println(this.driver.getBaseUrl());
            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("user fill email as {string} and password as {string} and click on the button of login")
    public void user_fill_email_and_password_and_click_on_login(String email , String password) {
        try {

            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("user should click on account")
    public void user_should_click_on_account (){
        try {

            this.driver.getWebDriver().findElement(By.id("user-dropdown")).click();
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("account-nav")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user edit his first name {string}")
    public void user_edit_his_first_name(String first_name ){
        WebElement First_name = this.driver.getWebDriver().findElement(By.id("firstName"));
        First_name.sendKeys(Keys.CONTROL, "a");
        First_name.sendKeys(Keys.DELETE);
        First_name.sendKeys(first_name);


    }
    @And ("user click on edit button")
    public void user_click_on_edit(){
        try {

        this.driver.getWebDriver().findElement(By.id("edit-btn")).click();
        Thread.sleep(4000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("first name should be changed to {string}")
    public void first_name_should_be_changed (String first_name){
        try{
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(2000);

            String newfirstname = driver.getWebDriver().findElement(By.id("firstName")).getAttribute("value");

            boolean change = (first_name.toUpperCase()).contentEquals(newfirstname.toUpperCase());
            Assert.assertTrue(change);


            this.driver.getWebDriver().quit();
        }  catch (InterruptedException e) {
        throw new RuntimeException(e);
    }


    }
    @Then("the first name does not change to {string}")
    public void the_first_name_does_not_change (String first_name){
        try{
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(2000);

            String newfirstname = driver.getWebDriver().findElement(By.id("firstName")).getAttribute("value");
            System.out.println(first_name);
            System.out.println(newfirstname);

            boolean change = (first_name.toUpperCase()).contentEquals(newfirstname.toUpperCase());
            Assert.assertFalse(change);


            this.driver.getWebDriver().quit();
        }  catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user edit his last name {string}")
    public void user_edit_his_last_name (String last_name){
        WebElement Lastname = this.driver.getWebDriver().findElement(By.id("lastName"));
        Lastname.sendKeys(Keys.CONTROL, "a");
        Lastname.sendKeys(Keys.DELETE);
        Lastname.sendKeys(last_name);
    }
    @Then("last name should be changed to {string}")
    public void last_name_should_be_changed (String last_name){
        try{
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(2000);

            String newlastname = driver.getWebDriver().findElement(By.id("lastName")).getAttribute("value");

            boolean change = (last_name.toUpperCase()).contentEquals(newlastname.toUpperCase());
            Assert.assertTrue(change);


            this.driver.getWebDriver().quit();
        }  catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    @Then("the last name does not change to {string}")
    public void the_last_name_does_not_change (String last_name){
        try{
            this.driver.getWebDriver().navigate().refresh();
            Thread.sleep(2000);

            String newlastname = driver.getWebDriver().findElement(By.id("lastName")).getAttribute("value");
            System.out.println(last_name);
            System.out.println(newlastname);

            boolean change = (last_name.toUpperCase()).contentEquals(newlastname.toUpperCase());
            Assert.assertFalse(change);
            this.driver.getWebDriver().quit();


            this.driver.getWebDriver().quit();
        }  catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }





