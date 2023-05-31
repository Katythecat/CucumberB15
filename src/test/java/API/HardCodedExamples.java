package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)  // come from junit
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxNDk5MzgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTE5MzEzOCwidXNlcklkIjoiNTM3MiJ9.HpmF5II0wsO6Ta7RSHqDmuFj9TLdm7ptuXe7MoJqe4k";
    static String employee_id;


    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        //hitting the endpoint
        Response response = prepareRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verifying the response
        response.then().assertThat().statusCode(200);
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        System.out.println(tempEmpId);

        //we have 2 emp id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);


    }

    @Test // this from Junit
    public void acrateEmployee() {
        //prepare the request
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "    \"emp_firstname\": \"Taloy\",\n" +
                        "    \"emp_lastname\": \"Swiff\",\n" +
                        "    \"emp_middle_name\": \"s\",\n" +
                        "    \"emp_gender\": \"F\",\n" +
                        "    \"emp_birthday\": \"1990-05-20\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"Singer\"\n" +
                        "}");


        //hitting the endpoint
        Response response = prepareRequest.when().post("/createEmployee.php");
        //verifying the assertions
        response.then().assertThat().statusCode(201);

        //it will print the output in the console
        response.prettyPrint(); //only use in API

        //we are capturing employee id from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);


        //verifying the firstname in the response body
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("Taloy"));
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("Swiff"));

        //verifying the response header
        response.then().assertThat().
                header("Content-Type", equalTo("application/json"));
        System.out.println("My test case is passed");

    }

    @Test
    public void cupdateEmployee() {
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "    \"employee_id\": \"" + employee_id + "\",\n" +
                        "    \"emp_firstname\": \"Gigi\",\n" +
                        "    \"emp_lastname\": \"Manini\",\n" +
                        "    \"emp_middle_name\": \"m\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1984-05-20\",\n" +
                        "    \"emp_status\": \"Probation\",\n" +
                        "    \"emp_job_title\": \"Tester\"\n" +
                        "}");

        //hitting endpoint // send the request and receive the response
        Response response = prepareRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

        //for verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }

    @Test
    public void dgetUpdatedEmployee() {
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        //we have query only for get request


        Response response = prepareRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response
        //you can do that using hamcrest matchers

    }

    @Test
    public void egetAllEmployeeStatus() {
        RequestSpecification preparedRequest = given().
                header("Authorization", token);
        Response response = preparedRequest.when().get("/employeementStatus.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        String name = response.jsonPath().getString("'Employeement Status'[1].name");
        System.out.println(name);

    }

    @Test
    public void fgetJobTitle() {
        RequestSpecification preparedRequest = given().
                header("Authorization", token);
        Response response = preparedRequest.when().get("/jobTitle.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        String jobIndex4 = response.jsonPath().getString("'Jobs'[4].job");
        System.out.println(jobIndex4);
        if ("Network Administrator".equalsIgnoreCase(jobIndex4)) {
            System.out.println("jobIndex4 is Network Administrator ");
        } else {
            System.out.println("jobIndex4 is NOT Network Administrator");
        }


    }

}
