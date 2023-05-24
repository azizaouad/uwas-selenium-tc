package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={ "@target/failedrun.txt"}
        ,glue = "stepDefinitions",
        plugin = {"pretty","html:target1/reports/report.html","json:target1/reports/report.json"}

)
public class TestRunnerRerun {

}
