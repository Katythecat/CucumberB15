package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AddEmployee extends CommonMethods {



    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        doClick(addEmployeePage.pimTab);
       // System.out.println(10/0);

    }
    @When("user click on Add employee button")
    public void user_click_on_add_employee_button() {
        doClick(addEmployeePage.addEmpBtn);


    }
    @When("user enters firstname and middle and lastname")
    public void user_enters_firstname_and_middle_and_lastname() {

        sendText(addEmployeePage.firstnameTextBox,ConfigReader.getPropertyValue("firstname"));
        sendText(addEmployeePage.middlenameTextBox,ConfigReader.getPropertyValue("middlename"));
        sendText(addEmployeePage.lastnameTextBox,ConfigReader.getPropertyValue("lastname"));


    }
    @When("user click on save button")
    public void user_click_on_save_button() {

        doClick(addEmployeePage.saveBtn);


    }
}
