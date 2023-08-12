package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Booking;
import pojo.Bookingdates;
import utilities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingApiSteps {
    Response response;

    String id;
    Map<String,Object> data;
    Map<String,Object> updatedData;
    @Given("user creates booking with POST api call with data")
    public void user_creates_booking_with_post_api_call_with_data(io.cucumber.datatable.DataTable dataTable) {
        data=dataTable.asMap(String.class,Object.class);
        String Name;

        String firstName=data.get("firstname").toString();
        String lastName=data.get("lastname").toString();
        String totalPrice=data.get("totalprice").toString();
        String checkIn=data.get("checkin").toString();
        String checkOut=data.get("checkout").toString();
        String additionalNeeds=data.get("additionalneeds").toString();
        Booking bookingPayload=new Booking();
        bookingPayload.setFirstname(firstName);
        bookingPayload.setLastname(lastName);
        bookingPayload.setTotalprice(Integer.parseInt(totalPrice));
        bookingPayload.setDepositpaid(true);
        bookingPayload.setAdditionalneeds(additionalNeeds);
        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin(checkIn);
        bookingdates.setCheckout(checkOut);
        bookingPayload.setBookingdates(bookingdates);


        response=given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body(bookingPayload)
                .when().post("/booking");
        response.then().log().all();
        id=response.body().jsonPath().getString("bookingid");
    }




    @When("user gets created booking with GET api call")
    public void user_gets_created_booking_with_get_api_call() {

        response=given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().log().all()
                .when().get("/booking/"+id);
        response.then().log().all();


    }

    @Then("user validates {int} status code")
    public void user_validates_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);


    }


    @Then("user validates created data matches with response of get call")
    public void user_validates_created_data_matches_with_response_of_get_call() {
        Assert.assertEquals(data.get("firstname").toString(),response.body().jsonPath().getString("firstname"));
        Assert.assertEquals(data.get("lastname").toString(),response.body().jsonPath().getString("lastname"));
        Assert.assertEquals(Integer.parseInt(data.get("totalprice").toString()),response.body().jsonPath().getInt("totalprice"));
        Assert.assertEquals(data.get("checkin").toString(),response.body().jsonPath().getString("bookingdates.checkin"));
        Assert.assertEquals(data.get("checkout").toString(),response.body().jsonPath().getString("bookingdates.checkout"));
        Assert.assertEquals(data.get("additionalneeds").toString(),response.body().jsonPath().getString("additionalneeds"));

    }






    @When("user updates booking with PUT api call with data")
    public void user_updates_booking_with_put_api_call_with_data(io.cucumber.datatable.DataTable dataTable) {
        updatedData=dataTable.asMap(String.class,Object.class);
        String name=updatedData.get("firstname").toString();
        String checkin=updatedData.get("checkin").toString();
        String checkout=updatedData.get("checkout").toString();


        response=given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().body("{\n" +
                        "    \"firstname\" : \""+name+"\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \""+checkin+"\",\n" +
                        "        \"checkout\" : \""+checkout+"\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .and().log().all()
                .and().when().put("/booking/"+id);
        response.then().log().all();

    }




    @When("user gates updated booking with GET api call")
    public void user_gates_updated_booking_with_get_api_call() {
        response=given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().log().all()
                .when().get("/booking/"+id);
        response.then().log().all();

    }
    @Then("user validates updated data matches with response of get call")
    public void user_validates_updated_data_matches_with_response_of_get_call() {
        Booking bookingResposeBody=response.body().as(Booking.class);

        Assert.assertEquals(updatedData.get("firstname"),bookingResposeBody.getFirstname());
        Assert.assertEquals(updatedData.get("checkin"),bookingResposeBody.getBookingdates().getCheckin());
        Assert.assertEquals(updatedData.get("checkout"),bookingResposeBody.getBookingdates().getCheckout());

    }


}
