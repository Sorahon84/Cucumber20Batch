package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddemployeePage extends CommonMethods {


    //create object repository
    //keep all the elements of this screen here

    @FindBy(id="firstName")
    public WebElement firstnameLocator;

    @FindBy(id="middleName")
    public WebElement middlenameLocator;

    @FindBy(id="lastName")
    public WebElement lastnameLocator;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id = "employeeId")
    public WebElement employeeIDField;


    public AddemployeePage() {
        PageFactory.initElements(driver, this);
    }



}
