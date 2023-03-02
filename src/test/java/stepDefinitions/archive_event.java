package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.uwas.Driver;

import java.time.LocalDate;
import java.util.List;

public class archive_event {
    Driver driver;

    public archive_event(Driver driver) {
        this.driver = driver;
        this.driver.setupController();
    }
    @Given("photographer should login with his credentials email as {string} and password as {string} and create an event title as {string}")
    public void photographer_should_login_with_his_credentials_email_and_password ( String email , String password, String title) {
        try {
            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.id("normal_login_email")).sendKeys(email);

            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(password);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(6000);
            this.driver.getWebDriver().findElement(By.className("underHeader__left-menu")).click();
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.className("ant-dropdown-menu-title-content")).click();
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("name")).sendKeys(title);

            this.driver.getWebDriver().findElement(By.id("test123")).click();
    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @When("photographer click on the three buttouns")
    public void photographer_click_on_the_three_buttouns_of_the_event_he_wants_to_archive (){


    }

    @And("Choose archive for the event name as {string}")
    public void Choose_archive (String event_name){
        try {

//            WebElement ele = driver.findElement(By.className("ant-btn-icon-only"));
//            Actions action = new Actions(driver);
//            Thread.sleep(2000);
//            action.moveToElement(ele).build().perform();
           Thread.sleep(4000);
            //driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[2]/div/div/div[7]/div[2]/div[1]/button[2]/span/svg")).click();
           WebElement points=this.driver.getWebDriver().findElement(By.className("ant-btn-icon-only"));
           points.click();
           Thread.sleep(2000);
           driver.getWebDriver().findElement(By.id("testArchive")).click();
           Thread.sleep(2000);
           driver.getWebDriver().findElement(By.id("testOKArchive")).click();
           Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the event as {string} is archived")
    public void the_event_is_archived (String title) {
        boolean found = false;
        List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-name"));
        List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-location-text"));
        List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-date-text"));
        List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText() ;
            String date_string = eventDate.get(i).getText();
            System.out.println(name_string);
            System.out.println(date_string);
            boolean name = name_string.toUpperCase().equals(title.toUpperCase());
            boolean date = date_string.equals(localDate.toString());
            if ((name) && (date) ) {
                found = true;
                break;
            }
        }
        Assert.assertFalse(found);
        this.driver.getWebDriver().quit();
    }

    @When("photographer should go to the archive event")
    public void photographer_should_go_to_the_archive_event (){
        try {
            Thread.sleep(5000);
            this.driver.getWebDriver().findElement(By.className("underHeader__left-menu")).click();
            Thread.sleep(1000);
            List<WebElement> List = this.driver.getWebDriver().findElements(By.className("ant-dropdown-menu-title-content"));
            List.get(2).click();
            Thread.sleep(1000);



        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    @And("Choose restore for the event {string}")
    public void Choose_restore_for_the_event (String event) {
        try {

            List <WebElement> points = this.driver.getWebDriver().findElements(By.className("anticon-ellipsis"));
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-location-text"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-date-text"));
            LocalDate localDate = LocalDate.now();

            for ( int i =0 ; i<eventNames.size() ; i++ ) {
                String name_string = eventNames.get(i).getText() ;
                String date_string = eventDate.get(i).getText();
                System.out.println(name_string);
                boolean name = name_string.toUpperCase().equals(event.toUpperCase());
                boolean date = date_string.equals(localDate.toString());
                if ((name)&&(date)){
                    Thread.sleep(100);
                    points.get(i+1).click();
                    WebElement restore = this.driver.getWebDriver().findElement(By.className("ant-dropdown-menu-title-content"));
                    restore.click();
                    break;
                    }
                }




        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the title of event as {string} is restored")
    public void the_event_is_restored (String title) {
        try {
            this.driver.getWebDriver().findElement(By.className("ant-menu-title-content")).click();
            Thread.sleep(1500);
            boolean found = false;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-location-text"));
            List<WebElement> eventDate =this.driver.getWebDriver().findElements(By.className("eventDetails__bottom-date-text"));
            List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
            LocalDate localDate = LocalDate.now();
            if (eventNames.size()==0){
                found = true;
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String name_string = eventNames.get(i).getText() ;
                    String date_string = eventDate.get(i).getText();
                    System.out.println(name_string);
                    boolean name = name_string.toUpperCase().equals(title.toUpperCase());
                    boolean date = date_string.equals(localDate.toString());
                    if ((name) && (date) ) {
                        found = true;
                        break;
                    }
                }
            }

            Assert.assertTrue(found);
            Thread.sleep(10);
            this.driver.getWebDriver().quit();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Given("photographer should login with his credentials email as {string} and password as {string}")
    public void photographer_should_login_with_his_credentials_email_and_password (String email , String password) {
        try {

            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            Thread.sleep(2000);
            this.driver.getWebDriver().findElement(By.id("normal_login_email")).sendKeys(email);
            this.driver.getWebDriver().findElement(By.id("normal_login_password")).sendKeys(password);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
