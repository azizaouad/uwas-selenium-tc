import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
public class Performance {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://recette.uwas.fr/login");
        Thread.sleep(20000);

        //signup


        for (char c = 'a'; c <= 'z'; c++) {

            driver.findElement(By.linkText("Sign up now!")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("normal_login_first_name")).sendKeys(String.valueOf(c)+String.valueOf(c));
            Thread.sleep(5000);
            driver.findElement(By.id("normal_login_last_name")).sendKeys(String.valueOf(c)+String.valueOf(c));
            Thread.sleep(5000);
            driver.findElement(By.id("normal_login_email")).sendKeys(c +"@gmail.com");
            Thread.sleep(5000);
            driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
            Thread.sleep(5000);
            driver.findElement(By.id("normal_login_confirmPassword")).sendKeys("Aziz1996@");
            Thread.sleep(10000);
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[9]/div/div/div/div/button/span")).click();
            Thread.sleep(5000);
        }


        //signin
        for (char c = 'a'; c <= 'z'; c++) {
            driver.findElement(By.id("normal_login_email")).sendKeys(c +"@gmail.com");
            driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
            driver.findElement(By.className("login-form-button")).click();
            Thread.sleep(7000);
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(4000);

        }



    }
}
