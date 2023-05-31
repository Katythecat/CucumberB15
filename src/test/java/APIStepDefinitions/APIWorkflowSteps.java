package APIStepDefinitions;

import Utils.APIConstants;
import Utils.APIPayloadConstants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIWorkflowSteps {

    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        request = given().header(APIConstants.HEADER_KEY_CONTENT_TYPE,
                        APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION,
                        GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayload());

    }
    //---------------------------------------------------
    @Given("a request is prepared to create an employee using json payload")
    public void a_request_is_prepared_to_create_an_employee_using_json_payload() {
            request = given().header(APIConstants.HEADER_KEY_CONTENT_TYPE,
                            APIConstants.HEADER_VALUE_CONTENT_TYPE).
                    header(APIConstants.HEADER_KEY_AUTHORIZATION,
                            GenerateTokenSteps.token).
                    body(APIPayloadConstants.createEmployeePayloadJson());

    }
    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);

    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer int1) {
        response.prettyPrint();
        response.then().assertThat().statusCode(int1);

    }

    @Then("the employee contains key {string} and value {string}")
    public void the_employee_contains_key_and_value(String message, String value) {
        response.then().assertThat().body(message,equalTo(value));
    }

    @Then("the employee id {string} is stored as a global variable to be use for another call")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_use_for_another_call(String string) {
        employee_id=response.jsonPath().getString(string);
        System.out.println(employee_id);
    }

    //---------------------------
    @Given("a request is prepared to get the created employee")
    public void a_request_is_prepared_to_get_teh_created_employee() {
        request = given().header(APIConstants.HEADER_KEY_CONTENT_TYPE,
                        APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION,
                        GenerateTokenSteps.token).
                queryParam("employee_id",employee_id);
    }
    @When("a Get call is made to get the employee")
    public void a_get_call_is_made_to_get_the_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }
    @Then("the status code for this employee is {int}")
    public void the_status_code_for_this_employee_is(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }
    @Then("the employee data we get having id {string} must match with globaly store id")
    public void the_employee_data_we_get_having_id_must_match_with_globaly_store_id(String string) {
        //it will store the employee id coming from get call which will compare with global id
        String temEmpId=response.jsonPath().getString(string);
        // assertion we will add
        Assert.assertEquals(temEmpId,employee_id);
    }
    @Then("the retrieved data at {string} object matches with the data of created employee")
    public void the_retrieved_data_at_object_matches_with_the_data_of_created_employee(String empObject, DataTable dataTable) {
        List<Map<String,String>> expectedData=dataTable.asMaps(String.class, String.class);
        Map<String,String> actualData = response.body().jsonPath().get(empObject);
        // this empObject from the response
        for(Map<String,String> map:expectedData){
            //it will store all the keys
            Set<String> keys = map.keySet();
            //another for each loop
            for(String key:keys){
                //it will store the value against the key
                String expectedValue=map.get(key);
                System.out.println("expected "+expectedValue);
                String actualValue= actualData.get(key);
                System.out.println("actual "+actualValue);
                Assert.assertEquals(expectedValue,actualValue);//cucumber assertion
            }
        }
    }
//----------------------------------------------------------------------
    @Given("a request is prepared to create an employee with dynamic data {string},{string},{string},{string},{string},{string},{string}")
    public void a_request_is_prepared_to_create_an_employee_with_dynamic_data
    (String firstname, String lastname, String middle_name,
     String gender, String birthday, String status, String job_title) {
            request = given().header(APIConstants.HEADER_KEY_CONTENT_TYPE,
                            APIConstants.HEADER_VALUE_CONTENT_TYPE).
                    header(APIConstants.HEADER_KEY_AUTHORIZATION,
                            GenerateTokenSteps.token).
                    body(APIPayloadConstants.createEmployeePayloadDynamic(
                            firstname, lastname,  middle_name,
                            gender, birthday,status,
                            job_title
                    ));

    }
    //----------------------------------------

    @Given("a request is prepared to update an employee")
    public void a_request_is_prepared_to_update_an_employee() {
        request=given().header(APIConstants.HEADER_KEY_CONTENT_TYPE,
                        APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION,GenerateTokenSteps.token).
                body(APIPayloadConstants.updateEmployeePayloadJson());


    }
    @When("a PUT call is made to update an employee")
    public void a_put_call_is_made_to_update_an_employee() {
        response=request.when().put(APIConstants.UPDATE_EMPLOYEE_URI);
    }
    @Then("the status code of updated an employee is {int}")
    public void the_status_code_of_updated_an_employee_is(Integer int1) {
        response.then().assertThat().statusCode(int1);

    }




}
