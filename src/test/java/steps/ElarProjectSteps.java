package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.ElarLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Map;


public class ElarProjectSteps {
    WebDriver driver = Driver.getDriver();
    ElarLoginPage elarLoginPage=new ElarLoginPage();
    @Given(":User opens Elar web page with username {string} and password {string}")
    public void user_opens_elar_web_page_with_username_and_password(String username, String password) {
        driver.get(ConfigReader.getProperty("ElarURL"));
        elarLoginPage.logIn.sendKeys(username);
        elarLoginPage.password.sendKeys(password);
        elarLoginPage.loginBtn.click();

    }




    @Given("User clicks on companies BTN")
    public void user_clicks_on_companies_btn() {
        elarLoginPage.companiesBtn.click();

    }
    @Given("User clicks on Add Company Btn")
    public void user_clicks_on_add_company_btn() {
        elarLoginPage.addCompanyBtn.click();

    }
    @Given("User creates company with data")
    public void user_creates_company_with_data(io.cucumber.datatable.DataTable dataTable) {
        Map<String,Object> data=dataTable.asMap(String.class,Object.class);

        elarLoginPage.nameInput.sendKeys("Name");

    }
    @When("User changes company Name to {string}")
    public void user_changes_company_name_to(String string) {

    }
    @Then("User validates with JDBC if company name is changed")
    public void user_validates_with_jdbc_if_company_name_is_changed() {

    }

}
