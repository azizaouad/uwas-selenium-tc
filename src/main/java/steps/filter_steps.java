package steps;

import com.fasterxml.jackson.annotation.JacksonInject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import shared.Controller;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

public class filter_steps {

    WebDriver driver;

    public filter_steps(Controller controller) {
        this.driver = controller.getDriver();
    }

    @And("user click on all filters and should choose the start date as {string} and the finish date as {string}")
    public void user_click_on_all_filters_and_should_choose_the_start_date_and_the_finish_date(String star_date, String finish_date) {
        try {

            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventDateFilter")).sendKeys(star_date);
            Thread.sleep(5000);
            this.driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[1]/div/div/div[2]/div/form/div/div[3]/div/div[3]/input")).sendKeys(finish_date);
            Thread.sleep(5000);
            this.driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[1]/div/div/div[2]/div/form/div/div[3]/div/div[3]/input")).sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            this.driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[1]/div/div/div[2]/div/form/div/div[5]/button")).click();
            Thread.sleep(8000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user must find the events in the period from start date as {string} to finish date as {string}")
    public void the_user_must_find_the_events_in_the_period_from_start_date_to_finish_date(String start_date, String finish_date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate startInterval = LocalDate.parse(start_date);
            LocalDate endInterval = LocalDate.parse(finish_date);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event in this period");
            }
            else {
                for (int i = 0; eventNames.size() > i; i++) {
                    LocalDate date = LocalDate.parse(eventDate.get(i).getText());
                    String names = eventNames.get(i).getText();
                    System.out.println(names);
                    System.out.println(date);
                    if (date.isBefore(startInterval.minusDays(1)) || date.isAfter(endInterval.plusDays(1))) {
                        System.out.println("Date is not in the interval");
                        find = false;
                        break;
                    }else {
                        find = true ;
                    }
                }
            }


            Assert.assertTrue(find);
            Thread.sleep(2000);
            this.driver.quit();

        } catch (Exception e) {
            System.out.println("Erreur format");
        }

    }

    @And("user click on all filters and should write the name of event as {string}")
    public void user_click_on_all_filters_and_should_write_the_name_of_event(String name_of_event) {
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventName")).sendKeys(name_of_event);
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whose name of event as {string}")
    public void The_user_must_find_the_events_whose_name_of_event(String name_of_event) {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event with this name");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String Name = eventNames.get(i).getText();
                    find = Name.toUpperCase().contains(name_of_event.toUpperCase());
                    System.out.println(Name);
                    if (find) {
                        find = true ;
                    } else {
                        find = false;
                        break;

                    }
                }
            }

            Assert.assertTrue(find);
            Thread.sleep(3000);
            this.driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should write the location of event as {string}")
    public void user_click_on_all_filters_and_should_write_the_location_of_event(String location_of_event) {
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventLocation")).sendKeys(location_of_event);
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whose location of event as {string}")
    public void The_user_must_find_the_events_whose_location_of_event(String location_of_event) {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventlocation = this.driver.findElements(By.className("eventDetails__bottom-location-text"));
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event with this location");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String names = eventNames.get(i).getText();
                    String location = eventlocation.get(i).getText();
                    find = location.toUpperCase().contains(location_of_event.toUpperCase());
                    System.out.println(names);
                    System.out.println(location);
                    if (find) {
                        find = true;
                    } else {
                        find = false;
                        break;

                    }
                }
            }
            Assert.assertTrue(find);
            Thread.sleep(3000);
            this.driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should write the status of event as {string}")
    public void user_click_on_all_filters_and_should_write_the_status_of_event(String status_of_event) {
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventFilterInProgress")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events whose status of event as {string}")
    public void The_user_must_find_the_events_whose_status_of_event(String status_of_event) {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventstatus = this.driver.findElements(By.className("ant-tag-gold"));
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event with this status");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String names = eventNames.get(i).getText();
                    String status = eventstatus.get(i).getText();
                    find = status.toUpperCase().contentEquals(status_of_event.toUpperCase());
                    System.out.println(names);
                    System.out.println(status);
                    if (find) {
                        find = true ;
                    } else {
                        find = false;
                        break;
                    }
                }
            }

            Assert.assertTrue(find);
            Thread.sleep(3000);
            this.driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should click on today")
    public void user_click_on_all_filters_and_should_click_on_today() {
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventDateFilter")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("test_Today")).click();
            Thread.sleep(3000);
            this.driver.findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(4000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of today")
    public void The_user_must_find_the_events_of_today() {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            LocalDate localDate = LocalDate.now();
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event today");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String names =eventNames.get(i).getText();
                    String date = eventDate.get(i).getText();
                    find = date.contentEquals(localDate.toString());
                    System.out.println(names);
                    System.out.println(date);
                    if (find) {
                        find = true ;
                    } else {
                        find = false;
                        break;
                    }
                }
            }
            Assert.assertTrue(find);
            Thread.sleep(2000);
            this.driver.quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should click on this week")
    public void user_click_on_all_filters_and_should_click_on_this_week() {
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventDateFilter")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("test_This Week")).click();
            Thread.sleep(3000);
            this.driver.findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(4000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of this week")
    public void The_user_must_find_the_events_of_this_week() {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            LocalDate date = LocalDate.now();
            LocalDate startweek = date;
            while (startweek.getDayOfWeek() != DayOfWeek.MONDAY) {
                startweek = startweek.minusDays(1);

            }
            System.out.println("Start of the Week = " + startweek);
            LocalDate endweek = date;
            while (endweek.getDayOfWeek() != DayOfWeek.SUNDAY) {
                endweek = endweek.plusDays(1);

            }
            System.out.println("End of the Week = " + endweek);

            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event this week");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    String names = eventNames.get(i).getText();
                    System.out.println(names);
                    System.out.println(dateevent);
                    LocalDate today = LocalDate.parse(dateevent);

                    if ((today.isBefore(startweek.minusDays(1))) || (today.isAfter(endweek.plusDays(1)))) {
                        find = false;
                        break;
                    }else {
                        find = true ;
                    }
                }
            }

            Assert.assertTrue(find);
            Thread.sleep(2000);
            this.driver.quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user click on all filters and should click on this month")
    public void user_click_on_all_filters_and_should_click_on_this_month() {
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventDateFilter")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("test_This Month")).click();
            Thread.sleep(3000);
            this.driver.findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(4000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of this month")
    public void The_user_must_find_the_events_of_this_month() {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            LocalDate date = LocalDate.now();
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event this month");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    String names = eventNames.get(i).getText();
                    System.out.println(names);
                    System.out.println(dateevent);
                    LocalDate today = LocalDate.parse(dateevent);
                    LocalDate firstday = LocalDate.parse(today.withDayOfMonth(1).toString());
                    LocalDate lastday = LocalDate.parse(today.withDayOfMonth(today.lengthOfMonth()).toString());
                    if (today.isBefore(firstday.minusDays(1)) || today.isAfter(lastday.plusDays(1))) {
                        find = false;
                        break;
                    }
                    else {
                        find = true ;
                    }
                }
            }
            Assert.assertTrue(find);
            Thread.sleep(2000);
            this.driver.quit();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user click on all filters and should click on this year")
    public void user_click_on_all_filters_and_should_click_on_this_year() {
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventDateFilter")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("test_This Year")).click();
            Thread.sleep(3000);
            this.driver.findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(4000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("The user must find the events of this year")
    public void The_user_must_find_the_events_of_this_year() {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            LocalDate date = LocalDate.now();
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event this year");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    String names = eventNames.get(i).getText();
                    System.out.println(names);
                    System.out.println(dateevent);
                    LocalDate today = LocalDate.parse(dateevent);
                    LocalDate firstDay = today.with(firstDayOfYear());
                    LocalDate lastDay = today.with(lastDayOfYear());
                    if (date.isBefore(firstDay.minusDays(1)) || today.isAfter(lastDay.plusDays(1))) {
                        find = false;
                        break;
                    }
                    else {
                        find = true ;
                    }
                }
            }
            Assert.assertTrue(find);
            Thread.sleep(2000);
            this.driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @And("user click on all filters and fill the name of event as {string} , the location of event as {string}, and the status of event as {string} and the date of event today")
    public void user_click_on_all_filters_and_fill_the_name_of_event_the_location_of_event_and_the_status_of_event_and_the_date_of_event_today(String name_of_event, String location_of_event, String status_of_event){
        try {
            Thread.sleep(10000);
            this.driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventName")).sendKeys(name_of_event);
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventLocation")).sendKeys(location_of_event);
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventFilterInProgress")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("eventDateFilter")).click();
            Thread.sleep(5000);
            this.driver.findElement(By.id("test_Today")).click();
            Thread.sleep(3000);
            this.driver.findElement(By.id("eventDateFilterOK")).click();
            Thread.sleep(4000);
            this.driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("The user must find the events whoose name of event as {string} , location of event as {string}, status of event as {string} and the date of event today")
    public void The_user_must_find_the_events_whoose_name_of_event_location_of_event_status_of_event_and_the_date_of_event_today(String name_of_event, String location_of_event , String status_of_event ) {
        try {
            Thread.sleep(5000);
            List<WebElement> eventNames = this.driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventDate = this.driver.findElements(By.className("eventDetails__bottom-date-text"));
            List<WebElement> eventstatus = this.driver.findElements(By.className("ant-tag-gold"));
            List<WebElement> eventlocation = this.driver.findElements(By.className("eventDetails__bottom-location-text"));
            LocalDate date = LocalDate.now();
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event with this filter");
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String dateevent = eventDate.get(i).getText();
                    String names = eventNames.get(i).getText();
                    String status = eventstatus.get(i).getText();
                    String location = eventlocation.get(i).getText();
                    System.out.println(names);
                    System.out.println(location);
                    System.out.println(dateevent);
                    System.out.println(status);
                    boolean name_boolean = names.toUpperCase().contains(name_of_event.toUpperCase());
                    boolean date_boolean = dateevent.contentEquals(date.toString());
                    boolean status_boolean = status.contentEquals(status_of_event);
                    boolean location_boolean = location.contains(location_of_event);
                    if ((name_boolean) && (date_boolean) && (status_boolean) && (location_boolean)) {
                        System.out.println("filter is okay");
                        find = true ;
                    } else {
                        find = false;
                        break;
                    }
                }
            }
            Assert.assertTrue(find);
            Thread.sleep(2000);
            this.driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}

