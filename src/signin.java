import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class signin {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://recette.uwas.fr/login");
        Thread.sleep(20000);
        driver.findElement(By.id("normal_login_email")).sendKeys("tester1@gmail.com");
        Thread.sleep(4000);
        driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();
        Thread.sleep(10000);
        String current_url = driver.getCurrentUrl();
        if (current_url.contentEquals("https://recette.uwas.fr/login")) {
            System.out.println("fail to login");
        } else {
            System.out.println("success to login");
        }
    }
}
