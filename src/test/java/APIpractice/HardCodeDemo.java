package APIpractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class HardCodeDemo {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJpYXQiOjE2ODQ5NDMzMTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NDk4NjUxNCwidXNlcklkIjoiNTM3MiJ9." +
                    "0HJZS4EMU7YwwTUECBDP-vn9nVzDddFLlvq7tLnDfaA";

    @Test
    public void createdEmployee(){
        //(we have class available in REST assured library)
        //prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "    \"emp_firstname\": \"Taloy\",\n" +
                        "    \"emp_lastname\": \"Swiff\",\n" +
                        "    \"emp_middle_name\": \"s\",\n" +
                        "    \"emp_gender\": \"F\",\n" +
                        "    \"emp_birthday\": \"1990-05-20\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"Singer\"\n" +
                        "}");

        //hitting the end point/send the request
        Response response =preparedRequest.when().post("/createEmployee.php");

        //verifying the assertions/get response
        response.then().assertThat().statusCode(201);
        //it will print the output in the console
        response.prettyPrint();

        //verifying many things
        response.then().assertThat().
                body("Employee.emp_lastname",equalTo("Swiff"));
        System.out.println("My test case is passed");
    }




}
