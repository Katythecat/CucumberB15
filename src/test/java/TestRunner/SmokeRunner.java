package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "StepDefinitions",
        dryRun=false,
        tags= "@test",
        //"plugin" option is used to specify the formatting options for the output of the test results.
        plugin={"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
        //this failed.txt file holds all the scenarios which are failed  during execution
        "rerun:target/failed.txt"},

        //we can use like this tags="@testcase1 or @testcase2" to run both of them
        //to remove irrelavant information from console, you need to set monochrome to true
        monochrome=false

        //pretty keywords prints the steps in the console to increase readability
        //to generate the reports we need plugin of runner class





)

public class SmokeRunner {
}
//dryRun = true --> it will only check which step in feature file does not execute for you
//and then it will generate only the code for you
//dryRun = false --> after auto generate the code and paste already come back to change to false