package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.uwas.Driver;

public class scenario_steps {
    Driver driver;

    public scenario_steps(Driver driver) {
        this.driver = driver;
        this.driver.setupController("chrome");
    }

    @Then("photographer should logout")
    public void photographer_should_logout() {
        try {
            Thread.sleep(5000);
            this.driver.getWebDriver().findElement(By.className("anticon-down")).click();
            Thread.sleep(4000);
            this.driver.getWebDriver().findElement(By.id("testLogout")).click();
            Thread.sleep(5000);
            boolean bol = false;
            String Current_url = this.driver.getWebDriver().getCurrentUrl();
            String expected_url = "https://recette.uwas.fr/login";
            if (Current_url.contentEquals(expected_url)) {
                bol = true;
            }
            Assert.assertTrue(bol);
            Thread.sleep(2000);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("user upload some photos")
    public void user_upload_some_photos() {
        try {
            Thread.sleep(2000);
            WebElement upload_button = this.driver.getWebDriver().findElement(By.xpath("/html/body/div[1]/div/main/section[1]/div/div[2]/button"));
            Thread.sleep(2000);
            upload_button.click();
            Thread.sleep(5000);
            System.out.println("1");
            WebElement source = this.driver.getWebDriver().findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form"));
            System.out.println("2");
            Thread.sleep(3000);
            source.sendKeys("C://Users//Lenovo//Downloads//wetransfer_20230109_161332-jpg_2023-01-09_1514//12345678 (24).jpg");
            System.out.println("3");
            /*
            source.sendKeys("C://Users//Lenovo//Downloads//test.png");
            System.out.println("3");
            source.sendKeys("C:/Users/Lenovo/Desktop/Nouveau dossier/qa@gmail.com/a (2).jpg");
            System.out.println("4");
            Thread.sleep(4000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div/div/div/button")).click();*/
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("the photos are uploaded")
    public void the_photos_are_uploaded() {
        try {
            Thread.sleep(10000);
            boolean upload = this.driver.getWebDriver().findElement(By.className("ant-divider-inner-text")).isDisplayed();
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
