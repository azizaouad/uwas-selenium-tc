package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.uwas.Driver;

public class forget_password_steps {
    Driver driver;

    public forget_password_steps(Driver driver) {
        this.driver = driver;
        this.driver.setupController();
    }


    @Given("user open the website and click on forget password")
    public void user_open_the_website_and_click_on_forget_password() {
        try {

            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.linkText("Forgot Password?")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @When("user write email as {string}")
    public void user_write_email(String email) {
        try {
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("normal_login_email")).sendKeys(email);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user confirm the email")
    public void user_confirm_the_email() {
        try {
            Thread.sleep(1);
            this.driver.getWebDriver().findElement(By.id("testResetPW")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user visit the mail and click on the link")
    public void user_visit_the_mail_and_click_on_the_link() {
        try {

            this.driver.getWebDriver().switchTo().newWindow(WindowType.TAB);
            this.driver.getWebDriver().navigate().to("https://www.google.com/intl/fr/gmail/about/");
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
            this.driver.getWebDriver().findElement(By.id("identifierId")).sendKeys("a.aouadi@coral-io.fr");
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.name("Passwd")).sendKeys("Aziz1996@");
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
            Thread.sleep(2000);
            WebElement unreadEmail = this.driver.getWebDriver().findElement(By.className("zE"));
            unreadEmail.click();
            WebElement link = this.driver.getWebDriver().findElement(By.partialLinkText("https://recette.uwas.fr/change-password/"));
            this.driver.getWebDriver().get(link.getText());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user write password as {string}")
    public void user_write_password(String password) {
        try {
            Thread.sleep(5000);
            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(password);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user write confirm_password as {string}")
    public void user_write_confirm_password(String confirm_password) {
        try {

            this.driver.getWebDriver().findElement(By.id("normal_login_confirmPassword")).sendKeys(confirm_password);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testChangePW")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the password is changed user can login with new password as {string} and email as {string}")
    public void the_password_is_changed_user_can_login_with_new_password_and_email(String password, String email) {
        try {
            Thread.sleep(4000);
            this.driver.getWebDriver().findElement(By.id("normal_login_email")).sendKeys(email);

            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(password);

            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(4000);
            String Current_url = this.driver.getWebDriver().getCurrentUrl() ;
            boolean login = false ;
            if (Current_url.contentEquals("https://recette.uwas.fr/login")){
                login = false ;}
            else {
                login = true;
            }
            Assert.assertTrue(login);
            Thread.sleep(100);
            this.driver.getWebDriver().quit();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() {
        try {
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("normal_login_email")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("testResetPW")).isDisplayed());
            Thread.sleep(100);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the password is not changed and an error message appear")
    public void the_password_is_not_changed_and_an_error_message_appear() {
        try {

            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("normal_login_password")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("normal_login_confirmPassword")).isDisplayed());
            Thread.sleep(100);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
}
