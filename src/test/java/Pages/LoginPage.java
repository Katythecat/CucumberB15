package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {


    @FindBy(id="txtUsername")
    public WebElement usernameTextBox;


    @FindBy(id="txtPassword")
    public WebElement passwordTextBox;

    @FindBy(id="btnLogin")
    public WebElement loginBtn ;

    @FindBy(id="welcome")
    public WebElement welcomeIcon;

    @FindBy(xpath ="//a[text()='Logout']" )
    public WebElement logoutLink;

    public LoginPage(){

        PageFactory.initElements(driver,this);//initialize the webelement of the current page
    }

    //Page Factory Model
}
