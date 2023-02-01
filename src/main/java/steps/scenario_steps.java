package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class scenario_steps {
    WebDriver driver ;


    @And("photographer click on the button of add event")
    public void photographer_click_on_the_button_of_add_event (){
        try {
            Thread.sleep(10000);
            driver.findElement(By.id("testAddEvent")).click();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    @Then("photographer should logout")
    public void photographer_should_logout (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.className("anticon-down")).click();
        driver.findElement(By.id("test123")).click();


    }
}
