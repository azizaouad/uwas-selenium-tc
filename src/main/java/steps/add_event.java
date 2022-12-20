package steps;

import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class add_event {
    WebDriver driver;


    @Given("photographer should login")
    public void photographer_should_login() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(10000);
            driver.findElement(By.id("normal_login_email")).sendKeys("azizaouadi12@gmail.com");
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("photographer should click on the button of add event")
    public void photographer_should_click_on_the_button_of_add_event() {
        try {
            Thread.sleep(7000);
            driver.findElement(By.xpath("/html/body/div[1]/div/main/section[1]/div/div[1]/h1/button/span")).click();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the title of event as {string}")
    public void photographer_should_fill_the_title_of_event(String title_of_event) {
        try {
            Thread.sleep(3000);
            driver.findElement(By.id("name")).sendKeys(title_of_event);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the location of event as {string}")
    public void photographer_should_fill_the_location_of_event(String location_of_event) {
        try {
            Thread.sleep(3000);
            driver.findElement(By.id("location")).sendKeys(location_of_event);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the date of event as {string}")
    public void photographer_should_fill_the_date_of_event(String date_of_event) {
        try {
            Thread.sleep(3000);
            WebElement dateInput = driver.findElement(By.id("date"));
            Thread.sleep(2000);
            dateInput.sendKeys(Keys.CONTROL, "a");
            Thread.sleep(3000);
            dateInput.sendKeys(Keys.DELETE);
            Thread.sleep(2000);
            dateInput.sendKeys(date_of_event);
            Thread.sleep(2000);
            dateInput.sendKeys(Keys.ENTER);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put an image for the event")
    public void photographer_put_an_image_for_the_event() {
        try {
            Thread.sleep(3000);
            WebElement source = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[5]/div/div[2]/div/div/span/div[1]/span/input"));
            source.sendKeys("C://Users/DELL/Desktop/cover-showpage-films-tv-de-noel-2022-17ffdf-a9298f-0@1x.jpg");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("photographer should click on the button ok")
    public void photographer_should_click_on_the_button_ok() {
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")).click();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("title of event as {string} event in location as {string} at date as {string} is created")
    public void title_of_event_event_in_location_at_date_is_created(String title_of_event, String location_of_event, String date_of_event) {
        try {
            AtomicBoolean found = new AtomicBoolean(false);
            List<WebElement> eventNames = driver.findElements(By.className("eventDetails__name"));
            List<WebElement> eventLocation = driver.findElements(By.className("eventDetails__location"));
            List<WebElement> eventDate = driver.findElements(By.className("eventDetails__footer-date"));
            List<WebElement> eventStatus = driver.findElements(By.className("eventDetails__status"));

            for (int i = 0; i < eventNames.size(); i++) {
                boolean name = eventNames.get(i).getText().equals(title_of_event);
                boolean location = eventLocation.get(i).getText().equals(location_of_event);
                boolean date = eventDate.get(i).getText().equals(date_of_event);
                boolean status = eventStatus.get(i).getText().equals("In progress");
                if ((name) && (location) && (date) && (status)) {
                    found.set(true);
                    break;
                }
            }
            Assert.assertTrue(found.get());
            Thread.sleep(2000);
            driver.quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear under the title field")
    public void an_error_message_appear_under_the_title_field() {
        try {
            Assert.assertTrue(driver.findElement(By.id("name")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.id("location")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.id("date")).isDisplayed());
            Thread.sleep(2000);
            driver.quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Then("title of event as {string} event in location of event as {string} is created with the date added")
    public void title_of_event_in_location_of_event_is_created_with_the_date_added(String title_of_event, String location_of_event) {
        try {
            boolean found = false;
            List<WebElement> eventNames = driver.findElements(By.className("eventDetails__name"));
            List<WebElement> eventLocation = driver.findElements(By.className("eventDetails__location"));
            List<WebElement> eventDate = driver.findElements(By.className("eventDetails__footer-date"));
            List<WebElement> eventStatus = driver.findElements(By.className("eventDetails__status"));
            LocalDate localDate = LocalDate.now();
            System.out.println("the date of today : " + localDate.toString());

            for (int i = 0; i < eventNames.size(); i++) {
                boolean name = eventNames.get(i).getText().equals(title_of_event);
                boolean location = eventLocation.get(i).getText().equals(location_of_event);
                boolean date = eventDate.get(i).getText().equals(localDate.toString());
                boolean status = eventStatus.get(i).getText().equals("In progress");
                if ((name) && (location) && (date) && (status)) {
                    found = true;
                    break;
                }
            }
            System.out.println(found);
            Assert.assertTrue(found);
            Thread.sleep(2000);
            driver.quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear and the event is created without image")
    public void an_error_message_appear_and_the_event_is_created_without_image() {
        try {
            WebElement im = driver.findElement(By.className("ant-card-cover"));
            im = im.findElement(By.tagName("img"));
            Thread.sleep(3000);
            System.out.println(im.getTagName());
            String src_im = im.getAttribute("src");
            System.out.printf(src_im);
            boolean find = false ;
            if (src_im.contentEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU")){
                find = true ;
            }
            Assert.assertTrue(find);
            Thread.sleep(2000);
            driver.quit();


        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put a file in the image field for the event")
    public void photographer_put_a_file_in_the_image_field_for_the_event() {
        try {
            Thread.sleep(3000);
            WebElement source = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[5]/div/div[2]/div/div/span/div[1]/span/input"));
            source.sendKeys("C://Users/DELL/Desktop/paiement.docx");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}



     