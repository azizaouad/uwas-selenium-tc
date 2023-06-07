package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uwas.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    Driver driver;

    public Hooks(Driver driver) {

        this.driver = driver;
        this.driver.setupController();

    }

    @Before   
    public void RunBeforeAnyScenario(){
        System.out.println("before");
        try {
            String processName = "chromedriver.exe";
            ProcessBuilder processBuilder = new ProcessBuilder("taskkill", "/F", "/IM", processName + "*");
            Process process = processBuilder.start();
            process.waitFor();

            System.out.println("ChromeDriver process has been terminated.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
       
        //  try {
        //     ProcessBuilder processBuilder = new ProcessBuilder("pgrep", "chromedriver");
        //     Process process = processBuilder.start();
        //     process.waitFor();

        //     java.io.InputStream inputStream = process.getInputStream();
        //     java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
        //     String output = scanner.hasNext() ? scanner.next() : "";

        //     String[] pids = output.split("\\r?\\n");

        //     for (String pid : pids) {
        //         Process killProcess = Runtime.getRuntime().exec("kill -9 " + pid);
        //         killProcess.waitFor();
        //     }

        //     System.out.println("ChromeDriver processes killed successfully.");
        // } catch (IOException | InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
          
        
        
        
    
    
    @After
    public void RunAfterAnyScenario(){
        System.out.println("after");
        try {
            String processName = "chromedriver.exe";
            ProcessBuilder processBuilder = new ProcessBuilder("taskkill", "/F", "/IM", processName + "*");
            Process process = processBuilder.start();
            process.waitFor();

            System.out.println("ChromeDriver process has been terminated.");
               
            

            // // Check if ChromeDriver is open
            // boolean isChromeDriverOpen = ((Process) driver.getWebDriver()).isAlive();

            // // Output the result
            // if (isChromeDriverOpen) {
            //     System.out.println("ChromeDriver is open.");
            //     driver.getWebDriver().quit();
            // } else {
            //     System.out.println("ChromeDriver is not open.");
            // }

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
//         try {
//             ProcessBuilder processBuilder = new ProcessBuilder("pgrep", "chromedriver");
//             Process process = processBuilder.start();
//             process.waitFor();

//             java.io.InputStream inputStream = process.getInputStream();
//             java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
//             String output = scanner.hasNext() ? scanner.next() : "";

//             String[] pids = output.split("\\r?\\n");

//             for (String pid : pids) {
//                 Process killProcess = Runtime.getRuntime().exec("kill -9 " + pid);
//                 killProcess.waitFor();
//             }

//             System.out.println("ChromeDriver processes killed successfully.");
//         } catch (IOException | InterruptedException e) {
//             e.printStackTrace();
//         }
    }
 }