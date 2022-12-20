package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Logger;

public class d {
    public static void main(String[] args) {
        try {
            WebDriver driver;

            String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

            System.out.println(mydate);
            LocalDate localDate = LocalDate.now();
            System.out.println(localDate);
            boolean rst = false ;
            if (("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU").contentEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU")) {
                rst = true ;

            }
            System.out.println(rst);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(10000);
            driver.findElement(By.id("normal_login_email")).sendKeys("azizaouadi12@gmail.com");
            Thread.sleep(3000);
            driver.findElement(By.id("normal_login_password")).sendKeys("Aziz1996@");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[6]/div/div/div/div/button/span")).click();
            Thread.sleep(6000);
            WebElement im = driver.findElement(By.className("ant-card-cover"));
            im = im.findElement(By.tagName("img"));
            Thread.sleep(3000);
            System.out.println(im.getTagName());
            String src_im = im.getAttribute("src");
            System.out.printf(src_im);


        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }






    }





}
