package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features" , glue = "steps" , plugin = {"pretty","html:target/reports"}, dryRun = true )

public class test_runner {
}
