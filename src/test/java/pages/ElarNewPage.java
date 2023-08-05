package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarNewPage {

    WebDriver driver;

    public ElarNewPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;
    @FindBy(id = "id_input_pass")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@class='btn-login']")
    public WebElement loginBtn;
    @FindBy(xpath = "//div[@id='app']/aside/nav/ul[3]/li[1]/a")
    public WebElement yardBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[1]/div[3]/div[2]/a")
    public WebElement addYardButton;

    @FindBy(id ="id_apt_suite_company_co")
    public  WebElement aptField;

    @FindBy(id="id_city")
    public  WebElement cityField;

    @FindBy(xpath = "//span[@class='input-errors']")
    public WebElement invalidInputText;

    @FindBy(id="id_state")
    public WebElement stateDropDown;

    @FindBy(id="id_zip_code")
    public WebElement zipField;

    @FindBy(xpath = "//*[@id=\"add-yard\"]/div[1]/div/div[1]/div[1]/p[5]/span[2]")
    public WebElement errorZip;

}