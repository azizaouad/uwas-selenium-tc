package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import shared.Controller;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class archive_event {
    WebDriver driver ;
    Controller controller;

    public archive_event(Controller controller) {
        this.controller = controller;
        this.controller.setupController();
        this.driver = this.controller.getDriver();
    }
    @Given("photographer should login with his credentials email as {string} and password as {string} and create an event title as {string}")
    public void photographer_should_login_with_his_credentials_email_and_password ( String email , String password, String title) {
        try {
            this.driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            this.driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(3000);
            this.driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(3000);
            this.driver.findElement(By.id("testLogin")).click();
            Thread.sleep(7000);
            this.driver.findElement(By.id("testAddEvent")).click();
            Thread.sleep(3000);
            this.driver.findElement(By.id("name")).sendKeys(title);
            Thread.sleep(3000);
            this.driver.findElement(By.id("test123")).click();
            Thread.sleep(8000);
    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @When("photographer click on the three buttouns")
    public void photographer_click_on_the_three_buttouns_of_the_event_he_wants_to_archive (){


    }

    @And("Choose archive")
    public void Choose_archive (){
        try {
            Thread.sleep(2000);
//            WebElement ele = driver.findElement(By.className("ant-btn-icon-only"));
//            Actions action = new Actions(driver);
//            Thread.sleep(2000);
//            action.moveToElement(ele).build().perform();
           Thread.sleep(5000);
            //driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[2]/div/div/div[7]/div[2]/div[1]/button[2]/span/svg")).click();
           WebElement points=this.driver.findElement(By.className("ant-btn-icon-only"));
           points.click();
           Thread.sleep(2000);
           driver.findElement(By.id("testArchive")).click();
           Thread.sleep(2000);
           driver.findElement(By.id("testOKArchive")).click();
           Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the event as {string} is archived")
    public void the_event_is_archived (String title) {
        boolean found = false;
        List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
        List<WebElement> eventLocation = this.driver.findElements(By.className("eventDetails__bottom-location-text"));
        List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
        List<WebElement> eventStatus = this.driver.findElements(By.className("ant-tag"));
        LocalDate localDate = LocalDate.now();
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText() ;
            String date_string = eventDate.get(i).getText();
            System.out.println(name_string);
            boolean name = name_string.toUpperCase().equals(title.toUpperCase());
            boolean date = date_string.equals(localDate.toString());
            if ((name) && (date) ) {
                found = true;
                break;
            }
        }
        Assert.assertFalse(found);
        this.driver.quit();
    }

    @When("photographer should go to the archive event")
    public void photographer_should_go_to_the_archive_event (){
        try {
            Thread.sleep(3000);
            List<WebElement> events = this.driver.findElements(By.className("anticon-down"));
            events.get(1).click();
            Thread.sleep(3000);
            this.driver.findElement(By.className("ant-dropdown-menu-title-content")).click();
            Thread.sleep(2000);


        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    @And("Choose restore for the event {string}")
    public void Choose_restore_for_the_event (String event) {
        try {
            boolean res = false ;
            System.out.println(res);
            List <WebElement> points = this.driver.findElements(By.className("anticon-ellipsis"));
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventLocation = this.driver.findElements(By.className("eventDetails__bottom-location-text"));
            List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            LocalDate localDate = LocalDate.now();
            for ( int i =0 ; i<eventNames.size() ; i++ ) {
                String name_string = eventNames.get(i).getText() ;
                String date_string = eventDate.get(i).getText();
                System.out.println(name_string);
                boolean name = name_string.toUpperCase().equals(event.toUpperCase());
                boolean date = date_string.equals(localDate.toString());
                if ((name)&&(date)){
                    res = true ;
                    Thread.sleep(2000);
                    points.get(i+1).click();
                    WebElement restore = this.driver.findElement(By.className("ant-dropdown-menu-title-content"));
                    Thread.sleep(4000);
                    restore.click();
                    Thread.sleep(2000);
                    break;
                }
            }

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the title of event as {string} is restored")
    public void the_event_is_restored (String title) {
        try {
            boolean found = false;
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventLocation = this.driver.findElements(By.className("eventDetails__bottom-location-text"));
            List<WebElement> eventDate =this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            List<WebElement> eventStatus = this.driver.findElements(By.className("ant-tag"));
            LocalDate localDate = LocalDate.now();
            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText() ;
                String date_string = eventDate.get(i).getText();
                System.out.println(name_string);
                boolean name = name_string.toUpperCase().equals(title.toUpperCase());
                boolean date = date_string.equals(localDate.toString());
                if ((name) && (date) ) {
                    found = true;
                    break;
                }
            }
            Assert.assertFalse(found);
            Thread.sleep(2000);
            this.driver.quit();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Given("photographer should login with his credentials email as {string} and password as {string}")
    public void photographer_should_login_with_his_credentials_email_and_password (String email , String password) {
        try {

            this.driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            this.driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(3000);
            this.driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(3000);
            this.driver.findElement(By.id("testLogin")).click();
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
