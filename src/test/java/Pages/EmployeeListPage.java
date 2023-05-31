package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends CommonMethods {

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimTab;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement empName;

    @FindBy(id="empsearch_id")
    public WebElement idTextBox;

    @FindBy(id="searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//td[text()='No Records Found']")
    public WebElement actualMsg;



    public EmployeeListPage(){
        PageFactory.initElements(driver,this);//initialize the webelement of the current page
    }
}

