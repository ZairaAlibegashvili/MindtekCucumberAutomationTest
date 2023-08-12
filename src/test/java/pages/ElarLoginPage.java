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
    @FindBy(xpath = "//li/a[@class='side-link-company']")
    public  WebElement companiesBtn;
    @FindBy(xpath = "//div/a[@class='link-btm-menu']")
    public WebElement addCompanyBtn;
    @FindBy(xpath = "//input[@name='company_name']")
    public WebElement nameInput;
    @FindBy(xpath = "//input[@name='mc_number']")
    public WebElement mcNumber;
    @FindBy(xpath = "//input[@name='dot_number']")
    public WebElement dotNumber;
    @FindBy(xpath = "(//input[@class='input-phone input-form border disabled-company'])[1]")
    public WebElement phoneCompany;
    @FindBy(xpath = "(//input[@name='address'])[1]")
    public WebElement addressCompany;
    @FindBy(xpath = "(//input[@name='city'])[1]")
    public WebElement cityCompany;
    @FindBy(xpath = "(//select[@name='state'])[1]")
    public WebElement stateDropdown;
    @FindBy(xpath ="(//input[@name='zip_code'])[1]")
    public WebElement zipCompany;
    @FindBy(xpath = "(//input[@class='input-form disabled-not-ext border disabled-company lowercase'])[1]")
    public WebElement emailCompany;
    @FindBy(xpath = "//input[@name='insurance']")
    public WebElement insuranceName;
    @FindBy(xpath = "(//input[@class='input-phone input-form border disabled-company'])[2]")
    public WebElement insurancePhone;
    @FindBy(id = "id_producer_address")
    public WebElement producerAdd;
    @FindBy(id = "id_producer_city")
    public WebElement producerCity;
    @FindBy(id = "id_producer_state")
    public WebElement producerStateDropdown;
    @FindBy(xpath = "(//input[@name='zip_code'])[2]")
    public WebElement producerZip;
    @FindBy(xpath = "(//input[@class='input-form disabled-not-ext border disabled-company'])[2]")
    public WebElement producerEmail;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement employerId;
    @FindBy(id = "id_other_licenses")
    public WebElement otherLicenseDropdown;
    @FindBy(xpath = "//button[@class='confirm-save']")
    public WebElement createCompanyBtn;



}
