package stepDefinitions;

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
import org.uwas.Driver;

import java.util.List;

public class scenario_steps {
    Driver driver;

    public scenario_steps(Driver driver) {
        this.driver = driver;
        this.driver.setupController();
    }

    @Then("photographer should logout")
    public void photographer_should_logout() {
        try {
            Thread.sleep(4000);
            this.driver.getWebDriver().findElement(By.id("user-dropdown")).click();
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("testLogout")).click();
            Thread.sleep(1000);
            boolean bol1 = false;
            boolean bol2 = false;
            Thread.sleep(2000);
            bol1 = this.driver.getWebDriver().findElement(By.id("email")).isDisplayed();
            bol2 = this.driver.getWebDriver().findElement(By.id("password")).isDisplayed();
            Assert.assertTrue(bol1);
            Assert.assertTrue(bol2);
            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    @Given("user should navigate to the site")
    public void user_should_navigate_to_the_site() {
        try {
            WebDriverManager.chromedriver().setup();
            /*this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();*/
            System.out.println(this.driver.getBaseUrl());
            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("user write email as {string} and password as {string} and click on login button")
    public void user_write_email_and_password_and_click_on_login_button(String email , String password) {
        try {

            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("user upload some photos")
    public void user_upload_some_photos() {
        try {
            Thread.sleep(4000);
            WebElement upload_button = this.driver.getWebDriver().findElement(By.id("testUpload"));
            Thread.sleep(2000);
            upload_button.click();
            Thread.sleep(5000);
            WebElement source = this.driver.getWebDriver().findElement(By.id("upload-photos"));
            Thread.sleep(3000);
            source.sendKeys("C:/Users/Lenovo/Downloads/wetransfer_20230109_161332-jpg_2023-01-09_1514/12345678 (24).jpg");
            this.driver.getWebDriver().findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div/div/div/button")).click();


            /*
            source.sendKeys("C://Users//Lenovo//Downloads//test.png");
            System.out.println("3");
            source.sendKeys("C:/Users/Lenovo/Desktop/Nouveau dossier/qa@gmail.com/a (2).jpg");
            System.out.println("4");
            Thread.sleep(4000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div/div/div/button")).click();*/
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("the photos are uploaded")
    public void the_photos_are_uploaded() {
        try {
            Thread.sleep(10000);
            boolean upload = this.driver.getWebDriver().findElement(By.className("ant-divider-inner-text")).isDisplayed();
            if (upload) {
                System.out.println("the photos are successfully uploaded");
                this.driver.getWebDriver().findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button")).click();

            } else {
                System.out.println("photos are not uploaded ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("photographer click on the button of add event")
    public void photographer_should_click_on_the_button_of_add_event() {
        try {
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.id("dropdown-event-link")).click();
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.id("event-add")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("photographer fill the title of event as {string}")
    public void photographer_should_fill_the_title_of_event(String title_of_event) {
        try {
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.id("event-title")).sendKeys(title_of_event);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("photographer fill the location of event as {string}")
    public void photographer_should_fill_the_location_of_event(String location_of_event) {
        try {
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("location")).sendKeys(location_of_event);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("photographer fill the date of event as {string}")
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
    @And("photographer put an image")
    public void photographer_put_an_image_for_the_event() {
        try {
            Thread.sleep(1000);
            WebElement source = this.driver.getWebDriver().findElement(By.id("upload"));
            source.sendKeys("C://Users/Lenovo/Desktop/traditions-noel-europe-1024x683.jpg");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    @And("photographer should click on the ok button")
    public void photographer_should_click_on_the_button_ok() {
        try {
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("test123")).click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("title of event as {string} in the location of event as {string} at the date of event as {string} is created")
    public void title_of_event_in_location_at_date_is_created(String title_of_event, String location_of_event, String date_of_event) {
        try {
            Thread.sleep(1000);
            boolean found = false;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag-gold"));


            for (int i = 0; i < eventNames.size(); i++) {
                String name_string =eventNames.get(i).getText();
                String location_string = eventLocation.get(i).getText();
                boolean name = name_string.toUpperCase().equals(title_of_event.toUpperCase());
                boolean location = location_string.toUpperCase().equals(location_of_event.toUpperCase());
                boolean date = eventDate.get(i).getText().equals(date_of_event);
                boolean status = eventStatus.get(i).getText().equals("In progress");
                if ((name) && (date ) && (status)&& (location)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
