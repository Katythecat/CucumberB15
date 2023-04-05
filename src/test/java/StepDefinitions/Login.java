package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;



public class Login extends CommonMethods {


    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() throws IOException {

        openBrowserAndLaunchApplication();

    }
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
        //driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));
        WebElement usernameTextBox=driver.findElement(By.id("txtUsername"));
        sendText(usernameTextBox,ConfigReader.getPropertyValue("username"));

        //driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));
        WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));
        sendText(passwordTextBox,ConfigReader.getPropertyValue("password"));
    }
    @When("click on login button")
    public void click_on_login_button() {
        WebElement loginBtn=driver.findElement(By.id("btnLogin"));
        doClick(loginBtn);

    }
    @Then("user is logged in successfully into the application")
    public void user_is_logged_in_successfully() {
        boolean userLoggedIn=driver.findElement(By.id("welcome")).isDisplayed();
        if(userLoggedIn){
            System.out.println("User is logged in successfully");
        }

    }
    @Then("Close the browser")
    public void close_the_browser() {
        closeBrowser();
    }

}
