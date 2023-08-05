package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLoginPage {
    WebDriver driver;
    public ElarLoginPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement logIn;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(),'You do not have access to the section. Please contact your administrator for access')]")
    public  WebElement expectedTxt;

}
