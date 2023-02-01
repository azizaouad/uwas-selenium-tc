package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features" , glue = "steps" , plugin = {"pretty","html:target/reports/report.html","json:target/reports/report.json"} )

public class test_runner {
}
