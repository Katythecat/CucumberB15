package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",glue = "StepDefinitions",dryRun = false)

public class SmokeRunner {
}
//dryRun = true --> it will only check which step in feature file does not execute for you
//and then it will generate only the code for you
//dryRun = false --> after auto generate the code and paste already come back to change to false