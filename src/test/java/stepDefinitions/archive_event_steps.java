package stepDefinitions;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class archive_event_steps extends Base {

    private static final String RANDOM_NAME;
    static {
        String[] names = { "restore", "tester", "test", "archive", "qa", "quality", "testeur",
                "automation", "code", "testrestore", "testarchive" };
        Random random = new Random();
        int index = random.nextInt(names.length);
        RANDOM_NAME = names[index];
    }

    public static String getConstantRandomName() {
        return RANDOM_NAME;
    }

    String nameofevent = getConstantRandomName();

    @Before("@archive")
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

    @After("@archive")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @And("photographer add event")
    public void add_event() {

        waitForVisibilityOfElement(By.id("dropdown-event-link"));
        driver.findElement(By.id("dropdown-event-link")).click();
        waitForElementToBeClickable(By.id("event-add"));
        driver.findElement(By.id("event-add")).click();
        waitForVisibilityOfElement(By.id("event-title"));

        WebElement event = driver.findElement(By.id("event-title"));
        event.sendKeys(nameofevent);

        driver.findElement(By.id("test123")).click();
    }

    @When("photographer click on the three buttouns")
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

    @And("Choose archive the event")
    public void Choose_archive_the_event() {
        waitForVisibilityOfElement(By.id("testArchive"));
        driver.findElement(By.id("testArchive")).click();
        waitForVisibilityOfElement(By.id("testOKArchive"));
        driver.findElement(By.id("testOKArchive")).click();

    }

    @Then("the event is archived")
    public void the_event_is_archived() throws InterruptedException {
        waitForElementToBeClickable(By.id("dropdown-event-link"));

        driver.findElement(By.id("dropdown-event-link")).click();
        waitForVisibilityOfElement(By.id("event-archive"));
        driver.findElement(By.id("event-archive")).click();

        int obtainedresult = 0;
        int expectedresult = 1;
        Thread.sleep(2000);

        List<WebElement> eventNames = driver.findElements(By.id("event-name"));

        List<WebElement> eventDate = driver.findElements(By.id("event-date"));

        LocalDate localDate = LocalDate.now();
        ;
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText();
            String date_string = eventDate.get(i).getText();

            boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
            boolean date = date_string.equals(localDate.toString());

            if ((name) && (date)) {
                obtainedresult = 1;
                // System.out.println((nameofevent + " is archived"));
                break;
            }
        }
        Assert.assertEquals(expectedresult, obtainedresult);

    }

    @When("photographer should go to the archive event")
    public void photographer_should_go_to_the_archive_event() {
        waitForElementToBeClickable(By.id("dropdown-event-link"));

        driver.findElement(By.id("dropdown-event-link")).click();
        waitForVisibilityOfElement(By.id("event-archive"));
        driver.findElement(By.id("event-archive")).click();

    }

    @And("Choose restore the event")
    public void Choose_restore_the_event() {
        try {
            Thread.sleep(3000);
            List<WebElement> points = driver.findElements(By.id("event-edit-dropdown"));
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));
            LocalDate localDate = LocalDate.now();
            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                String date_string = eventDate.get(i).getText();

                boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                boolean date = date_string.equals(localDate.toString());
                if ((date) && (name)) {
                    points.get(i).click();
                    waitForVisibilityOfElement(By.id("testRestore"));
                    driver.findElement(By.id("testRestore")).click();
                    // System.out.println(nameofevent + " is restored");
                    break;

                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("the event is restored")
    public void the_event_is_restored() {
        try {

            Thread.sleep(3000);

            int obtainedresult = 0;
            int expectedresult = 1;

            List<WebElement> eventNames = driver.findElements(By.id("event-name"));

            List<WebElement> eventDate = driver.findElements(By.id("event-date"));

            LocalDate localDate = LocalDate.now();
            if (eventNames.size() == 0) {
                // System.out.println("no event for restore ");

                obtainedresult = 1;
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String name_string = eventNames.get(i).getText();
                    String date_string = eventDate.get(i).getText();
                    boolean name = name_string.toUpperCase().equals(nameofevent.toUpperCase());
                    boolean date = date_string.equals(localDate.toString());
                    if ((name) && (date)) {
                        obtainedresult = 0;

                        break;
                    } else {
                        obtainedresult = 1;
                        ;

                    }
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
