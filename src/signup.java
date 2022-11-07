import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class signup {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://recette.uwas.fr/login");
        Thread.sleep(20000);
        driver.findElement(By.linkText("Sign up now!")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("normal_login_first_name")).sendKeys("tester");
        Thread.sleep(5000);
        driver.findElement(By.id("normal_login_last_name")).sendKeys("tester");
        Thread.sleep(5000);
        driver.findElement(By.id("normal_login_email")).sendKeys("tester1@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
        Thread.sleep(5000);
        driver.findElement(By.id("normal_login_confirmPassword")).sendKeys("Aziz1996@");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[9]/div/div/div/div/button/span")).click();
        Thread.sleep(5000);
        String url = driver.getCurrentUrl() ;
        if (url.contentEquals("https://recette.uwas.fr/login") ) {

            System.out.println("succes to sign up");
        }

        else {
            System.out.println("fail to sign up");
        }




    }

}




