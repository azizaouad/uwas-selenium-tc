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
import org.openqa.selenium.chrome.ChromeDriver;
import shared.Controller;

import java.time.Duration;

public class scenario_steps {
    WebDriver driver;

    public scenario_steps(Controller controller) {
        this.driver = controller.getDriver();
    }

    @Then("photographer should logout")
    public void photographer_should_logout() {
        try {
            Thread.sleep(5000);
            this.driver.findElement(By.className("anticon-down")).click();
            Thread.sleep(4000);
            this.driver.findElement(By.id("testLogout")).click();
            Thread.sleep(5000);
            boolean bol = false;
            String Current_url = this.driver.getCurrentUrl();
            String expected_url = "https://recette.uwas.fr/login";
            if (Current_url.contentEquals(expected_url)) {
                bol = true;
            }
            Assert.assertTrue(bol);
            Thread.sleep(2000);
            this.driver.quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("user upload some photos")
    public void user_upload_some_photos() {
        try {
            Thread.sleep(2000);
            WebElement upload_button = this.driver.findElement(By.xpath("/html/body/div[1]/div/main/section[1]/div/div[2]/button"));
            Thread.sleep(2000);
            upload_button.click();
            Thread.sleep(5000);
            upload_button.sendKeys("C://Users/Lenovo/Desktop/Nouveau dossier/qa@gmail.com/a (1).jpg");
            upload_button.sendKeys("/Users/Lenovo/Desktop/Nouveau dossier/qa@gmail.com/a (2).jpg");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("the photos are uploaded")
    public void the_photos_are_uploaded() {
        try {
            Thread.sleep(10000);
            boolean upload = this.driver.findElement(By.className("ant-divider-inner-text")).isDisplayed();
            if (upload) {
                System.out.println("the photos are successfully uploaded");
            } else {
                System.out.println("photos are not uploaded ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
