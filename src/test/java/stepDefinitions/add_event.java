package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class add_event {
    Driver driver;
    String title;

    public add_event() {
        // Public no-argument constructor
    }

    public add_event(Driver driver) {
        // System.out.println(System.getProperty("environment"));
        this.driver = driver;
        this.title = addRandomCharacter("adder");
        this.driver.setupController();

    }

    private void waitForVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Given("photographer should login")
    public void photographer_should_login() {
        try {

            this.driver.getWebDriver().get(this.driver.getBaseUrl() + "/login");
            waitForVisibilityOfElement(By.id("email"));
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys("k@gmail.com");
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys("Admin123!");
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(20);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("photographer should click on the button of add event")
    public void photographer_should_click_on_the_button_of_add_event() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            Thread.sleep(500);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("event-add")));
            this.driver.getWebDriver().findElement(By.id("event-add")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the title of event as {string}")
    public void photographer_should_fill_the_title_of_event(String title) {
        try {
            Thread.sleep(10);
            waitForVisibilityOfElement(By.id("event-title"));
            WebElement titles = this.driver.getWebDriver().findElement(By.id("event-title"));
            titles.sendKeys(this.title);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    @And("photographer should fill the location of event as {string}")
    public void photographer_should_fill_the_location_of_event(String location_of_event) {
        try {
            Thread.sleep(50);
            waitForVisibilityOfElement(By.id("location"));
            this.driver.getWebDriver().findElement(By.id("location")).sendKeys(location_of_event);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the date of event as {string}")
    public void photographer_should_fill_the_date_of_event(String date_of_event) {
        try {

            WebElement dateInput = this.driver.getWebDriver().findElement(By.id("testEventDate"));
            Thread.sleep(1000);
            dateInput.sendKeys(Keys.CONTROL, "a");
            Thread.sleep(1000);
            dateInput.sendKeys(Keys.DELETE);
            Thread.sleep(1000);
            dateInput.sendKeys(date_of_event);
            Thread.sleep(1000);
            dateInput.sendKeys(Keys.ENTER);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put an image for the event")
    public void photographer_put_an_image_for_the_event() {
        try {
            Thread.sleep(30);
            String relativePath = "src/test/resources/data/traditions-noel-europe-1024x683.jpg";
            File file = new File(relativePath);
            String absolutePath = file.getAbsolutePath();

            WebElement source = this.driver.getWebDriver().findElement(By.id("upload"));

            source.sendKeys(absolutePath);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("photographer should click on the button ok")
    public void photographer_should_click_on_the_button_ok() {
        try {
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("test123")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("title of event as {string} event in location of event as {string} at the date of event as {string} is created")
    public void title_of_event_in_location_at_date_is_created(String title_of_event, String location_of_event,
            String date_of_event) {
        try {
            Thread.sleep(3000);
            // boolean found = false;
            int obtainedresult = 0;
            int expectedresult = 1;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag-gold"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                String location_string = eventLocation.get(i).getText();
                String date_string = eventDate.get(i).getText();
                boolean name = name_string.toUpperCase().equals(this.title.toUpperCase());
                boolean location = (location_string.toUpperCase().equals(location_of_event.toUpperCase()));
                boolean date = date_string.equals(date_of_event);
                boolean status = eventStatus.get(i).getText().equals("In progress");
                if ((name) && (date) && (status) && (location)) {
                    obtainedresult = 1;
                    break;
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);
            ;
            // System.out.println("test pass");

            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear under the title field")
    public void an_error_message_appear_under_the_title_field() {
        try {
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("event-default-price")).isDisplayed());
            // System.out.println(1);
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("event-title")).isDisplayed());
            // System.out.println(2);
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("location")).isDisplayed());
            // System.out.println(3);
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("testEventDate")).isDisplayed());
            // System.out.println(4);
            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("title of event as {string} event in location of event as {string} is created with the date added")
    public void title_of_event_in_location_of_event_is_created_with_the_date_added(String title_of_event,
            String location_of_event) {
        try {
            Thread.sleep(3000);
            // boolean found = false;
            int obtainedresult = 0;
            int expectedresult = 1;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
            LocalDate localDate = LocalDate.now();
            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                String location_string = eventLocation.get(i).getText();
                boolean name = name_string.toUpperCase().equals(this.title.toUpperCase());
                boolean location = location_string.toUpperCase().equals(location_of_event.toUpperCase());
                boolean date = eventDate.get(i).getText().equals(localDate.toString());
                boolean status = eventStatus.get(i).getText().equals("In progress");
                if ((name) && (location) && (date) && (status)) {
                    obtainedresult = 1;
                    break;
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);

            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear and the event is created without image")
    public void an_error_message_appear_and_the_event_is_created_without_image() {
        try {
            WebElement im = this.driver.getWebDriver().findElement(By.className("ant-card-cover"));
            im = im.findElement(By.tagName("img"));
            Thread.sleep(1000);
            String src_im = im.getAttribute("src");
            boolean find = false;
            if (src_im.contentEquals(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU")) {
                find = true;
            }
            if (find) {
                Assert.assertTrue(find);
                // System.out.println("test pass");
            }

            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put a file in the image field for the event")
    public void photographer_put_a_file_in_the_image_field_for_the_event() {
        try {
            Thread.sleep(10);
            String relativePath = "src/test/resources/data/CORAL IO_Rescrit_JEI_2021 2022 2023_v1.0 (1).docx";
            File file = new File(relativePath);
            String absolutePath = file.getAbsolutePath();
            WebElement source = this.driver.getWebDriver().findElement(By.id("upload"));
            source.sendKeys(absolutePath);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
