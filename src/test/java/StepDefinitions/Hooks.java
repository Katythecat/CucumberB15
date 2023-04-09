package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends CommonMethods {

    @Before
    public void preCondition() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void postCondition(){
        closeBrowser();
    }





}
