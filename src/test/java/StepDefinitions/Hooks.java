package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks extends CommonMethods {

    @Before
    public void preCondition() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void postCondition(Scenario scenario){
        //scenario class holds the complete information of your tests execution in cucumber framework
        //"Scenario" class provides a useful way to interact with the current test scenario during test execution,
        // and to add additional information and artifacts to the test report for better documentation
        // and analysis of the test results.
        byte[] pic;
        if(scenario.isFailed()){
            //failed screenshot will be available inside failed folder
            pic=takeScreenshot("failed/"+scenario.getName());
        }else{
            pic=takeScreenshot("passed/"+scenario.getName());
        }
        //attach the screenshot into report
        scenario.attach(pic,"image/png",scenario.getName());





        closeBrowser();
    }





}
