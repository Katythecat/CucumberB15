package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "APIStepDefinitions",
        dryRun=false,
        tags= "@Updateemployee",
        plugin={"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
                "rerun:target/failed.txt"})

public class APIRunner {
}
