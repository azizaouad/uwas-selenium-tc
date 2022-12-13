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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class forget_password_steps {
    WebDriver driver;
    @Given("user open the website and click on forget password")
    public void user_open_the_website_and_click_on_forget_password () {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            driver.findElement(By.linkText("Forgot Password?")).click();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    @When("user write email as {string}")
    public void user_write_email (String email ) {
        try {
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user confirm the email")
    public void user_confirm_the_email () {
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/form/div[3]/div/div/div/div/button/span")).click();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user visit the mail and click on the link")
    public void user_visit_the_mail_and_click_on_the_link(){
        try {
            Thread.sleep(5000);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.navigate().to("https://www.google.com/search?q=gmail&oq=gmail&aqs=chrome..69i57j0i131i433j0i131i433i512l5j69i60.2112j0j7&sourceid=chrome&ie=UTF-8");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3")).click();
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
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[5]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[5]/div[1]/div/table/tbody/tr[1]/td[5]/div/div/div/span/span")).click();
            Thread.sleep(2000);
            WebElement link = driver.findElement(By.partialLinkText("https://recette.uwas.fr/change-password/"));
            Thread.sleep(5000);
            driver.get(link.getText());

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user write password as {string}")
    public void user_write_password (String password) {
        try {
            Thread.sleep(15000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user write confirm_password as {string}")
    public void user_write_confirm_password ( String confirm_password ) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_confirmPassword")).sendKeys(confirm_password);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/form/div[4]/div/div/div/div/button/span")).click();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the password is changed user can login with new password as {string} and email as {string}")
    public void the_password_is_changed_user_can_login_with_new_password_and_email (String password , String email) {
        try {
            Thread.sleep(5000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();
            Assert.assertTrue("test ok",driver.findElement(By.id("normal_login_password")).isDisplayed());

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Then("error message is displayed")
    public void error_message_is_displayed (){
        try {
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.id("normal_login_email")).isDisplayed());
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
