package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

// import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

public class filter_steps {

    Driver driver;

    public filter_steps() {
        // Public no-argument constructor
    }

    public filter_steps(Driver driver) {
        this.driver = driver;
        this.driver.setupController();
    }

    @Given("user should navigate to the website uwas")
    public void user_should_navigate_to_the_website_uwas() {
        try {
            WebDriverManager.chromedriver().setup();
            /*
             * this.driver = new ChromeDriver();
             * this.driver.manage().window().maximize();
             */
            // System.out.println(this.driver.getBaseUrl());
            this.driver.getWebDriver().get(this.driver.getBaseUrl() + "/login");
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user write email as {string} and password as {string} and click on the button of login")
    public void user_write_email_and_password_and_click_on_the_button_of_login(String email, String password) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);

            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user click on all filters and should choose the start date as {string} and the finish date as {string}")
    public void user_click_on_all_filters_and_should_choose_the_start_date_and_the_finish_date(String star_date,
            String finish_date) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));

            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            Thread.sleep(10);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventDateFilter")));
            this.driver.getWebDriver().findElement(By.id("eventDateFilter")).sendKeys(star_date);
            Thread.sleep(10);
            this.driver.getWebDriver()
                    .findElement(
                            By.xpath("/html/body/div[3]/div/div[3]/div/div/div[2]/form/div/div[3]/div/div[3]/input"))
                    .sendKeys(finish_date);
            Thread.sleep(10);
            this.driver.getWebDriver()
                    .findElement(
                            By.xpath("/html/body/div[3]/div/div[3]/div/div/div[2]/form/div/div[3]/div/div[3]/input"))
                    .sendKeys(Keys.ENTER);
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(10);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventFilterEventsBTN")));
            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user must find the events in the period from start date as {string} to finish date as {string}")
    public void the_user_must_find_the_events_in_the_period_from_start_date_to_finish_date(String start_date,
            String finish_date) {
        try {
            Thread.sleep(3000);

            int expectedresult = 1;
            int obtainedresult = 0;
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate startInterval = LocalDate.parse(start_date);
            LocalDate endInterval = LocalDate.parse(finish_date);
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            // boolean find = false;
            int no_event = eventNames.size();
            // System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event in this period");
            } else {
                for (int i = 0; eventNames.size() > i; i++) {
                    LocalDate date = LocalDate.parse(eventDate.get(i).getText());
                    // String names = eventNames.get(i).getText();
                    // System.out.println(names);
                    // System.out.println(date);
                    if (date.isBefore(startInterval) || date.isAfter(endInterval)) {
                        obtainedresult = 0;
                        break;
                    } else {
                        obtainedresult = 1;
                    }
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);
            ;

            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        } catch (Exception e) {
            System.out.println("Erreur format");
        }

    }

    @And("user click on all filters and should write the name of event as {string}")
    public void user_click_on_all_filters_and_should_write_the_name_of_event(String name_of_event) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventName")));
            this.driver.getWebDriver().findElement(By.id("eventName")).sendKeys(name_of_event);
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventFilterEventsBTN")));
            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whose name of event as {string}")
    public void The_user_must_find_the_events_whose_name_of_event(String name_of_event) {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;

            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event with this name");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String Name = eventNames.get(i).getText();
                    boolean find = Name.toUpperCase().contains(name_of_event.toUpperCase());
                    if (find) {
                        obtainedresult = 1;
                    } else {
                        obtainedresult = 0;
                        break;

                    }
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);
            // System.out.println("test pass");

            Thread.sleep(50);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should write the location of event as {string}")
    public void user_click_on_all_filters_and_should_write_the_location_of_event(String location_of_event) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));

            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            Thread.sleep(20);
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventLocation")));
            this.driver.getWebDriver().findElement(By.id("eventLocation")).sendKeys(location_of_event);
            Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whose location of event as {string}")
    public void The_user_must_find_the_events_whose_location_of_event(String location_of_event) {
        try {
            Thread.sleep(3000);
            int expectedresult = 1;
            int obtainedresult = 0;

            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventlocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event with this location");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    // String names = eventNames.get(i).getText();
                    String location = eventlocation.get(i).getText();
                    boolean find = location.toUpperCase().contains(location_of_event.toUpperCase());
                    // System.out.println(names);
                    // System.out.println(location);
                    if (find) {
                        obtainedresult = 1;
                    } else {
                        // System.out.println("test fail");
                        obtainedresult = 0;
                        break;

                    }
                }
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(500);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should write the status of event")
    public void user_click_on_all_filters_and_should_write_the_status_of_event() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));

            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventFilterInProgress")).click();

            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    @And("user click on all filters and should write the status of the event")
    public void user_click_on_all_filters_and_should_write_the_status_of_the_event() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));

            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventFilterCompleted")).click();

            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whose status of event as {string}")
    public void The_user_must_find_the_events_whose_status_of_event(String status_of_event) {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventstatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event with this status");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    // String names = eventNames.get(i).getText();
                    String status = eventstatus.get(i).getText();
                    boolean find = status.toUpperCase().contentEquals(status_of_event.toUpperCase());
                    // System.out.println(names);
                    // System.out.println(status);
                    if (find) {
                        obtainedresult = 1;
                    } else {
                        // System.out.println("test fail");
                        obtainedresult = 0;
                        break;
                    }
                }
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(10);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whose have the status of event as {string}")
    public void The_user_must_find_the_events_whose_have_the_status_of_event(String status_of_event) {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventstatus = this.driver.getWebDriver().findElements(By.className("ant-tag-green"));
            // boolean find = false;

            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event with this status");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    // String names = eventNames.get(i).getText();
                    String status = eventstatus.get(i).getText();
                    boolean find = status.toUpperCase().contentEquals(status_of_event.toUpperCase());
                    // System.out.println(names);
                    // System.out.println(status);
                    if (find) {
                        obtainedresult = 1;
                    } else {
                        // System.out.println("test fail");
                        obtainedresult = 0;
                        break;
                    }
                }
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(10);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should click on today")
    public void user_click_on_all_filters_and_should_click_on_today() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));

            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventDateFilter")));
            this.driver.getWebDriver().findElement(By.id("eventDateFilter")).click();
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("test_Today")));
            this.driver.getWebDriver().findElement(By.id("test_Today")).click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventDateFilterOK")));
            this.driver.getWebDriver().findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(10);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventFilterEventsBTN")));
            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of today")
    public void The_user_must_find_the_events_of_today() {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            LocalDate localDate = LocalDate.now();
            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event today");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    // String names =eventNames.get(i).getText();
                    String date = eventDate.get(i).getText();
                    boolean found = date.contentEquals(localDate.toString());
                    // System.out.println(names);
                    // System.out.println(date);
                    if (found) {
                        obtainedresult = 1;
                    } else {
                        // System.out.println("test fail");
                        obtainedresult = 0;
                        break;
                    }
                }
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should click on this week")
    public void user_click_on_all_filters_and_should_click_on_this_week() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));

            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventDateFilter")));
            this.driver.getWebDriver().findElement(By.id("eventDateFilter")).click();
            Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("test_This Week")).click();

            this.driver.getWebDriver().findElement(By.id("eventDateFilterOK")).click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventFilterEventsBTN")));
            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of this week")
    public void The_user_must_find_the_events_of_this_week() {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            LocalDate date = LocalDate.now();
            LocalDate startweek = date;
            while (startweek.getDayOfWeek() != DayOfWeek.MONDAY) {
                startweek = startweek.minusDays(1);

            }
            // System.out.println("Start of the Week = " + startweek);
            LocalDate endweek = date;
            while (endweek.getDayOfWeek() != DayOfWeek.SUNDAY) {
                endweek = endweek.plusDays(1);

            }
            // System.out.println("End of the Week = " + endweek);

            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event this week");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    // String names = eventNames.get(i).getText();
                    // System.out.println(names);
                    // System.out.println(dateevent);
                    LocalDate today = LocalDate.parse(dateevent);

                    if ((today.isBefore(startweek)) || (today.isAfter(endweek))) {
                        System.out.println("test fail");
                        obtainedresult = 0;
                        break;
                    } else {
                        obtainedresult = 1;
                    }
                }
            }

            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should click on this month")
    public void user_click_on_all_filters_and_should_click_on_this_month() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));

            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventDateFilter")));
            this.driver.getWebDriver().findElement(By.id("eventDateFilter")).click();
            // Thread.sleep(1000);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("test_This Month")));
            this.driver.getWebDriver().findElement(By.id("test_This Month")).click();
            // Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of this month")
    public void The_user_must_find_the_events_of_this_month() {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            LocalDate date = LocalDate.now();
            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event this month");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    // String names = eventNames.get(i).getText();
                    // System.out.println(names);
                    // System.out.println(dateevent);
                    LocalDate today = LocalDate.parse(dateevent);
                    LocalDate firstday = LocalDate.parse(date.withDayOfMonth(1).toString());
                    LocalDate lastday = LocalDate.parse(date.withDayOfMonth(date.lengthOfMonth()).toString());
                    if (today.isBefore(firstday) || today.isAfter(lastday)) {
                        // System.out.println("test fail");
                        obtainedresult = 0;
                        break;
                    } else {
                        obtainedresult = 1;
                    }
                }
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user click on all filters and should click on this year")
    public void user_click_on_all_filters_and_should_click_on_this_year() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));

            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            // Thread.sleep(2000);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventDateFilter")));
            this.driver.getWebDriver().findElement(By.id("eventDateFilter")).click();
            // Thread.sleep(1000);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("test_This Year")));
            this.driver.getWebDriver().findElement(By.id("test_This Year")).click();

            this.driver.getWebDriver().findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of this year")
    public void The_user_must_find_the_events_of_this_year() {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            LocalDate date = LocalDate.now();
            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event this year");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    // String names = eventNames.get(i).getText();
                    // System.out.println(names);
                    // System.out.println(dateevent);
                    LocalDate today = LocalDate.parse(dateevent);
                    LocalDate firstDay = date.with(firstDayOfYear());
                    LocalDate lastDay = date.with(lastDayOfYear());
                    if (today.isBefore(firstDay) || today.isAfter(lastDay)) {
                        // System.out.println("test fail");
                        obtainedresult = 0;
                        break;
                    } else {
                        obtainedresult = 1;
                    }
                }
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(10);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user click on all filters and fill the name of event as {string} , the location of event as {string}, and the status of event as {string} and the date of event today")
    public void user_click_on_all_filters_and_fill_the_name_of_event_the_location_of_event_and_the_status_of_event_and_the_date_of_event_today(
            String name_of_event, String location_of_event, String status_of_event) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(10));

            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("event-filtre")));
            this.driver.getWebDriver().findElement(By.id("event-filtre")).click();
            // Thread.sleep(2000);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("eventName")));
            this.driver.getWebDriver().findElement(By.id("eventName")).sendKeys(name_of_event);
            // Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("eventLocation")).sendKeys(location_of_event);
            // Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("eventFilterInProgress")).click();
            // Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventDateFilter")).click();
            // Thread.sleep(1000);
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("test_Today")));
            this.driver.getWebDriver().findElement(By.id("test_Today")).click();
            // Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(1000);

            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whoose name of event as {string} , location of event as {string}, status of event as {string} and the date of event today")
    public void The_user_must_find_the_events_whoose_name_of_event_location_of_event_status_of_event_and_the_date_of_event_today(
            String name_of_event, String location_of_event, String status_of_event) {
        try {
            Thread.sleep(2000);
            int expectedresult = 1;
            int obtainedresult = 0;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            List<WebElement> eventstatus = this.driver.getWebDriver().findElements(By.className("ant-tag-gold"));
            List<WebElement> eventlocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            LocalDate date = LocalDate.now();
            // boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events " + no_event);
            if (no_event == 0) {
                obtainedresult = 1;
                System.out.println("no event with this filter");
            } else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    String names = eventNames.get(i).getText();
                    String status = eventstatus.get(i).getText();
                    String location = eventlocation.get(i).getText();
                    // System.out.println(names);
                    // System.out.println(location);
                    // System.out.println(dateevent);
                    // System.out.println(status);
                    boolean name_boolean = names.toUpperCase().contains(name_of_event.toUpperCase());
                    boolean date_boolean = dateevent.contentEquals(date.toString());
                    boolean status_boolean = status.contentEquals(status_of_event);
                    boolean location_boolean = location.contains(location_of_event);
                    if ((name_boolean) && (date_boolean) && (status_boolean) && (location_boolean)) {
                        // System.out.println("filter is okay");
                        obtainedresult = 1;
                    } else {
                        // System.out.println("test fail");
                        obtainedresult = 0;
                        break;
                    }
                }
            }
            Assert.assertEquals(expectedresult, obtainedresult);
            Thread.sleep(100);
            this.driver.getWebDriver().quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    @And("user click on all filters and should click on viewed events")
    public void user_click_on_all_filters_and_should_click_on_viewed_events() {
        try {

            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            Thread.sleep(1000);
            List<WebElement> List = this.driver.getWebDriver()
                    .findElements(By.className("ant-dropdown-menu-title-content"));
            List.get(0).click();
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("eventFilterViewed")).click();
            Thread.sleep(1000);
            List<WebElement> evnetViewed = this.driver.getWebDriver().findElements(By.className("viewed"));
            System.out.println("the events viewed " + evnetViewed.size());

            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user must find the events he has consulted")
    public void the_user_must_find_the_events_he_has_consulted() {
        try {
            Thread.sleep(2000);

            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> evnetViewed = this.driver.getWebDriver().findElements(By.className("viewed"));
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
            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    @And("user click on all filters and should click on not viewed events")
    public void user_click_on_all_filters_and_should_click_on_not_viewed_events() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            Thread.sleep(1000);
            List<WebElement> List = this.driver.getWebDriver()
                    .findElements(By.className("ant-dropdown-menu-title-content"));
            List.get(0).click();
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("eventFilterNotViewed")).click();
            List<WebElement> evnetnotViewed = this.driver.getWebDriver().findElements(By.className("notViewed"));
            System.out.println("the events not viewed " + evnetnotViewed.size());
            this.driver.getWebDriver().findElement(By.id("eventFilterEventsBTN")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    @Then("the user must find the events that he has not yet consulted")
    public void the_user_must_find_the_events_that_he_has_not_yet_consulted() {
        try {
            Thread.sleep(2000);
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> evnetnotViewed = this.driver.getWebDriver().findElements(By.className("notViewed"));
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
            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}
