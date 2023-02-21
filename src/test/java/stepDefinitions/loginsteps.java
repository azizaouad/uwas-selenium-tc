package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.uwas.Driver;

public class loginsteps {
    Driver driver;

    public loginsteps(Driver driver) {
        this.driver = driver;
        this.driver.setupController("chrome");
    }

    @Given("user should navigate to the website")
    public void user_should_navigate_to_the_website() {
        try {
            WebDriverManager.chromedriver().setup();
            /*this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();*/
            this.driver.getWebDriver().get("https://coralio:cmVjZXR0ZWNvcmFsaW8yMDIyCg==@recette.uwas.fr/login");
            Thread.sleep(500);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user write email as {string} and password as {string} and click on login")
    public void user_write_email_and_password_and_click_on_login(String email , String password) {
        try {

            this.driver.getWebDriver().findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(500);
            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(500);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {
        try {

            Thread.sleep(500);
            String Current_url = this.driver.getWebDriver().getCurrentUrl() ;
            boolean login = false ;
            if (Current_url.contentEquals("https://recette.uwas.fr/login")){
                login = false ;}
            else {
                login = true;
            }
            Assert.assertTrue(login);
            Thread.sleep(500);
            this.driver.getWebDriver().quit();
            }



        catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
    @Then("error message should appear")
    public void error_message_should_appear() {
        try {
            Thread.sleep(500);
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("normal_login_email")).isDisplayed());
            Thread.sleep(500);
            this.driver.getWebDriver().quit();


        }catch (InterruptedException e) {
            throw new RuntimeException(e);

    }
    }
}
