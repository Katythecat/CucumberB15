package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        doClick(addEmployeePage.pimTab);
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
        Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
        System.out.println("My assertion is returning ture");
        doClick(addEmployeePage.saveBtn);
    }
    @When("user enter {string} and {string} and {string}")
    public void user_enter_and_and(String fname, String mname, String lname) {
        sendText(addEmployeePage.firstnameTextBox,fname);
        sendText(addEmployeePage.middlenameTextBox,mname);
        sendText(addEmployeePage.lastnameTextBox,lname);
    }
    @When("user captures teh employee id")
    public void user_captures_teh_employee_id() {
        GlobalVariables.emp_id=addEmployeePage.empIDlocator.getAttribute("value");
        System.out.println("The emp id is "+GlobalVariables.emp_id);

    }
    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id='"+GlobalVariables.emp_id+"'";
        //to store the table coming from db, we used global variable here
        //in this variable we got all the keys and values for the emp we searched
        GlobalVariables.tableData=DBUtility.getListOfMapsFromRset(query);


    }
    @Then("verify the result from frontend and backend")
    public void verify_the_result_form_frontend_and_backend() {
        String fNameFromDB=GlobalVariables.tableData.get(0).get("emp_firstname"); //0 mean first row after header
        System.out.println(fNameFromDB);
        String lNameFromDB=GlobalVariables.tableData.get(0).get("emp_lastname");
        System.out.println(lNameFromDB);

        //adding assertion
        Assert.assertEquals(fNameFromDB,"nesha");
        Assert.assertEquals(lNameFromDB,"standart");
        System.out.println("My assertion has passed my test case");


    }

}
