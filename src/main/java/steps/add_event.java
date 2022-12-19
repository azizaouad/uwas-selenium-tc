package steps;

import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.PendingException;
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
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class add_event {
    WebDriver driver;


    @Given("photographer should login")
    public void photographer_should_login() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            driver.findElement(By.id("normal_login_email")).sendKeys("azizaouadi12@gmail.com");
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("photographer should click on the button of add event")
    public void photographer_should_click_on_the_button_of_add_event() {
        try {
            Thread.sleep(4000);
            driver.findElement(By.xpath("/html/body/div[1]/div/main/section[1]/div/div[1]/h1/button/span")).click();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the title of event as {string}")
    public void photographer_should_fill_the_title_of_event(String title_of_event) {
        try {
            Thread.sleep(3000);
            driver.findElement(By.id("name")).sendKeys(title_of_event);
            System.out.println("ggg");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the location of event as {string}")
    public void photographer_should_fill_the_location_of_event(String location_of_event) {
        try {
            Thread.sleep(3000);
            driver.findElement(By.id("location")).sendKeys(location_of_event);
            System.out.println("555");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the date of event as {string}")
    public void photographer_should_fill_the_date_of_event(String date_of_event) {
        try {
            Thread.sleep(3000);
            WebElement dateInput = driver.findElement(By.id("date"));
            Thread.sleep(2000);
            dateInput.click();
            Thread.sleep(2000);
            dateInput.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]/div[2]/table/tbody/tr[5]/td[1]/div")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put an image for the event")
    public void photographer_put_an_image_for_the_event() {
        try {
            Thread.sleep(3000);
            WebElement source = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[5]/div/div[2]/div/div/span/div[1]/span/input"));
            source.sendKeys("C://Users/DELL/Desktop/cover-showpage-films-tv-de-noel-2022-17ffdf-a9298f-0@1x.jpg");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("photographer should click on the button ok")
    public void photographer_should_click_on_the_button_ok() {
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")).click();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the event is created")
    public void the_event_is_created() {
        AtomicBoolean found = new AtomicBoolean(false);
        List<WebElement> eventNames = driver.findElements(By.className("eventDetails__name"));
        List<WebElement> eventLocation = driver.findElements(By.className("eventDetails__location"));
        List<WebElement> eventDate = driver.findElements(By.className("eventDetails__footer-date"));
        List<WebElement> eventStatus = driver.findElements(By.className("eventDetails__status"));

        for (int i=0; i< eventNames.size(); i++) {
            boolean name = eventNames.get(i).getText().equals("noel");
            boolean location = eventLocation.get(i).getText().equals("paris");
            boolean date = eventDate.get(i).getText().equals("2022-12-25");
            boolean status = eventStatus.get(i).getText().equals("In progress");
            if((name) && (location) && (date) && (status)) {
                found.set(true);
                break;
            }
        }
        Assert.assertTrue(found.get());
        //        Thread.sleep(15000);
//        ArrayList<WebElement> cards = (ArrayList<WebElement>) driver.findElements(By.className("ant-card-meta"));
//        boolean event = false;
//        for (int i = 0; i < cards.size(); i++) {
//            String event_text = cards.get(i).findElements(By.className("mx-auto")).toString();
//            System.out.println(event_text);
//            while (event != true) {
//                if (event_text.contentEquals("noel")) {
//                    event = true;
//                }
//            }
//        }





        /*ArrayList<WebElement> cards = (ArrayList<WebElement>) driver.findElements(By.className("ant-card-meta"));
        name_of_event.getText();
        for (int i = 0; i < cards.size(); i++) {
            String title = name_of_event.getText();
            //String event_text = cards.get(i).findElements(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div/div[3]/h1")).toString();
            System.out.println(title);
            while (event == false) {
               if ((title).contentEquals("noel")) {
                    event = true;
              }
           }
        }

        Assert.assertTrue(event == true);*/
        //throw new PendingException();
    }
}


     