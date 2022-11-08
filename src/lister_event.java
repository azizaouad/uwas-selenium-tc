import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;


public class Archive_event {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://recette.uwas.fr/login");
        Thread.sleep(20000);
        driver.findElement(By.id("normal_login_email")).sendKeys("qa@gmail.com");
        driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
        driver.findElement(By.className("login-form-button")).click();
        Thread.sleep(7000);
        String url = driver.getCurrentUrl() ;
        if (((String) url).contentEquals("https://recette.uwas.fr/events"))
        {
            System.out.println("succes to login ");
        }
        else{
            System.out.println("fail to login ");
        }
        Thread.sleep(8000);
        //driver.findElement(By.xpath("/html/body/div/div/div[2]/main/section[1]/div/div/div[1]/h1/button/span")).click();
        //Thread.sleep(5000);
        //driver.findElement(By.id("name")).sendKeys("selenium 04 test ");
        //Thread.sleep(5000);
        //driver.findElement(By.id("location")).sendKeys( "");
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")).click();
        ///Thread.sleep(5000);
        String event ;
        ArrayList<WebElement> events;
        events = (ArrayList<WebElement>) driver.findElements(By.className("mx-auto"));
        System.out.println("la liste des événements :");
        for (int i=0; i<events.size(); i++) {


            System.out.println((events.get(i).getText()));
        }

    }
}