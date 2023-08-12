package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.response.Response;
import okhttp3.Address;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class YardsAPISteps {
    String yardID;
    Response response;
    @Given("User creates yard with post yard call with data")
    public void user_creates_yard_with_post_yard_call_with_data(io.cucumber.datatable.DataTable dataTable) {
        Map<String, Object> data=dataTable.asMap(String.class,Object.class);
        String name=data.get("location").toString();
        String status=data.get("status").toString();
        String address=data.get("Address").toString();
        response=given().baseUri(ConfigReader.getProperty("ElarAPIBaseURL"))
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \""+name+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"address\": \""+address+"\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"New York\",\n" +
                        "  \"state\": \"MA\",\n" +
                        "  \"zip_code\": \"11229\",\n" +
                        "  \"spots\": \"1254\",\n" +
                        "  \"warning\": \"ws\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"yard_picture\": [],\n" +
                        "  \"contacts\": [],\n" +
                        "  \"service_phone_number\": [\n" +
                        "    {\n" +
                        "      \"service_phone\": \"\",\n" +
                        "      \"service_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"owner_phone_number\": [\n" +
                        "    {\n" +
                        "      \"owner_phone\": \"\",\n" +
                        "      \"owner_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .and().log().all()
                .when().post("/yards/");
        response.then().statusCode(201);

    yardID= response.body().jsonPath().getString("id");
        System.out.println( "Yard ID"+yardID);

    }




    @When("user connects to database")
    public void user_connects_to_database() throws SQLException {
        JDBCUtils.establishConnection();


    }
    @Then("user validates created yard is persisted in DB")
    public void user_validates_created_yard_is_persisted_in_db() throws SQLException {
        List<Map<String,Object>> dbData= JDBCUtils.runQuery("select* from core_yard where id= "+yardID);
        System.out.println("Yard details from database:"+ dbData);

        String apiYardName=response.body().jsonPath().getString("location");
        String apiYardStatus=response.body().jsonPath().getString("status");
        String apiYardAddress=response.body().jsonPath().getString("address");

        Assert.assertEquals(apiYardName,dbData.get(0).get("location"));
        Assert.assertEquals(apiYardStatus,dbData.get(0).get("status"));
        Assert.assertEquals(apiYardAddress,dbData.get(0).get("address"));

    }
}
