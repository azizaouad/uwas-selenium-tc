package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;

public class archive_event {
    WebDriver driver;
    @Given("photographer should login with his credentials email as {string} and password as {string}")
    public void photographer_should_login_with_his_credentials_email_and_password ( String email , String password) {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();
            Thread.sleep(7000);
            driver.findElement(By.xpath("/html/body/div[1]/div/main/section[1]/div/div[1]/h1/button/span")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("name")).sendKeys("First day of work");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")).click();
            Thread.sleep(8000);
    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @When("photographer click on the three buttouns")
    public void photographer_click_on_the_three_buttouns_of_the_event_he_wants_to_archive (){

        driver.findElement(By.className("ant-btn-icon-only")).click();
    }

    @And("Choose archive")
    public void Choose_archive (){
        try {
            Thread.sleep(2000);
//            WebElement ele = driver.findElement(By.className("ant-btn-icon-only"));
//            Actions action = new Actions(driver);
//            Thread.sleep(2000);
//            action.moveToElement(ele).build().perform();
            Thread.sleep(5000);
            //driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[2]/div/div/div[7]/div[2]/div[1]/button[2]/span/svg")).click();
           driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/div/button[2]/span/svg")).click();
           Thread.sleep(2000);
           driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[3]/span[2]")).click();
           Thread.sleep(2000);
           driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div[2]/button[2]/span")).click();
           Thread.sleep(2000);



        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    @Then("the event is archived")
    public void the_event_is_archived () {
        boolean found = false;
        List<WebElement> eventNames = driver.findElements(By.className("eventDetails__bottom-name"));
        List<WebElement> eventLocation = driver.findElements(By.className("eventDetails__bottom-location-text"));
        List<WebElement> eventDate = driver.findElements(By.className("eventDetails__footer-date"));
        List<WebElement> eventStatus = driver.findElements(By.className("ant-tag"));
        LocalDate localDate = LocalDate.now();
        System.out.println("the date of today : " + localDate.toString());

        for (int i = 0; i < eventNames.size(); i++) {
            boolean name = eventNames.get(i).getText().equals("First day of work");

            boolean date = eventDate.get(i).getText().equals(localDate.toString());

            if ((name) &&  (date) ) {
                found = true;
                break;
            }
        }
        System.out.println(found);
        Assert.assertTrue(found);
        driver.quit();

    }

    @When("photographer should go to the archive event")
    public void photographer_should_go_to_the_archive_event (){
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[1]/div/main/section[1]/div/div[1]/h1/a/div/div[1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li/span[1]")).click();


        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    @And("Choose restore")
    public void Choose_restore () {

    }
    @Then("the event is restored")
    public void the_event_is_restored () {


    }
}
