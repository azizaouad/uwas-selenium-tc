package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.uwas.Driver;

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

            this.driver.getWebDriver().findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("user should click on account")
    public void user_should_click_on_account (){
        try {

            this.driver.getWebDriver().findElement(By.className("anticon-down")).click();
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.xpath("/html/body/div[3]/div/div/ul/li[1]")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user edit his first name {string}")
    public void user_edit_his_first_name(String first_name ){

    }
    @And ("user click on edit button")
    public void user_click_on_edit(){

    }
    @Then("first name should be changed to {string}")
    public void first_name_should_be_changed (String first_name){

    }


}
