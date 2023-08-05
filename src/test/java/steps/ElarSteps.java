package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ElarLoginPage;
import pages.ElarNewPage;
import utilities.ConfigReader;
import utilities.Driver;


public class ElarSteps {

    WebDriver driver= Driver.getDriver();
    ElarNewPage elarNewPage=new ElarNewPage();
    @Given("User will navigate to application")
    public void user_will_navigate_to_application() {
        driver.get(ConfigReader.getProperty("ElarURL"));

    }




    @When("logs in with username {string} and password {string}")
    public void logs_in_with_username_and_password(String username, String password) {
        elarNewPage.loginInput.sendKeys(username);
        elarNewPage.passwordInput.sendKeys(password);


    }
    @When("User clicks logged in")
    public void user_clicks_logged_in() {
        elarNewPage.loginBtn.click();

    }
    @When("User clicks the Yard button")
    public void user_clicks_the_yard_button() {
        elarNewPage.yardBtn.click();
    }
    @When("User clicks the Add Yard button")
    public void user_clicks_the_add_yard_button() {
        elarNewPage.addYardButton.click();

    }
    @When("User enter Apt name {string}")
    public void user_enter_apt_name(String string) {
        elarNewPage.aptField.sendKeys("flowers,.-%#");

    }
    @Then("User should see created  apt name  {string}")
    public void user_should_see_created_apt_name(String expected) {



      Assert.assertEquals(elarNewPage.aptField.getAttribute("value"),expected);
    }

    @When("User enter {string} in the city field")
    public void user_enter_in_the_city_field(String string) {
        elarNewPage.cityField.sendKeys(string);

    }




    @Then("The city field should contain {string}")
    public void the_city_field_should_contain(String expectedCity) {
        Assert.assertEquals(elarNewPage.cityField.getAttribute("value"),expectedCity);
    }

    @When("User type  {string} in the City field")
    public void user_type_in_the_city_field(String negativeInput) {
        elarNewPage.cityField.sendKeys(negativeInput);

    }




    @Then("The city should show an error message {string}")
    public void the_city_should_show_an_error_message(String expectedInput) {
       // String expectedInvalidInput="Invalid input";
        Assert.assertEquals(elarNewPage.invalidInputText.getText(),expectedInput);

    }

    @When("USer select {string} from the States field")
    public void u_ser_select_from_the_states_field(String string) {

        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("window.scrollBy(0,500);");
        Select select=new Select(elarNewPage.stateDropDown);
        select.selectByIndex(30);

    }




    @Then("the states field should contain {string}")
    public void the_states_field_should_contain(String expectedState) {
        Select dropdown=new Select(elarNewPage.stateDropDown);
        WebElement selected=dropdown.getFirstSelectedOption();
        String actual=selected.getAttribute("value");
        String expected="New York";


        Assert.assertEquals(expected,actual);

    }
    @When("User enter {string} in the Zip field")
    public void user_enter_in_the_zip_field(String zip) {
        elarNewPage.zipField.sendKeys(zip);

    }

    @Then("the Zip field should contain {string}")
    public void the_zip_field_should_contain(String expectedZip) {
        Assert.assertEquals(elarNewPage.zipField.getAttribute("value"),expectedZip);

    }
    @When("User enter {string} inside the zip field")
    public void user_enter_inside_the_zip_field(String invalidZip) {
        elarNewPage.zipField.sendKeys(invalidZip);

    }




    @Then("the Zip field should show an error message {string}")
    public void the_zip_field_should_show_an_error_message(String string) {
        Assert.assertEquals(elarNewPage.errorZip.getText(),string);

    }






}






