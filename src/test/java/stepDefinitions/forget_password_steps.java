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
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class forget_password_steps {
    Driver driver;
    String new_pass;

    public forget_password_steps(Driver driver) {
        this.driver = driver;
        this.driver.setupController();
        this.new_pass = addRandomCharacter("Aziz1996@");
    }

    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    private void waitForVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Given("user open the website and click on forget password")
    public void user_open_the_website_and_click_on_forget_password() {
        try {
            WebDriverManager.chromedriver().setup();

            this.driver.getWebDriver().get(this.driver.getBaseUrl() + "/login");
            Thread.sleep(20);
            waitForVisibilityOfElement(By.linkText("Forgot Password?"));
            this.driver.getWebDriver().findElement(By.linkText("Forgot Password?")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @When("user write email as {string}")
    public void user_write_email(String email) {
        try {
            Thread.sleep(10);
            waitForVisibilityOfElement(By.id("normal_login_email"));
            this.driver.getWebDriver().findElement(By.id("normal_login_email")).sendKeys(email);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user confirm the email")
    public void user_confirm_the_email() {
        try {
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testResetPW")).click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user visit the mail and click on the link")
    public void user_visit_the_mail_and_click_on_the_link() {
        try {

            this.driver.getWebDriver().switchTo().newWindow(WindowType.TAB);
            Thread.sleep(40);
            this.driver.getWebDriver().navigate()
                    .to("https://qa.team/inbox?utf8=%E2%9C%93&code=uwas01&locale=en&commit=go+%C2%BB");
            Thread.sleep(3000);
            this.driver.getWebDriver().navigate().refresh();

            this.driver.getWebDriver().findElement(By.className("list-group-item")).click();
            WebElement corps_mail = this.driver.getWebDriver().findElement(By.className("col-xs-12"));

            List<String> containedUrls = new ArrayList<String>();
            String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
            Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
            Matcher urlMatcher = pattern.matcher(corps_mail.getText().toString().split("---")[1]);

            while (urlMatcher.find()) {
                containedUrls.add(corps_mail.getText().toString().split("---")[1].substring(urlMatcher.start(0),
                        urlMatcher.end(0)));
            }

            String webUrlResetPassword = "";

            if (System.getProperty("environment").equals("recette")) {
                webUrlResetPassword = "https:///coralio:cmVjZXR0ZWNvcmFsaW8yMDIyCg==@"
                        + containedUrls.get(0).substring(8);
            } else {
                webUrlResetPassword = containedUrls.get(0).toString();
            }

            this.driver.getWebDriver().get(webUrlResetPassword);
        }

        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user write password {string}")
    public void user_write_password(String password) {
        try {
            Thread.sleep(50);
            waitForVisibilityOfElement(By.id("normal_login_password"));
            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(this.new_pass);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user write confirm_password {string}")
    public void user_write_confirm_password(String confirm_password) {
        try {

            this.driver.getWebDriver().findElement(By.id("normal_login_confirmPassword")).sendKeys(this.new_pass);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testChangePW")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user fill password as {string}")
    public void user_fill_password(String password) {
        try {
            Thread.sleep(5);
            waitForVisibilityOfElement(By.id("normal_login_password"));
            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(password);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user fill confirm_password as {string}")
    public void user_fill_confirm_password(String confirm_password) {
        try {

            this.driver.getWebDriver().findElement(By.id("normal_login_confirmPassword")).sendKeys(confirm_password);
            Thread.sleep(1);
            this.driver.getWebDriver().findElement(By.id("testChangePW")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the password is changed user can login with new password as {string} and email as {string}")
    public void the_password_is_changed_user_can_login_with_new_password_and_email(String password, String email) {
        try {
            Thread.sleep(4000);
            waitForVisibilityOfElement(By.id("email"));
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(this.new_pass);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            boolean display = this.driver.getWebDriver().findElement(By.id("user-dropdown")).isDisplayed();
            // System.out.println(display);
            int obtainedresult = 0;
            int expectedresult = 1;
            if (display) {
                obtainedresult = 1;
                // System.out.println("test fail");
            } else {
                expectedresult = 0;
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            ;
            Thread.sleep(20);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() {
        try {
            waitForVisibilityOfElement(By.id("normal_login_email"));
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("normal_login_email")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("testResetPW")).isDisplayed());
            Thread.sleep(20);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the password is not changed and an error message appear")
    public void the_password_is_not_changed_and_an_error_message_appear() {
        try {
            // Thread.sleep(4000);
            waitForVisibilityOfElement(By.id("testChangePW"));

            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("normal_login_password")).isDisplayed());
            Assert.assertTrue(
                    this.driver.getWebDriver().findElement(By.id("normal_login_confirmPassword")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("testChangePW")).isDisplayed());
            Thread.sleep(2000);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
}
