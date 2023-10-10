package StepDefinitions;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class scenario_steps extends Base {
    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    String nameofevent = addRandomCharacter("namescenario");
    String locationofevent = addRandomCharacter("locationscenario");
    String newdate = generateRandomDate(2023, 2024);

    @Before("@scenario")
    public void goToAccount() {
        initializeChromeDriver();
        waitForVisibilityOfElement(By.id("email"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id(
                "password"));
        WebElement loginButton = driver.findElement(By.id("testLogin"));
        emailField.sendKeys(props.getProperty("emailphotographe"));
        passwordField.sendKeys(props.getProperty("password"));
        loginButton.click();

    }

    @After("@scenario")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @And("photographer click on the button of add event")
    public void photographer_should_click_on_the_button_of_add_event() {
        try {
            waitForVisibilityOfElement(By.id("dropdown-event-link"));
            driver.findElement(By.id("dropdown-event-link")).click();
            Thread.sleep(20);
            waitForVisibilityOfElement(By.id("event-add"));
            driver.findElement(By.id("event-add")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer fill the title of event")
    public void photographer_should_fill_the_title_of_event() {

        waitForVisibilityOfElement(By.id("event-title"));
        driver.findElement(By.id("event-title")).sendKeys(nameofevent);

    }

    @And("photographer fill the location of event")
    public void photographer_should_fill_the_location_of_event() {

        driver.findElement(By.id("location")).sendKeys(locationofevent);

    }

    @And("photographer fill the date of event")
    public void photographer_should_fill_the_date_of_event() {
        try {

            WebElement dateInput = driver.findElement(By.id("testEventDate"));
            Thread.sleep(10);
            dateInput.sendKeys(Keys.CONTROL, "a");
            Thread.sleep(10);
            dateInput.sendKeys(Keys.DELETE);
            Thread.sleep(10);
            dateInput.sendKeys(newdate);
            Thread.sleep(10);
            dateInput.sendKeys(Keys.ENTER);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put an image")
    public void photographer_put_an_image_for_the_event() {
        try {
            Thread.sleep(10);
            String relativePath = "src/test/resources/data/traditions-noel-europe-1024x683.jpg";
            File file = new File(relativePath);
            String absolutePath = file.getAbsolutePath();
            WebElement source = driver.findElement(By.id("upload"));
            source.sendKeys(absolutePath);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("photographer should click on the ok button")
    public void photographer_should_click_on_the_button_ok() {
        try {
            Thread.sleep(10);
            driver.findElement(By.id("test123")).click();
            // Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("this event is created")
    public void title_of_event_in_location_at_date_is_created() {
        try {
            Thread.sleep(3000);
            boolean found = false;
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));
            List<WebElement> eventStatus = driver.findElements(By.className("ant-tag-gold"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                String location_string = eventLocation.get(i).getText();
                String date_string = eventDate.get(i).getText();
                String status_string = eventStatus.get(i).getText();
                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                boolean location = location_string.toUpperCase().equals(locationofevent.toUpperCase());
                boolean date = date_string.equals(newdate);
                boolean status = status_string.equals("In progress");
                // System.out.println(name_string+ location_string+ date_string+ status_string);
                if ((name) && (date) && (status) && (location)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("photographer should logout")
    public void photographer_should_logout() {
        try {
            Thread.sleep(4000);
            driver.findElement(By.id("user-dropdown")).click();
            Thread.sleep(10);
            driver.findElement(By.id("testLogout")).click();
            Thread.sleep(10);
            boolean bol1 = false;
            boolean bol2 = false;
            waitForVisibilityOfElement(By.id("email"));
            bol1 = driver.findElement(By.id("email")).isDisplayed();
            bol2 = driver.findElement(By.id("password")).isDisplayed();
            Assert.assertTrue(bol1);
            Assert.assertTrue(bol2);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user upload some photos")
    public void user_upload_some_photos() {
        try {
            // Thread.sleep(4000);
            waitForVisibilityOfElement(By.id("testUpload"));
            WebElement upload_button = driver.findElement(By.id("testUpload"));
            // Thread.sleep(2000);
            upload_button.click();
            String relativePath = "src/test/resources/data/traditions-noel-europe-1024x683.jpg";
            File file = new File(relativePath);
            String absolutePath = file.getAbsolutePath();
            // Thread.sleep(5000);
            WebElement source = driver.findElement(By.id("upload-photos"));
            Thread.sleep(30);
            source.sendKeys(absolutePath);
            driver.findElement(By.xpath("//button[@type='submit']")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("the photos are uploaded")
    public void the_photos_are_uploaded() {
        try {
            Thread.sleep(10);
            waitForVisibilityOfElement(By.className("ant-divider-inner-text"));
            boolean upload = driver.findElement(By.className("ant-divider-inner-text"))
                    .isDisplayed();
            if (upload) {
                System.out.println("the photos are successfully uploaded");
                driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button"))
                        .click();

            } else {
                System.out.println("photos are not uploaded ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
