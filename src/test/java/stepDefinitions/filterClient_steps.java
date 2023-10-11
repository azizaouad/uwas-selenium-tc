package stepDefinitions;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.Select;

import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class filterClient_steps extends Base {

    // choisir la période à filtrer
    String startdate = generateRandomDate(2023, 2023);
    String enddate = generateRandomDate(2024, 2024);

    // choisir la recherche par nom

    String FilterText = addRandomCharacter("event");

    // choisir à filtrer par location
    String FilterLocation = addRandomCharacter("Location");

    private String addRandomCharacter(String title) {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

        String modifiedTitle = title + randomChar; // Append the random character to the title
        return modifiedTitle;
    }

    @Before("@filterC")
    public void user_should_navigate_to_the_website() {
        try {
            launch_browser();
            waitForVisibilityOfElement(By.id("email"));
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id(
                    "password"));
            WebElement loginButton = driver.findElement(By.id("testLogin"));
            emailField.sendKeys(props.getProperty("emailclient"));
            passwordField.sendKeys(props.getProperty("password"));
            loginButton.click();
            waitForVisibilityOfElement(By.id("dropdown-event-link"));
            driver.findElement(By.id("dropdown-event-link")).click();
            Thread.sleep(1000);
            List<WebElement> List = driver.findElements(By.className("ant-dropdown-menu-title-content"));
            List.get(0).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }

    @After("@filterC")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @And("user click on all filters and should click on viewed events")
    public void user_click_on_all_filters_and_should_click_on_viewed_events() {
        try {
            Thread.sleep(1000);

            driver.findElement(By.id("eventFilterViewed")).click();
            Thread.sleep(1000);
            List<WebElement> evnetViewed = driver.findElements(By.className("viewed"));
            System.out.println("the events viewed " + evnetViewed.size());

            driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user must find the events he has consulted")
    public void the_user_must_find_the_events_he_has_consulted() {
        try {
            Thread.sleep(2000);

            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> evnetViewed = driver.findElements(By.className("viewed"));
            // System.out.println("the events viewed " + evnetViewed.size());
            boolean find = false;
            int no_event = eventNames.size();
            // System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                find = true;
                System.out.println("no event consulted");
            } else {
                if (no_event == evnetViewed.size()) {
                    find = true;
                }
            }

            Assert.assertTrue(find);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    @And("user click on all filters and should click on not viewed events")
    public void user_click_on_all_filters_and_should_click_on_not_viewed_events() {
        try {

            Thread.sleep(1000);
            driver.findElement(By.id("eventFilterNotViewed")).click();
            List<WebElement> evnetnotViewed = driver.findElements(By.className("notViewed"));
            System.out.println("the events not viewed " + evnetnotViewed.size());
            driver.findElement(By.id("eventFilterEventsBTN")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    @Then("the user must find the events that he has not yet consulted")
    public void the_user_must_find_the_events_that_he_has_not_yet_consulted() {
        try {
            Thread.sleep(2000);
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> evnetnotViewed = driver.findElements(By.className("notViewed"));
            System.out.println("the events not viewed " + evnetnotViewed.size());
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                find = true;
                System.out.println("no event no consulted");
            } else {
                if (no_event == evnetnotViewed.size()) {
                    find = true;
                }
            }

            Assert.assertTrue(find);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

}
