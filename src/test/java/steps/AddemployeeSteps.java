package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddemployeeSteps extends CommonMethods {

    //AddemployeePage addEmployeePage = new AddemployeePage();
    @When("user enters {string} and {string} and {string} in the name fields")
    public void user_enters_and_and_in_the_name_fields(String fn, String mn, String ln) {
       // WebElement firstnameLocator = driver.findElement(By.id("firstName"));
       // WebElement lastnameLocator = driver.findElement(By.id("lastName"));
       // WebElement middlenameLocator = driver.findElement(By.id("middleName"));
       // firstnameLocator.sendKeys(fn);
        //middlenameLocator.sendKeys(mn);
        //lastnameLocator.sendKeys(ln);


        sendText(fn, addEmployeePage.firstnameLocator);
        sendText(mn, addEmployeePage.middlenameLocator);
        sendText(ln, addEmployeePage.lastnameLocator);

    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fn, String mn, String ln) {
        //WebElement firstnameLocator = driver.findElement(By.id("firstName"));
       // WebElement lastnameLocator = driver.findElement(By.id("lastName"));
       // WebElement middlenameLocator = driver.findElement(By.id("middleName"));
        //firstnameLocator.sendKeys(fn);
        //middlenameLocator.sendKeys(mn);
        //lastnameLocator.sendKeys(ln);
        sendText(fn, addEmployeePage.firstnameLocator);
        sendText(mn, addEmployeePage.middlenameLocator);
        sendText(ln, addEmployeePage.lastnameLocator);
    }


    @When("user enters employees using data table and save them")
    public void user_enters_employees_using_data_table_and_save_them
            (io.cucumber.datatable.DataTable dataTable) {

        List<Map<String,String>> employeenames = dataTable.asMaps();
        //from list of maps to one map at a time
        for (Map<String, String> employee:
                employeenames) {
            //WebElement firstnameLocator = driver.findElement(By.id("firstName"));
            //WebElement lastnameLocator = driver.findElement(By.id("lastName"));
            //WebElement middlenameLocator = driver.findElement(By.id("middleName"));
            //firstnameLocator.sendKeys(employee.get("firstname"));
            //middlenameLocator.sendKeys(employee.get("middlename"));
            //lastnameLocator.sendKeys(employee.get("lastname"));
            sendText(employee.get("firstname"),addEmployeePage.firstnameLocator);
            sendText(employee.get("middlename"),addEmployeePage.middlenameLocator);
            sendText(employee.get("lastname"),addEmployeePage.lastnameLocator);

           // WebElement saveButton = driver.findElement(By.id("btnSave"));
           // saveButton.click();
            click(addEmployeePage.saveButton);

            WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmployeeOption.click();

        }
    }


    @When("user adds multiple employees using excel file")
    public void user_adds_multiple_employees_using_excel_file() throws IOException {
        List<Map<String,String>> employeenames = ExcelReader.read();

        for (Map<String,String> employee:
                employeenames) {

           // WebElement firstnameLocator = driver.findElement(By.id("firstName"));
           // WebElement lastnameLocator = driver.findElement(By.id("lastName"));
            //WebElement middlenameLocator = driver.findElement(By.id("middleName"));
            //firstnameLocator.sendKeys(employee.get("firstName"));
            //middlenameLocator.sendKeys(employee.get("middleName"));
            //lastnameLocator.sendKeys(employee.get("lastName"));
            sendText(employee.get("firstName"),addEmployeePage.firstnameLocator);
            sendText(employee.get("middleName"),addEmployeePage.middlenameLocator);
            sendText(employee.get("lastName"),addEmployeePage.lastnameLocator);


            //WebElement saveButton = driver.findElement(By.id("btnSave"));
            //saveButton.click();
            click(addEmployeePage.saveButton);

            WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmployeeOption.click();
        }
    }

    @When("user enters firstname and lastname in the name fields")
    public void user_enters_firstname_and_lastname_in_the_name_fields() {
        //WebElement firstnameLocator = driver.findElement(By.id("firstName"));
       // WebElement lastnameLocator = driver.findElement(By.id("lastName"));
        //WebElement middlenameLocator = driver.findElement(By.id("middleName"));
        //firstnameLocator.sendKeys("faylin");
        //middlenameLocator.sendKeys("ashley");
        //lastnameLocator.sendKeys("maksana");
        sendText("faylin",addEmployeePage.firstnameLocator);
        sendText("ashley",addEmployeePage.middlenameLocator);
        sendText("maksana",addEmployeePage.lastnameLocator);



    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.id("btnSave"));
        //saveButton.click();
        click(addEmployeePage.saveButton);
    }

    @Then("user added successfully")
    public void user_added_successfully() {
        System.out.println("test passed");
    }

}
