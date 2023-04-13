package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {


    public AddEmployeePage(){

        PageFactory.initElements(driver,this);//initialize the webelement of the current page
    }

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimTab;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmpBtn;

    @FindBy(id="firstName")
    public WebElement firstnameTextBox ;

    @FindBy(id="middleName")
    public WebElement middlenameTextBox;

    @FindBy(id="lastName")
    public WebElement lastnameTextBox;

    @FindBy(id="btnSave")
    public WebElement saveBtn;
}
