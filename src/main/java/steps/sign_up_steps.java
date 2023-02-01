package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sign_up_steps {
    WebDriver driver;

    @Given("user open the website and click on sign up now")
    public void user_open_the_website_and_click_on_sign_up_now() {
        try {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(10000);
            driver.findElement(By.linkText("Sign up now!")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user fill first_name as {string}")
    public void user_fill_first_name(String first_name) {

        try {
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_first_name")).sendKeys(first_name);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        }



    @And("user fill last_name as {string}")
    public void user_fill_last_name(String last_name) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_last_name")).sendKeys(last_name);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user fill email as {string}")
    public void user_fill_email(String email) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @And("user fill password as {string}")
    public void user_fill_password ( String password ) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

}
    @And("user fill confirm_password as {string}")
    public void user_fill_confirm_password ( String confirm_password ) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_confirmPassword")).sendKeys(confirm_password);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
    @And("user click on the captcha")
    public void user_click_on_the_captcha (  ) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.name("captcha")).click();
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
    @And("user click on sign up")
    public void user_click_on_sign_up () {
        try {
            Thread.sleep(4000);
            driver.findElement(By.id("testRegister")).click();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
    @Then("user have an account he can login with this credentials email as {string} and password as {string}")
    public void user_have_an_account_he_can_login_with_this_credentials_email_and_password ( String email , String password) {
        try {
            Thread.sleep(8000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.id("testLogin")).click();
            Thread.sleep(5000);
            String Current_url = driver.getCurrentUrl() ;
            boolean login = false ;
            if (Current_url.contentEquals("https://recette.uwas.fr/login")){
                login = false ;}
            else {
                login = true;
            }
            Assert.assertTrue(login);
            Thread.sleep(2000);
            driver.quit();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
    @Then("user fail to create an account")
    public void user_fail_to_create_an_account (){
        try {
            Thread.sleep(3000);
            Assert.assertTrue(driver.findElement(By.id("normal_login_confirmPassword")).isDisplayed());
            Thread.sleep(2000);
            driver.quit();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}

