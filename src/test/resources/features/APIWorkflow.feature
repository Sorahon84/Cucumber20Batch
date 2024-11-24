

Feature: API workflow

  Background:
    Given a JWT bearer token is generated

  @api
  Scenario: create employee

    Given a request is prepared for creating the employee
    When a POST call is made to create the employee
    Then the status code for this request is 201
    Then the employee id "Employee.employee_id" is stored and values are validated

  @api
  Scenario: Get the created employee
    Given a request is prepared to get the created employee
    When a GET call is made to get the created employee
    Then the status for for get call is 200
    And the employee has same employee id "employee.employee_id" as global empid
    And the data coming from the get call should equal to the data used in POST call
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |asana        |lawrance    |ms             |Female    |1993-01-12  |permanent |QA manager   |


  @json
  Scenario: Create employee using json payload
    Given a request is prepared for creating the employee using json payload
    When a POST call is made to create the employee
    Then the status code for this request is 201
    Then the employee id "Employee.employee_id" is stored and values are validated

  @dynamic
  Scenario: Create employee using more dynamic json payload
    Given a request is prepared usgin data "asana" , "lawrance" , "ms" , "F" , "1993-01-12" , "permanent" , "QA Manager"
    When a POST call is made to create the employee
    Then the status code for this request is 201
    Then the employee id "Employee.employee_id" is stored and values are validated

  @api1
  Scenario: Update the created employee details
    Given a request is prepared to update the employee details with payload
    When a PUT call is made to update the employee
    Then the status for for update employee 200
    Then update employee id "Employee.employee_id" is stored and values are validated

  @api1
  Scenario: Get the updated employee
    Given a request is prepared to get the updated employee
    When a GET call is made to get the updated employee
    Then the status for get update call is 200
    And the employee has same  with update "employee.employee_id" as global empid
    And the data coming from the put  call should equal to the updated data
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status |emp_job_title|
      |denis        |sekar       |msa            |Male      |2020-11-07  |probation |trainee      |

