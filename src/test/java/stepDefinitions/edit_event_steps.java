package stepDefinitions;

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

public class edit_event_steps extends Base {
    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    String nameofevent = addRandomCharacter("nameToEdit");
    String newnameofevent = addRandomCharacter(nameofevent);
    String locationofevent = addRandomCharacter("locationToEdit");
    String newlocationofevent = addRandomCharacter(locationofevent);
    String newdate = generateRandomDate(2023, 2024);

    @Before("@edit")
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
        waitForVisibilityOfElement(By.id("dropdown-event-link"));
        driver.findElement(By.id("dropdown-event-link")).click();
        waitForElementToBeClickable(By.id("event-add"));
        driver.findElement(By.id("event-add")).click();
        waitForVisibilityOfElement(By.id("event-title"));

        WebElement event = driver.findElement(By.id("event-title"));
        event.sendKeys(nameofevent);
        driver.findElement(By.id("location")).sendKeys(locationofevent);
        driver.findElement(By.id("test123")).click();

    }

    @After("@edit")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @And("photographer click on the three buttouns for updating")
    public void three_buttons() {
        try {
            Thread.sleep(3000);
            List<WebElement> points = driver.findElements(By.id("event-edit-dropdown"));
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));
            LocalDate localDate = LocalDate.now();
            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                String date_string = eventDate.get(i).getText();
                // System.out.println(name_string);
                // System.out.println(date_string);
                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                boolean date = date_string.equals(localDate.toString());
                if ((date) && (name)) {
                    points.get(i).click();

                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("photographer choose edit")
    public void choose_edit() {
        waitForVisibilityOfElement(By.id("testEdit"));

        driver.findElement(By.id("testEdit")).click();
        ;
    }

    @And("photographer should change the title of event")
    public void change_name_of_event() {
        waitForVisibilityOfElement(By.id("event-title"));

        WebElement titles = driver.findElement(By.id("event-title"));
        titles.sendKeys(Keys.CONTROL, "a");
        titles.sendKeys(Keys.DELETE);
        titles.sendKeys(newnameofevent);

        // driver.findElement(By.id("test123")).click();

    }

    @Then("title of event is updated")
    public void title_is_updated() {
        try {
            Thread.sleep(3000);

            int obtainedresult = 0;
            int expectedresult = 1;
            LocalDate localDate = LocalDate.now();

            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));

            List<WebElement> eventDate = driver.findElements(By.id("event-date"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();

                boolean name = name_string.toUpperCase().equals(newnameofevent.toUpperCase());
                boolean old_name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                boolean location = (eventLocation.get(i).getText()).equals(locationofevent);
                boolean date = eventDate.get(i).getText().equals(localDate.toString());

                if ((name) && (date) && (!old_name) && (location)) {
                    obtainedresult = 1;
                    break;
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("photographer should change the location of event")
    public void change_location_of_event() {

        WebElement location = driver.findElement(By.id("location"));
        location.sendKeys(Keys.CONTROL, "a");
        location.sendKeys(Keys.DELETE);
        location.sendKeys(newlocationofevent);
        // driver.findElement(By.id("test123")).click();

    }

    @Then("location of event is updated")
    public void location_is_updated() {
        try {
            Thread.sleep(3000);

            int obtainedresult = 0;
            int expectedresult = 1;
            LocalDate localDate = LocalDate.now();

            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();

                String location_string = eventLocation.get(i).getText();
                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());

                boolean location = location_string.toUpperCase().equals(newlocationofevent.toUpperCase());
                boolean date = eventDate.get(i).getText().equals(localDate.toString());
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

    @And("photographer should change the date of event")
    public void change_date_of_event() {

        WebElement dates = driver.findElement(By.id("testEventDate"));
        dates.sendKeys(Keys.CONTROL, "a");
        dates.sendKeys(Keys.DELETE);
        dates.sendKeys(newdate);
        dates.sendKeys(Keys.ENTER);

        // driver.findElement(By.id("test123")).click();

    }

    @And("photographer click on the button of ok")
    public void photographer_click_on_the_button_of_ok() {
        driver.findElement(By.id("test123")).click();
    }

    @Then("date of event is updated")
    public void date_is_updated() {
        try {
            Thread.sleep(3000);

            int obtainedresult = 0;
            int expectedresult = 1;

            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();

                String location_string = eventLocation.get(i).getText();
                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());

                boolean location = location_string.toUpperCase().equals(locationofevent.toUpperCase());
                boolean date = eventDate.get(i).getText().equals(newdate);

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

    @Then("details of event is updated")
    public void details_is_updated() {
        try {
            Thread.sleep(3000);

            int obtainedresult = 0;
            int expectedresult = 1;

            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventLocation = driver.findElements(By.id("event-location"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));

            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();

                String location_string = eventLocation.get(i).getText();
                boolean name = name_string.toUpperCase().equals(newnameofevent.toUpperCase());

                boolean location = location_string.toUpperCase().equals(newlocationofevent.toUpperCase());
                boolean date = eventDate.get(i).getText().equals(newdate);
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

}
