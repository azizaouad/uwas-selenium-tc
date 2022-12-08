package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginsteps {
    @Given("user should navigate to the website")
    public void user_should_navigate_to_the_website() {
        try {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(10000);
            String title = driver.getTitle();
            System.out.println(title);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @When("user write email and password and click on login")
    public void user_write_email_and_password_and_click_on_login ()  {



    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page () {


    }

}
