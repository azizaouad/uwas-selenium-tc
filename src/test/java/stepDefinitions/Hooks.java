// package stepDefinitions;



// import org.uwas.Driver;

// import io.cucumber.java.After;
// import io.cucumber.java.Scenario;

// public class Hooks {
//     Driver driver;

//     public Hooks(Driver driver) {

//         this.driver = driver;
//         this.driver.setupController();

//     }
    
//     @After
//     public void teardown(Scenario scenario) {
//         // Code to execute after each scenario
//         System.out.println("Executing teardown for scenario: " + scenario.getName());
        
//         // Close the chromedriver.exe process
//         try {
//             String os = System.getProperty("os.name").toLowerCase();

//             if (os.contains("win")) {
//                 // For Windows
//                 Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//             } 
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
