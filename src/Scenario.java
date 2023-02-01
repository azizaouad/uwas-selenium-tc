import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Scenario {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver ;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://recette.uwas.fr/login");
        Thread.sleep(20000);
        driver.findElement(By.id("normal_login_email")).sendKeys("qa@gmail.com");
        Thread.sleep(4000);
        driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
        Thread.sleep(4000);
        driver.findElement(By.id("test123")).click();
        Thread.sleep(10000);
        boolean succes_login = false ;
        String current_url = driver.getCurrentUrl();
        if (current_url.contentEquals("https://recette.uwas.fr/login")) {
            System.out.println("fail to login");
        } else {
            System.out.println("success to login");
            succes_login = true ;
        }
//        if (succes_login = true) {
//            add_event_button = driver
//
//        }
    }
}
