package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;
//    import java.util.Random;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;


public class archive_event {
    Driver driver;
    private String randomName = RandomNameGenerator.getConstantRandomName();
    // private String randomName;
    // String title 

    public archive_event(Driver driver) {
        this.driver = driver;
        this.driver.setupController();
        // this.title = addRandomCharacter("test-archive");
    }



        


    @Given("photographer should login with his credentials email as {string} and password as {string} and create an event")
    public void photographer_should_login( String email , String password ) {
        try {
            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            WebDriverWait wait = new  WebDriverWait (driver.getWebDriver(),Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);

            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));

            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("event-add")));
            this.driver.getWebDriver().findElement(By.id("event-add")).click();
            wait.pollingEvery(Duration.ofMillis(500));            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("event-title")));

            this.driver.getWebDriver().findElement(By.id("event-title")).sendKeys(randomName);
            Thread.sleep(10);

            this.driver.getWebDriver().findElement(By.id("test123")).click();
            // System.out.println(randomName);
    }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @When("photographer click on the three buttouns")
    public void photographer_click_on_the_three_buttouns_of_the_event_he_wants_to_archive (){


    }

    @And("Choose archive the event")
    public void Choose_archive (){
        try {

//            WebElement ele = driver.findElement(By.className("ant-btn-icon-only"));
//            Actions action = new Actions(driver);
           Thread.sleep(3000);
//            action.moveToElement(ele).build().perform();
        //    new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
        //    .until(ExpectedConditions.visibilityOfElementLocated(By.id("event-edit-dropdown")));
            //driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[2]/div/div/div[7]/div[2]/div[1]/button[2]/span/svg")).click();
           WebElement points=this.driver.getWebDriver().findElement(By.id("event-edit-dropdown"));
           List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
        //List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("even-location"));
           List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
           LocalDate localDate = LocalDate.now();
           if (eventNames.size() == 0 ){
                System.out.println("no event for archive");


           }else {
                for (int i=0 ; i < eventNames.size(); i++){
                String name_string = eventNames.get(i).getText() ;
                String date_string = eventDate.get(i).getText();
                // System.out.println(name_string);
                // System.out.println(date_string);
                boolean name = name_string.toUpperCase().equals(randomName.toUpperCase());
                boolean date = date_string.equals(localDate.toString());
                if ( (date)&&(name)){
                    points.click();
                    WebDriverWait wait = new  WebDriverWait (driver.getWebDriver(),Duration.ofSeconds(15));
                    wait.pollingEvery(Duration.ofMillis(500));
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("testArchive")));
                    driver.getWebDriver().findElement(By.id("testArchive")).click();
                    wait.pollingEvery(Duration.ofMillis(500));
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("testOKArchive")));
                    driver.getWebDriver().findElement(By.id("testOKArchive")).click();
                    Thread.sleep(3000);
                    break;
                }
                
          
           }

           }
        
           
           
          
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the event is archived")
    public void the_event_is_archived () throws InterruptedException {
        // System.out.println(this.title);

        this.driver.getWebDriver().findElement(By.id("dropdown-event-link")).click();
        WebDriverWait wait = new  WebDriverWait (driver.getWebDriver(),Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofMillis(500));            
        wait.until(ExpectedConditions.elementToBeClickable(By.id("event-archive")));
        this.driver.getWebDriver().findElement(By.id("event-archive")).click();;   
        // boolean found = false;
        int obtainedresult = 0 ;
        int expectedresult = 1 ;
        Thread.sleep(2000);
        // String CurrentUrl = this.driver.getWebDriver().getCurrentUrl(); 
        // System.out.println(CurrentUrl);
        List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
        //List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("even-location"));
        List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
        //List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
        LocalDate localDate = LocalDate.now();
        // System.out.println(localDate.toString());
        for (int i = 0; i < eventNames.size(); i++) {
            String name_string = eventNames.get(i).getText() ;
            String date_string = eventDate.get(i).getText();
            // System.out.println(name_string);
            // System.out.println(date_string);
            boolean name = name_string.toUpperCase().equals(randomName.toUpperCase());
            boolean date = date_string.equals(localDate.toString());
            // boolean url = CurrentUrl.equals("https://recette.uwas.fr/photographer/events/archive");
            if ((name) && (date)) {
                obtainedresult = 1 ;
                break;
            }
        }
        Assert.assertEquals(expectedresult, obtainedresult);
        

        this.driver.getWebDriver().quit();
    }

    @When("photographer should go to the archive event")
    public void photographer_should_go_to_the_archive_event (){
        try {
            WebDriverWait wait = new  WebDriverWait (driver.getWebDriver(),Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown-event-link")));
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            wait.pollingEvery(Duration.ofMillis(500));            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("event-archive")));
            WebElement List = this.driver.getWebDriver().findElement(By.id("event-archive"));
            List.click();
            Thread.sleep(3000);



        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    @And("Choose restore the event")
    public void Choose_restore_for_the_event () {
        try {

            List <WebElement> points = this.driver.getWebDriver().findElements(By.id("event-edit-dropdown"));
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            //List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            LocalDate localDate = LocalDate.now();
            if (eventNames.size() == 0){
                System.out.println("no event for restore ");
            }
            else {
                for ( int i =0 ; i<eventNames.size() ; i++ ) {
                String name_string = eventNames.get(i).getText() ;
                String date_string = eventDate.get(i).getText();
                boolean name = name_string.toUpperCase().equals(randomName.toUpperCase());
                boolean date = date_string.equals(localDate.toString());
                if ((name)&&(date)){
                    Thread.sleep(100);
                    points.get(i).click();
                    WebDriverWait wait = new  WebDriverWait (driver.getWebDriver(),Duration.ofSeconds(15));
                    wait.pollingEvery(Duration.ofMillis(500));                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("testRestore")));
                    WebElement restore = this.driver.getWebDriver().findElement(By.id("testRestore"));
                    restore.click();
                    break;
                    }
                }

            }
            Thread.sleep(1000);

            




        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the event is restored")
    public void the_event_is_restored () {
        try {
            this.driver.getWebDriver().findElement(By.xpath("/html/body/div/div/main/div/section/main/div[1]/button")).click();
            Thread.sleep(3000);
            // boolean found = false;
            int obtainedresult = 0 ;
            int expectedresult = 1 ;
            // System.out.println(this.title);
            // String currentUrl = this.driver.getWebDriver().getCurrentUrl();
            // System.out.println(currentUrl);
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            //List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            List<WebElement> eventDate =this.driver.getWebDriver().findElements(By.id("event-date"));
            //List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
            LocalDate localDate = LocalDate.now();
            if (eventNames.size()==0){
                obtainedresult = 1 ;
            }
            else {
                for (int i = 0; i < eventNames.size(); i++) {
                    String name_string = eventNames.get(i).getText() ;
                    String date_string = eventDate.get(i).getText();
                    boolean name = name_string.toUpperCase().equals(randomName.toUpperCase());
                    boolean date = date_string.equals(localDate.toString());
                    if ((name) && (date) ) {
                        obtainedresult = 1 ;
                        // System.out.println(name_string);
                        break;
                    }
                }
            }

            
            Assert.assertEquals(expectedresult, obtainedresult);
                

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
            WebDriverWait wait = new  WebDriverWait (driver.getWebDriver(),Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofMillis(500));            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(200);
            // System.out.println(randomName);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
