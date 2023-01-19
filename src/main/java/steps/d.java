import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//package steps;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.Locale;
//import java.util.logging.Logger;
//
public class d {
   public static void main(String[] args) {
       try {
           WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           Thread.sleep(5000);
           driver.switchTo().newWindow(WindowType.TAB);
           driver.navigate().to("https://www.google.com/search?q=gmail&oq=gmail&aqs=chrome..69i57j0i131i433j0i131i433i512l5j69i60.2112j0j7&sourceid=chrome&ie=UTF-8");
           Thread.sleep(2000);
           driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/a/h3")).click();
           Thread.sleep(3000);
           driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
           driver.findElement(By.id("identifierId")).sendKeys("a.aouadi@coral-io.fr");
           Thread.sleep(2000);
           driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
           Thread.sleep(3000);
           driver.findElement(By.name("Passwd")).sendKeys("Aziz1996@");
           Thread.sleep(3000);
           driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
           WebElement unreadEmail = driver.findElement(By.className("zE"));
           System.out.println(unreadEmail);
           unreadEmail.click();
           Thread.sleep(2000);
           System.out.println(1);
           WebElement link = driver.findElement(By.partialLinkText("https://recette.uwas.fr/change-password/"));
           System.out.println(link);
           driver.get(link.getText());
           /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
           driver.get(link.getText());*/
       } catch (InterruptedException e) {
            throw new RuntimeException(e);
       }

       /*WebDriver driver;
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.browserstack.com/users/sign_in");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement email = driver.findElement(By.id("user_email_login"));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement password = driver.findElement(By.id("user_password"));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       email.sendKeys("a.aouadi@coral-io.fr");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       password.sendKeys("Aziz1996@");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.findElement(By.name("terms_and_conditions")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.findElement(By.name("commit")).click();

       String txt ="Hello ";
       System.out.println(txt);
       System.out.println(txt.toUpperCase());
       System.out.println(txt.toLowerCase());*/
//        try {
//            WebDriver driver;
//
//            String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
//
//            System.out.println(mydate);
//            LocalDate localDate = LocalDate.now();
//            System.out.println(localDate);
//            boolean rst = false ;
//            if (("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU").contentEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU")) {
//                rst = true ;
//
//            }
//            System.out.println(rst);
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://recette.uwas.fr/login");
//            Thread.sleep(10000);
//            driver.findElement(By.id("normal_login_email")).sendKeys("azizaouadi12@gmail.com");
//            Thread.sleep(3000);
//            driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();
//            Thread.sleep(6000);
//            WebElement im = driver.findElement(By.className("ant-card-cover"));
//            im = im.findElement(By.tagName("img"));
//            Thread.sleep(3000);
//            System.out.println(im.getTagName());
//            String src_im = im.getAttribute("src");
//            System.out.printf(src_im);
//
//
//        }catch (InterruptedException e) {
//            throw new RuntimeException(e);
    }
//
//
//
//
//
}






