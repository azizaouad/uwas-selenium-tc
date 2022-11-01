import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Coralio software\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            driver.findElement(By.linkText("Sign up now!")).click();
            Thread.sleep(5000);
            driver.navigate().back();
            Thread.sleep(5000);
            driver.navigate().forward();
            driver.navigate().to("https://recette.uwas.fr/login");
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_email")).sendKeys("ph@gmail.com");
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
            driver.findElement(By.xpath("/html/body/div/div/div[2]/main/section[1]/div/div/div[1]/h1/button/span")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("name")).sendKeys("selenium java");
            Thread.sleep(5000);
            driver.findElement(By.id("location")).sendKeys("lac 1 ");
            Thread.sleep(5000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]/span")).click();





        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
