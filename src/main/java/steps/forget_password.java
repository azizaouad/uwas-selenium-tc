package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class forget_password {
    WebDriver driver;
    @Given("user open the website and click on forget password")
    public void user_open_the_website_and_click_on_forget_password () {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(10000);
            driver.findElement(By.linkText("Forgot Password?")).click();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    @When("user fill email as {string}")
    public void user_fill_email (String email ) {
        try {
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user confirm the mail")
    public void user_confirm_the_mail () {
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
            driver.switchTo().newWindow(WindowType.TAB);
            driver.navigate().to("https://www.google.com/search?q=gmail&oq=gmail&aqs=chrome..69i57j0i131i433j0i131i433i512l5j69i60.2112j0j7&sourceid=chrome&ie=UTF-8");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
            driver.findElement(By.id("identifierId")).sendKeys("a.aouadi@coral-io.fr");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
            Thread.sleep(3000);
            driver.findElement(By.name("password")).sendKeys("Aziz1996@");
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
            Thread.sleep(5000);
            driver.findElement(By.name("UWAS")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#\\:hu > div:nth-child(1) > div > a")).click();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user fill password as {string}")
    public void user_fill_password (String password) {
        try {
            Thread.sleep(15000);
            Set<String> handles = driver.getWindowHandles();
            List<String> ls = new ArrayList<String>(handles);
            String recette = ls.get(0);
            String mail = ls.get(1);
            String linkResetPassword = ls.get(2) ;
            driver.switchTo().window(linkResetPassword);
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("user fill confirm_password as {Aziz1996@ }")
    public void user_fill_confirm_password ( String confirm_password ) {
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
            Thread.sleep(2000);
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(15000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();
            Assert.assertFalse(driver.findElement(By.id("normal_login_password")).isDisplayed());
            Assert.assertFalse(driver.findElement(By.id("normal_login_email")).isDisplayed());

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
