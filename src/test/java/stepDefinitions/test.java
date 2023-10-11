package test.java.stepDefinitions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Base.Base;

public class test extends Base {
    public static void main(String[] args) {
        try {
            String startdate = generateRandomDate(2023, 2023);
            String enddate = generateRandomDate(2024, 2024);
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

            waitForVisibilityOfElement(By.id("eventDateFilter"));

            driver.findElement(By.id("eventDateFilter")).sendKeys(startdate);
            String placeholderText = "End date";
            driver.findElement(By.xpath("//input[@placeholder='" + placeholderText + "']"))
                    .sendKeys(enddate);
            driver.findElement(By.id("eventDateFilter")).sendKeys(Keys.ENTER);
            driver.findElement(By.id("eventDateFilterOK")).click();
            driver.findElement(By.id("eventFilterEventsBTN")).click();

            int expectedresult = 1;
            int obtainedresult = 0;
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate startInterval = LocalDate.parse(startdate);
            LocalDate endInterval = LocalDate.parse(enddate);
            List<WebElement> eventNames = driver.findElements(By.id("event-name"));
            List<WebElement> eventDate = driver.findElements(By.id("event-date"));
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
                        System.out.println(date);
                        break;
                    } else {
                        obtainedresult = 1;
                    }
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Erreur format");

        }

    }
}
