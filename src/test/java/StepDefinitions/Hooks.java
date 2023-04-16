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
        byte[] pic;
        if(scenario.isFailed()){
            pic=takeScreenshot("failed/"+scenario.getName());
        }else{
            pic=takeScreenshot("passed/"+scenario.getName());
        }
        //attach the screenshot in my report
        scenario.attach(pic,"image/png",scenario.getName());





        closeBrowser();
    }





}
