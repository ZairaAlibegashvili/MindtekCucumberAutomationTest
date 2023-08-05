package utilities;

import io.restassured.response.Response;
import  static io.restassured.RestAssured.given;

public class RestAPITest {
    public static void main(String[] args){

        /*
        Make get yard API call
        Request
        URL
       1=>BaseURL & Endpoint-> http://3.137.169.132/en-us/api/v2/yards/10/
       2 Head-> Authorization (Token),Accept (application/json)
       3.Method -> Get
        Response
        1.Status code
        2.Json Data
         */

       given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept","application/json")
                .when().get("/yards/10/")
                .then().log().all();

      // System.out.println(response.statusCode());
   //    System.out.println(response.body().asString());


        /*
        POST CALL
        requeust
        1.URL  Baseurl+Endpoint
        2.Headers- Authorization(Token), contentType(app,json),Accept(application)
        3 Payload/Body->json
        4.Method -> Post
        Response
        1. Status code (201)
        2.Body=> json
         */
        Response postResponse=given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \"Zaira22\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"23652\",\n" +
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
                .when().post("/yards/");
     //   System.out.println(postResponse.statusCode());
       // System.out.println(postResponse.getBody().asString());

        /*
        Patch Call
        Request:
        1. URL => BaseURL + Endpoint
        2.Headers-> Authorization(Token),Accept,Content_type
        3. Payload-> json
        4. Method-> PATCH
        Response:
        1.Status code 200
        2.Body json
         */
        Response updateResponse=given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 58,\n" +
                        "  \"location\": \"Zaira Ali\",\n" +
                        "  \"name\": \"Y58\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"232\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"New York\",\n" +
                        "  \"state\": \"MA\",\n" +
                        "  \"zip_code\": \"11225\",\n" +
                        "  \"spots\": 1254,\n" +
                        "  \"warning\": \"ws\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"contacts\": []\n" +
                        "}")
                .when().patch("/yards/55/");
        System.out.println(updateResponse.statusCode());
        System.out.println(updateResponse.body().asString());
    }
}
