package stepDefinitions;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class edit_event {
    Driver driver;
    String title ;
    String new_title;
    String location;
    String new_location;
    private String randomeDate ;


    public edit_event() {
        // Public no-argument constructor
    }

    public edit_event(Driver driver) {
        System.out.println(System.getProperty("environment"));
        this.driver = driver;
        this.title = addRandomCharacter("editer");
        this.new_title = addRandomCharacter(this.title);
        this.location = addRandomCharacter("location");
        this.new_location = addRandomCharacter(location);
        this.driver.setupController();

    }
    private String addRandomCharacter(String title) {
    Random random = new Random();
    char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase letter

    String modifiedTitle = title + randomChar; // Append the random character to the title
    return modifiedTitle;
}


    @Given("photographer should log-in")
    public void photographer_should_log_in() {
        try {

            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys("k@gmail.com");
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys("Admin123!");
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(20);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("photographer should click on the button of add-event")
    public void photographer_should_click_on_the_button_of_add_event() {
        try {
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            Thread.sleep(500);
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("event-add")));
            this.driver.getWebDriver().findElement(By.id("event-add")).click();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @And("photographer should fill the title of event")
    public void fill_the_title_of_event() {
        try {
            Thread.sleep(10);
            // // Get the handle of the current window
            // String currentWindowHandle = this.driver.getWebDriver().getWindowHandle();

            // // Perform actions in the target window
            // // ...

            // // Switch back to the main window
            // this.driver.getWebDriver().switchTo().window(currentWindowHandle);
            WebDriverWait wait = new  WebDriverWait (driver.getWebDriver(),Duration.ofSeconds(3));
            wait.pollingEvery(Duration.ofMillis(500));
            

            // new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(5))
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("event-title")));
            WebElement event = this.driver.getWebDriver().findElement(By.id("event-title"));
            event.sendKeys(this.title);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

        @And("photographer click on the ok button")
    public void click_on_the_ok_buttonk() {
        try {
            Thread.sleep(20);
            this.driver.getWebDriver().findElement(By.id("test123")).click();
            
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
@And("photographer click on the three buttouns for updating")
public void three_buttons(){
    try {
        Thread.sleep(3000);
        WebElement points=this.driver.getWebDriver().findElement(By.id("event-edit-dropdown"));
        List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
        List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
        LocalDate localDate = LocalDate.now();
        for (int i=0 ; i < eventNames.size(); i++){
        String name_string = eventNames.get(i).getText() ;
        String date_string = eventDate.get(i).getText();
                // System.out.println(name_string);
                // System.out.println(date_string);
        boolean name = name_string.toUpperCase().equals(this.title.toUpperCase());
        boolean date = date_string.equals(localDate.toString());
        if ( (date)&&(name)){
            points.click();

    }
}
}catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

}
@And("photographer choose edit")
public void choose_edit(){
        new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(4))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("testEdit")));
        this.driver.getWebDriver().findElement(By.id("testEdit")).click();;
}
@And("photographer should change the title of event as {string}")
public void change_name_of_event (String newname){
    new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(4))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("event-title")));
    WebElement titles = this.driver.getWebDriver().findElement(By.id("event-title"));
    titles.sendKeys(Keys.CONTROL, "a");
    titles.sendKeys(Keys.DELETE);
    titles.sendKeys(this.new_title);

    // this.driver.getWebDriver().findElement(By.id("test123")).click();

}
@Then("title of event is updated")
public void title_is_updated(){
    try{
        Thread.sleep(3000);
        boolean found = false;
        LocalDate localDate = LocalDate.now();
        
        List<WebElement> eventNames =this.driver.getWebDriver().findElements(By.id("event-name"));
        // List<WebElement> eventLocation =this.driver.getWebDriver().findElements(By.id("event-location"));
        List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
        // List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
        
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText();
      ;
            //  String location_string = eventLocation.get(i).getText();
            boolean name = name_string.toUpperCase().equals(this.new_title.toUpperCase());
            boolean old_name = name_string.toUpperCase().equals(this.title.toUpperCase());
            // boolean location = location_string.toUpperCase().equals(location_of_event.toUpperCase());
            boolean date = eventDate.get(i).getText().equals(localDate.toString());
            // boolean status = eventStatus.get(i).getText().equals("In progress");
            if ((name) && (date) && (!old_name)) {
                found = true;
                break;
            }
        }
       
       
        Assert.assertTrue(found);
        // System.out.println(found);
        // System.out.println("test pass");
                        
        
        this.driver.getWebDriver().quit();

    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     

}
 @And("photographer should fill the location of event")
    public void photographer_should_fill_the_location_of_event() {
        try {
            Thread.sleep(50);
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("location")));
            this.driver.getWebDriver().findElement(By.id("location")).sendKeys(this.location);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
@And("photographer should change the location of event")
public void change_location_of_event (){
    new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(4))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("location")));
    WebElement titles = this.driver.getWebDriver().findElement(By.id("location"));
    titles.sendKeys(Keys.CONTROL, "a");
    titles.sendKeys(Keys.DELETE);
    titles.sendKeys(this.new_location);
    // this.driver.getWebDriver().findElement(By.id("test123")).click();

}
@Then("location of event is updated")
public void location_is_updated(){
    try{
        Thread.sleep(3000);
        boolean found = false;
        LocalDate localDate = LocalDate.now();
        
        List<WebElement> eventNames =this.driver.getWebDriver().findElements(By.id("event-name"));
        List<WebElement> eventLocation =this.driver.getWebDriver().findElements(By.id("event-location"));
        List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
        // List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
        
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText();
      
            String location_string = eventLocation.get(i).getText();
            boolean name = name_string.toUpperCase().equals(this.title.toUpperCase());
            // boolean old_name = name_string.toUpperCase().equals(this.title.toUpperCase());
            boolean location = location_string.toUpperCase().equals(this.new_location.toUpperCase());
            boolean date = eventDate.get(i).getText().equals(localDate.toString());
            // boolean status = eventStatus.get(i).getText().equals("In progress");
            if ((name) && (date) && (location)) {
                found = true;
                break;
            }
        }
       
       
        Assert.assertTrue(found);
        // System.out.println(found);
        // System.out.println("test pass");
                        
        
        this.driver.getWebDriver().quit();

    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     

}
@And("photographer should change the date of event")
public void change_date_of_event (){

    RandomDateGenerator generateur = new RandomDateGenerator();
    this.randomeDate = generateur.generateRandomDate(2023,2024);
    new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(4))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("testEventDate")));
    WebElement titles = this.driver.getWebDriver().findElement(By.id("testEventDate"));
    titles.sendKeys(Keys.CONTROL, "a");
    titles.sendKeys(Keys.DELETE);
    titles.sendKeys(this.randomeDate);
    titles.sendKeys(Keys.ENTER);
    System.out.println(this.randomeDate);

    // this.driver.getWebDriver().findElement(By.id("test123")).click();

}
    @And("photographer click on the button of ok")
    public void photographer_should_click_on_the_button_ok() {
        try {
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("test123")).click();
            
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
@Then("date of event is updated")
public void date_is_updated(){
    try{
        Thread.sleep(3000);
        boolean found = false;
        // LocalDate localDate = LocalDate.now();
        
        List<WebElement> eventNames =this.driver.getWebDriver().findElements(By.id("event-name"));
        List<WebElement> eventLocation =this.driver.getWebDriver().findElements(By.id("event-location"));
        List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
        // List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
        System.out.println(this.randomeDate);
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText();
      
            String location_string = eventLocation.get(i).getText();
            boolean name = name_string.toUpperCase().equals(this.title.toUpperCase());
            // boolean old_name = name_string.toUpperCase().equals(this.title.toUpperCase());
            boolean location = location_string.toUpperCase().equals(this.location.toUpperCase());
            boolean date = eventDate.get(i).getText().equals(this.randomeDate);
            // boolean status = eventStatus.get(i).getText().equals("In progress");
            if ((name) && (date) && (location)) {
                found = true;
                break;
            }
        }
       
       
        Assert.assertTrue(found);
        // System.out.println(found);
        // System.out.println(randomeDate.toString());
        // System.out.println("test pass");
                        
        
        this.driver.getWebDriver().quit();

    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     

}
@Then("details of event is updated")
public void details_is_updated(){
    try{
        Thread.sleep(3000);
        boolean found = false;
        // LocalDate localDate = LocalDate.now();
        
        List<WebElement> eventNames =this.driver.getWebDriver().findElements(By.id("event-name"));
        List<WebElement> eventLocation =this.driver.getWebDriver().findElements(By.id("event-location"));
        List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
        // List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
        System.out.println(this.randomeDate);
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText();
      
            String location_string = eventLocation.get(i).getText();
            boolean name = name_string.toUpperCase().equals(this.new_title.toUpperCase());
            // boolean old_name = name_string.toUpperCase().equals(this.title.toUpperCase());
            boolean location = location_string.toUpperCase().equals(this.new_location.toUpperCase());
            boolean date = eventDate.get(i).getText().equals(this.randomeDate);
            // boolean status = eventStatus.get(i).getText().equals("In progress");
            if ((name) && (date) && (location)) {
                found = true;
                break;
            }
        }
       
       
        Assert.assertTrue(found);
        // System.out.println(found);
        // System.out.println(randomeDate.toString());
        // System.out.println("test pass");
                        
        
        this.driver.getWebDriver().quit();

    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     

}





}
