package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class forget_password_steps {
    WebDriver driver;


    @Given("user open the website and click on forget password")
    public void user_open_the_website_and_click_on_forget_password() {
        try {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            driver.findElement(By.linkText("Forgot Password?")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @When("user write email as {string}")
    public void user_write_email(String email) {
        try {
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user confirm the email")
    public void user_confirm_the_email() {
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("testResetPW")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user visit the mail and click on the link")
    public void user_visit_the_mail_and_click_on_the_link() {
        try {
            Thread.sleep(5000);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.navigate().to("https://www.google.com/intl/fr/gmail/about/");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
            driver.findElement(By.id("identifierId")).sendKeys("a.aouadi@coral-io.fr");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
            Thread.sleep(3000);
            driver.findElement(By.name("Passwd")).sendKeys("Aziz1996@");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
            Thread.sleep(5000);
            WebElement unreadEmail = driver.findElement(By.className("zE"));
            unreadEmail.click();
            Thread.sleep(2000);
            WebElement link = driver.findElement(By.partialLinkText("https://recette.uwas.fr/change-password/"));
            driver.get(link.getText());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user write password as {string}")
    public void user_write_password(String password) {
        try {
            Thread.sleep(15000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user write confirm_password as {string}")
    public void user_write_confirm_password(String confirm_password) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_confirmPassword")).sendKeys(confirm_password);
            Thread.sleep(2000);
            driver.findElement(By.id("testChangePW")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the password is changed user can login with new password as {string} and email as {string}")
    public void the_password_is_changed_user_can_login_with_new_password_and_email(String password, String email) {
        try {
            Thread.sleep(10000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(3000);
            driver.findElement(By.id("testLogin")).click();
            Thread.sleep(10000);
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


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() {
        try {
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.id("normal_login_email")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.id("testResetPW")).isDisplayed());
            Thread.sleep(2000);
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the password is not changed and an error message appear")
    public void the_password_is_not_changed_and_an_error_message_appear() {
        try {
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.id("normal_login_password")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.id("normal_login_confirmPassword")).isDisplayed());
            Thread.sleep(2000);
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
}
