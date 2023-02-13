package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.security.Key;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

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
            driver.get("https://recette.uwas.fr/login");
            Thread.sleep(20000);
            String email = "a.aouadi@coral-io.fr";
            String password = "Aziz1996@!!";
            driver.findElement(By.id("normal_login_email")).sendKeys(email);
            Thread.sleep(2000);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.id("testLogin")).click();
            Thread.sleep(10000);
//            LocalDate startDate = LocalDate.of(2015, 2, 20);
//           LocalDate endDate = LocalDate.of(2017, 1, 15);





//            Thread.sleep(1000);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//            String input = "2022-06-30";
//            LocalDate date = LocalDate.parse(input);
//            System.out.println(date.plusDays(2));
//            System.out.println(date.minusDays(2));
//            LocalDate localDate = LocalDate.now();
//            String input = localDate.toString();
//            String format = "yyyy-MM-dd";
//
//            SimpleDateFormat df = new SimpleDateFormat(format);
//            Date date = df.parse(input);
//
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            int week = cal.get(Calendar.WEEK_OF_YEAR);
//            System.out.println(week);
//
//            String[] days = new DateFormatSymbols().getWeekdays();
//            if (localDate.toString().contentEquals("lundi")){
//                System.out.println(1);
//            }
//            else {
//                System.out.println(2);
//            }
//            for (int i = 0; i < days.length; i++) {
//                String weekday = days[i];
//                System.out.println(weekday);
//            }
//
//
//
//            Calendar c = Calendar.getInstance();
//            c.setTime(new Date());
//            System.out.println(c.get(Calendar.DAY_OF_MONTH));
//            System.out.println(c.get(Calendar.DAY_OF_WEEK));
//            int mondayNo = c.get(Calendar.DAY_OF_MONTH)-c.get(Calendar.DAY_OF_WEEK)+2;
//            c.set(Calendar.DAY_OF_MONTH,mondayNo);
//            System.out.println("Date "+c.getFirstDayOfWeek());
//            int sundayNo = mondayNo+6;
//            System.out.println(sundayNo);
//            SimpleDateFormat f = new SimpleDateFormat("EEEE");
//            String dateset = "2023-02-12";
//            String dayname = f.format(new Date());
//            System.out.println(dayname);

//            Date startInterval = sdf.parse("2022-06-01");
//            Date endInterval = sdf.parse("2022-06-30");
//            if ((date.after(startInterval)) && (date.before(endInterval))) {
//                System.out.println("Date is  in the interval");
//            } else {
//                System.out.println("Date is not in the interval");
//            }
//            System.out.println("startdate : "+ startInterval);
//            System.out.println("enddate : "+ endInterval);
//            System.out.println("thedate : "+ date);
//            String ch1  = "https://recette.uwas.fr/register?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzZTBmZWZjNzRkYjc5YWU3Nzk1MThiNiIsImlhdCI6MTY3NTY5MDc5MiwiZXhwIjoxNjc2Mjk1NTkyfQ.qcgq6My1wXpOgcbJDitsyV8JWUXlFpLCHHtH0QPd11g";
//            String ch2  = "https://recette.uwas.fr/register?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzZTBmZWZjNzRkYjc5YWU3Nzk1MThiNiIsImlhdCI6MTY3NTY5MDc0NywiZXhwIjoxNjc2Mjk1NTQ3fQ.rWRjntZfAsuj0xXlxMn19Kkgo-9BzhLWUYyBQZCGAIk";
//            if (ch2.contentEquals(ch2)){
//                boolean find ;
//                find = true ;
//                System.out.println(find);
//            }

//            Thread.sleep(10000);
//            driver.findElement(By.className("ant-collapse-header")).click();
//            Thread.sleep(5000);
//            driver.findElement(By.id("eventDateFilter")).sendKeys("2023-01-01");
//            Thread.sleep(5000);
//            driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[1]/div/div/div[2]/div/form/div/div[3]/div/div[3]/input")).sendKeys("2023-02-01");
//            Thread.sleep(5000);
//            driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[1]/div/div/div[2]/div/form/div/div[3]/div/div[3]/input")).sendKeys(Keys.ENTER);
//            Thread.sleep(5000);
//            driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[1]/div/div/div[2]/div/form/div/div[5]/button")).click();
//            Thread.sleep(8000);




          /* Thread.sleep(5000);
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
     /*  } catch (InterruptedException e) {
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


//            Thread.sleep(5000);
//            driver.switchTo().newWindow(WindowType.TAB);
//            driver.navigate().to("https://www.google.com/intl/fr/gmail/about/");
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
//            driver.findElement(By.id("identifierId")).sendKeys("a.aouadi@coral-io.fr");
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
//            Thread.sleep(3000);
//            driver.findElement(By.name("Passwd")).sendKeys("Aziz1996@");
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();
//            Thread.sleep(5000);
//            WebElement unreadEmail = driver.findElement(By.className("zE"));
//            unreadEmail.click();
//            Thread.sleep(2000);
//            WebElement link = driver.findElement(By.partialLinkText("https://recette.uwas.fr/change-password/"));
//            Thread.sleep(5000);
//            driver.navigate().to(link.getText());

           // driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/div/button[2]")).click();
//
//
//            LocalDate date = LocalDate.now();
//            System.out.println("Date = " + date);
//            LocalDate start = date;
//            while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
//                start = start.minusDays(1);
//            }
//            System.out.println("Start of the Week = " + start);
//            LocalDate end = date;
//            while (end.getDayOfWeek() != DayOfWeek.SUNDAY) {
//                end = end.plusDays(1);
//            }
//            System.out.println("End of the Week = " + end);
//
//            Date d=new Date();
//            int numofthemonth = d.getMonth()+1;
//            System.out.println("Month of the year is  : "+numofthemonth);
//            Month currentMonth = date.getMonth();
//            System.out.println("Current month: "+currentMonth);
//            LocalDate today = LocalDate.now();
//            System.out.println("First day: " + today.withDayOfMonth(1));
//            System.out.println("Last day: " + today.withDayOfMonth(today.lengthOfMonth()));
//            LocalDate firstday = LocalDate.parse(today.withDayOfMonth(1).toString());
//            LocalDate lastday = LocalDate.parse(today.withDayOfMonth(today.lengthOfMonth()).toString());
//            if ( today.isBefore(firstday.minusDays(1))||today.isAfter(lastday.plusDays(1))){
//                System.out.println("not");
//
//            }
//            else {
//                System.out.println("on the month");
//
//   /
            driver.findElement(By.className("ant-collapse-item")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("eventFilterViewed")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("eventFilterEventsBTN")).click();
            Thread.sleep(3000);
            Thread.sleep(5000);
            List<WebElement> eventNames = driver.findElements(By.className("eventDetails__bottom-name"));
            List<WebElement> evnetViewed = driver.findElements(By.className("viewed"));
            boolean find = false;
            int no_event = eventNames.size();
            System.out.println("number of filtred events" + no_event);
            if (no_event==0) {
                find = true;
                System.out.println("no event this year");
            }
            else {
                if (no_event == evnetViewed.size()){
                    System.out.println(find);
                    find = true ;
                    System.out.println(find);
                }
            }
            Assert.assertTrue(find);
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
//
//
//
//
//







