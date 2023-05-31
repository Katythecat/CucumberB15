package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        WebElement empID=driver.findElement(By.id("empsearch_id"));
        sendText(empID, ConfigReader.getPropertyValue("empId"));

    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
        WebElement clickBtn=driver.findElement(By.id("searchBtn"));
        doClick(clickBtn);

    }
    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is displayed");
        //System.out.println(10/0);

    }

    @When("user select job title")
    public void user_select_job_title() {
        WebElement jobTitle=driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(jobTitle,ConfigReader.getPropertyValue("jobtitle"));

        WebElement EmpStatusDdl= driver.findElement(By.id("empsearch_employee_status"));
        selectByOptions(EmpStatusDdl, "Active");

        WebElement includeDdl= driver.findElement(By.id("empsearch_termination"));
        selectByOptions(includeDdl, "Current and Past Employees");
    }


}
