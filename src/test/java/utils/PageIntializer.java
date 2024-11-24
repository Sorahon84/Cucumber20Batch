package utils;


import pages.AddemployeePage;
import pages.DashboardPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageIntializer {
    public static LoginPage loginPage;
    public static AddemployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static DashboardPage dashboardPage;


    public static void initializePageObjects(){
        loginPage=new LoginPage();
        addEmployeePage=new AddemployeePage();
        employeeSearchPage = new EmployeeSearchPage();
        dashboardPage = new DashboardPage();
    }

}
