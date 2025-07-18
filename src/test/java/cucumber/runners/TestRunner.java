package cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"cucumber.stepdefintions", "setup"},
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html", "json:target/cucumber-reports/cucumber-report.json"}
)

public class TestRunner {

}
