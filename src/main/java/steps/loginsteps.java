package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginsteps {
    WebDriver driver ;

    @Given("user should navigate to the website")
    public void user_should_navigate_to_the_website() {
        try {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(10000);





        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @When("user write email as {string} and password as {string} and click on login")
    public void user_write_email_and_password_and_click_on_login(String email , String password) {
        try {

            driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {
        try {

            Thread.sleep(5000);
            Assert.assertTrue(driver.findElement(By.cssSelector("#root > div > div > header > div.header__logo-wrapper > span > div")).isDisplayed());
            Thread.sleep(2000);
            driver.quit();
            }



        catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
    @Then("error message should appear")
    public void error_message_should_appear() {
        try {
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.id("normal_login_email")).isDisplayed());
            Thread.sleep(2000);
            driver.quit();


        }catch (InterruptedException e) {
            throw new RuntimeException(e);

    }
    }
}
