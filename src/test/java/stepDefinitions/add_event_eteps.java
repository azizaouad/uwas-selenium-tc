package StepDefinitions;

import java.io.File;
import java.time.LocalDate;
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

public class add_event_eteps extends Base {

    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    String nameofevent = addRandomCharacter("addNameEvent");
    String locationofevent = addRandomCharacter("addLocationEvent");

    String dateofevent = generateRandomDate(2023, 2024);

    @Before("@addevent")
    public void clickOnTheButtonOffAddevent() {
        initializeChromeDriver();
        waitForVisibilityOfElement(By.id("email"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id(
                "password"));
        WebElement loginButton = driver.findElement(By.id("testLogin"));
        emailField.sendKeys(props.getProperty("emailphotographe"));
        passwordField.sendKeys(props.getProperty("password"));
        loginButton.click();
        waitForVisibilityOfElement(By.id("dropdown-event-link"));
        driver.findElement(By.id("dropdown-event-link")).click();
        waitForElementToBeClickable(By.id("event-add"));
        driver.findElement(By.id("event-add")).click();

    }

    @After("@addevent")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @And("photographer should fill the title of event")
    public void photographer_should_fill_the_title_of_event() {

        waitForVisibilityOfElement(By.id("event-title"));
        WebElement titles = driver.findElement(By.id("event-title"));
        titles.sendKeys(nameofevent);
        // System.out.println(nameofevent);

    }

    @And("photographer should fill the location of event")
    public void photographer_should_fill_the_location_of_event() {

        waitForVisibilityOfElement(By.id("location"));
        driver.findElement(By.id("location")).sendKeys(locationofevent);
        // System.out.println(locationofevent);

    }

    @And("photographer should fill the date of event")
    public void photographer_should_fill_the_date_of_event() {
        WebElement dateInput = driver.findElement(By.id("testEventDate"));

        dateInput.sendKeys(Keys.CONTROL, "a");

        dateInput.sendKeys(Keys.DELETE);
        // System.out.println(dateofevent);

        dateInput.sendKeys(dateofevent);

        dateInput.sendKeys(Keys.ENTER);

    }

    @And("photographer put an image for the event")
    public void photographer_put_an_image_for_the_event() {

        String relativePath = "src/test/resources/data/traditions-noel-europe-1024x683.jpg";
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();

        WebElement source = driver.findElement(By.id("upload"));

        source.sendKeys(absolutePath);
    }

    @And("photographer should click on the button ok")
    public void photographer_should_click_on_the_button_ok() {

        driver.findElement(By.id("test123")).click();

    }

    @Then("the event is created")
    public void the_event_is_created() {
        try {
            Thread.sleep(3000);
            int obtainedresult = 0;
            int expectedresult = 1;
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                // System.out.println(name_string);
                String location_string = eventLocation.get(i).getText();
                System.out.println(location_string);
                String date_string = eventDate.get(i).getText();
                // System.out.println(date_string);
                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                boolean location = (location_string.toUpperCase().equals(locationofevent.toUpperCase()));
                boolean date = date_string.equals(dateofevent);
                // System.out.println("name : " + name);
                // System.out.println("location : " + location);
                // System.out.println("date : " + date);

                if ((name) && (date) && (location)) {
                    obtainedresult = 1;
                    break;
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear under the title field")
    public void an_error_message_appear_under_the_title_field() {

        Assert.assertTrue(driver.findElement(By.id("event-default-price")).isDisplayed());
        // System.out.println(1);
        Assert.assertTrue(driver.findElement(By.id("event-title")).isDisplayed());
        // System.out.println(2);
        Assert.assertTrue(driver.findElement(By.id("location")).isDisplayed());
        // System.out.println(3);
        Assert.assertTrue(driver.findElement(By.id("testEventDate")).isDisplayed());

    }

    @Then("the event is created in location of event as {string}")
    public void event_is_created(String location_of_event) {
        try {
            Thread.sleep(3000);
            int obtainedresult = 0;
            int expectedresult = 1;
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                // System.out.println(name_string);
                String location_string = eventLocation.get(i).getText();
                // System.out.println(location_string);
                String date_string = eventDate.get(i).getText();
                // System.out.println(date_string);
                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                boolean location = (location_string.toUpperCase().equals(location_of_event.toUpperCase()));
                boolean date = date_string.equals(dateofevent);
                // System.out.println("name : " + name);
                // System.out.println("location : " + location);
                // System.out.println("date : " + date);

                if ((name) && (date) && (location)) {
                    obtainedresult = 1;
                    break;
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the event is created with the date added")
    public void the_event_is_created_today() {
        try {
            Thread.sleep(3000);
            int obtainedresult = 0;
            int expectedresult = 1;
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));
            LocalDate localDate = LocalDate.now();

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                // System.out.println(name_string);
                String location_string = eventLocation.get(i).getText();
                // System.out.println(location_string);
                String date_string = eventDate.get(i).getText();
                // System.out.println(date_string);
                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                boolean location = (location_string.toUpperCase().equals(locationofevent.toUpperCase()));
                boolean date = date_string.equals(localDate.toString());
                // System.out.println("name : " + name);
                // System.out.println("location : " + location);
                // System.out.println("date : " + date);

                if ((name) && (date) && (location)) {
                    obtainedresult = 1;
                    break;
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put a file in the image field for the event")
    public void put_a_file_in_the_image_zone() {
        String relativePath = "src/test/resources/data/TESTER.docx";
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();
        WebElement source = driver.findElement(By.id("upload"));
        source.sendKeys(absolutePath);

    }

    @Then("an error message appear and the event is created without image")
    public void an_error_message_appear_and_the_event_is_created_without_image() {
        try {
            WebElement im = driver.findElement(By.className("ant-card-cover"));
            im = im.findElement(By.tagName("img"));
            Thread.sleep(1000);
            String src_im = im.getAttribute("src");
            boolean find = false;
            if (src_im.contentEquals(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU")) {
                find = true;
            }

            Assert.assertTrue(find);
            // System.out.println("test pass");

            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}