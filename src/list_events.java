import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class list_events {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://recette.uwas.fr/login");
        Thread.sleep(20000);
        driver.findElement(By.id("normal_login_email")).sendKeys("qaautomation@gmail.com");
        driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
        driver.findElement(By.className("login-form-button")).click();
        Thread.sleep(7000);
        String url = driver.getCurrentUrl() ;
        if (((String) url).contentEquals("https://recette.uwas.fr/events"))
        {
            System.out.println("success to login ");
        }
        else{
            System.out.println("fail to login ");
        }
        Thread.sleep(8000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/main/section[1]/div/div/div[1]/h1/button/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("name")).sendKeys("JaVa test event ");
        Thread.sleep(5000);
        driver.findElement(By.id("location")).sendKeys( "madrid");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")).click();
        Thread.sleep(5000);
        String event ;
        String location ;
        ArrayList<WebElement> events;
        ArrayList<WebElement> locations;
        events = (ArrayList<WebElement>) driver.findElements(By.className("mx-auto"));
        locations = (ArrayList<WebElement>) driver.findElements(By.className("mr-5"));
        System.out.println("la liste des événements :");
//        for  (int i=0; i<events.size(); i++)
//        {
//            System.out.println((events.get(i).getText()));
//            System.out.println(locations.get(i).getText());
//        }
        String Newligne=System.getProperty("line.separator");

        ArrayList<WebElement> cards = (ArrayList<WebElement>) driver.findElements(By.className("ant-card-bordered"));
        for (int i=0; i<cards.size(); i++){
            String event_text= cards.get(i).findElement(By.className("mx-auto")).getText();
            String event_location = cards.get(i).findElement(By.className("mr-5")).getText();
            System.out.println("event: "+ event_text + Newligne +"location: "+ event_location);

        }
        driver.findElement(By.className("ant-card-cover"));

    }
}