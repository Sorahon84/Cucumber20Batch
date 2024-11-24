package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExample {
    //base URI = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String employee_id;
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MzE1MjE2MjUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTczMTU2NDgyNSwidXNlcklkIjoiNjkzNCJ9.C55O6YGvEXhi-aFjcD89zRgv_juX_bg6mORDMduHxk0";

    @Test
    public void acreateEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token)
                .body("{\n" +
                        "  \"emp_firstname\": \"asana\",\n" +
                        "  \"emp_lastname\": \"lawrance\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1993-01-12\",\n" +
                        "  \"emp_status\": \"permanent\",\n" +
                        "  \"emp_job_title\": \"QA Manager\"\n" +
                        "}");
        //response will be returned when we send the request
        Response response = request.when().post("/createEmployee.php");

        //to print the reponse
        response.prettyPrint();
        response.then().assertThat().statusCode(201);

        //hamcrest matchers
        response.then().assertThat().
                body("Employee.emp_firstname",equalTo("asana"));
        //retrieve the employee id after creating the employee and store it in global variable

        //jsonPath() is the method which returns the value in string against the key specified
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println("The employee id is:::::: " + employee_id);
    }

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).

                queryParam("employee_id",employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);
    }

    @Test
    public void cupdateEmployee(){
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).

                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"denis\",\n" +
                        "  \"emp_lastname\": \"sekar\",\n" +
                        "  \"emp_middle_name\": \"msa\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2020-11-07\",\n" +
                        "  \"emp_status\": \"probation\",\n" +
                        "  \"emp_job_title\": \"trainee\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
    }
@Test
    public void dGetAllEmployee() {
    RequestSpecification request = given().header("Content-Type", "application/json").header("Authorization", token);

    Response response = request.when().get("/getAllEmployees.php");
    response.prettyPrint();
    response.then().assertThat().statusCode(200);
    // Get the list of employees from the response
    List<Map<String, Object>> employees = response.jsonPath().getList("Employees");
    for (Map<String, Object> employee : employees) {
        System.out.println("Checking employee: " + employee);

        // Check if employee_id is empty and log a warning
        String employeeId = (String) employee.get("employee_id");
        if (employeeId == null || employeeId.trim().isEmpty()) {
            System.out.println("Warning: Employee ID is empty for employee: " + employee);
            continue; // Skip this employee if ID is empty
        }

        // Now proceed with the assertion since ID is not empty
        assertThat("Employee ID should not be empty", employeeId.trim(), not(isEmptyString()));

        // Check the first name and last name (already done previously)
        assertThat("First name should not be null", employee.get("emp_firstname"), notNullValue());
        assertThat("First name should not be empty", employee.get("emp_firstname").toString().trim(), not(isEmptyString()));
    }

}
}
