package utilities;

import io.restassured.response.Response;

import java.util.Random;

import static io.restassured.RestAssured.given;


public class RestApi {


        public static void main(String[] args) {
            /**
             * Method GET
             */
            Response getResponse = given().baseUri(ConfigReader.getProperty("http://3.137.169.132/en-us/api/v2"))
                    .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                    .when().get("");
            System.out.println("Method get's c/companies/153/ode is: "+getResponse.statusCode());

            /**
             * Method POST
             */
            Random random = new Random();
            int mc_number = random.nextInt(999999999);
            int dot_number = random.nextInt(999999999);
            Response postResponse = given().baseUri(ConfigReader.getProperty("ElarBaseURI"))
                    .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                    .and().accept("application/json")
                    .and().contentType("application/json")
                    .and().body("{\n" +
                            "    \"company_name\": \"Mila111\",\n" +
                            "    \"company_type\": \"broker company\",\n" +
                            "    \"status\": \"active\",\n" +
                            "    \"mc_number\": \""+mc_number+"\",\n" +
                            "    \"dot_number\": \""+dot_number+"\",\n" +
                            "    \"ifta\": false,\n" +
                            "    \"address\": \"111\",\n" +
                            "    \"apt_suite_company_co\": null,\n" +
                            "    \"city\": \"Raleigh\",\n" +
                            "    \"state\": \"NC\",\n" +
                            "    \"zip_code\": \"27511\",\n" +
                            "    \"insurance\": \"MetLife\",\n" +
                            "    \"producer_address\": \"123 Washington ave.\",\n" +
                            "    \"producer_apt_suite_company_co\": null,\n" +
                            "    \"producer_city\": \"Austin\",\n" +
                            "    \"producer_state\": \"IN\",\n" +
                            "    \"producer_zip_code\": \"85001\",\n" +
                            "    \"policy_effective_day\": null,\n" +
                            "    \"policy_expiration\": null,\n" +
                            "    \"type_of_insurance\": null,\n" +
                            "    \"automobile_liability\": \"\",\n" +
                            "    \"num_of_truck_insured\": null,\n" +
                            "    \"policy_number\": null,\n" +
                            "    \"employer_id_num\": \"22-2228998\",\n" +
                            "    \"billing_address\": null,\n" +
                            "    \"bank_name\": null,\n" +
                            "    \"routing_number\": null,\n" +
                            "    \"account_number\": null,\n" +
                            "    \"president_full_name\": null,\n" +
                            "    \"trucks_in_fleet\": null,\n" +
                            "    \"scac_code\": \"\",\n" +
                            "    \"other_licenses\": false,\n" +
                            "    \"license_name\": null,\n" +
                            "    \"incorporated_in\": null,\n" +
                            "    \"warning\": \"\",\n" +
                            "    \"notes\": null,\n" +
                            "    \"company_picture\": [],\n" +
                            "    \"company_documents\": [],\n" +
                            "    \"contacts\": [\n" +
                            "        {\n" +
                            "            \"phone\": \"111-111-1111\",\n" +
                            "            \"ext\": \"\",\n" +
                            "            \"contact_name\": \"\",\n" +
                            "            \"email\": \"raleigh@gmail.com\",\n" +
                            "            \"fax\": \"\",\n" +
                            "            \"producer_phone\": \"111-111-1111\",\n" +
                            "            \"producer_phone_ext\": \"\",\n" +
                            "            \"producer_contact_name\": \"\",\n" +
                            "            \"producer_email\": \"22@yahoo.com\"\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"phone_number\": [\n" +
                            "        {\n" +
                            "            \"phone\": \"111-111-1111\",\n" +
                            "            \"ext\": \"\",\n" +
                            "            \"contact_name\": \"\",\n" +
                            "            \"email\": \"raleigh@gmail.com\",\n" +
                            "            \"fax\": \"\",\n" +
                            "            \"producer_phone\": \"111-111-1111\",\n" +
                            "            \"producer_phone_ext\": \"\",\n" +
                            "            \"producer_contact_name\": \"\",\n" +
                            "            \"producer_email\": \"22@yahoo.com\"\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"fax_number\": [\n" +
                            "        {\n" +
                            "            \"fax\": \"\"\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"email_number\": [\n" +
                            "        {\n" +
                            "            \"email\": \"raleigh@gmail.com\"\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"producer_email_number\": [\n" +
                            "        {\n" +
                            "            \"producer_email\": \"22@yahoo.com\"\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"producer_phone_number\": [\n" +
                            "        {\n" +
                            "            \"producer_phone\": \"111-111-1111\",\n" +
                            "            \"producer_phone_ext\": \"\",\n" +
                            "            \"producer_contact_name\": \"\"\n" +
                            "        }\n" +
                            "    ]\n" +
                            "}")
                    .when().post("/companies/");
            System.out.println("Method post's code is: "+postResponse.statusCode());

            /**
             * Method PATCH
             */
            Response pathResponse = given().baseUri(ConfigReader.getProperty("http://3.137.169.132/en-us/api/v2"))
                    .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                    .and().accept("application/json")
                    .and().contentType("application/json")
                    .and().body("{\n" +
                            "    \"id\": 252,\n" +
                            "    \"contacts\": [\n" +
                            "        {\n" +
                            "            \"id\": 266,\n" +
                            "            \"email\": \"raleigh@gmail.com\",\n" +
                            "            \"phone\": \"111-111-1111\",\n" +
                            "            \"ext\": \"\",\n" +
                            "            \"contact_name\": \"\",\n" +
                            "            \"fax\": \"\",\n" +
                            "            \"producer_email\": \"22@yahoo.com\",\n" +
                            "            \"producer_phone\": \"111-111-1111\",\n" +
                            "            \"producer_phone_ext\": \"\",\n" +
                            "            \"producer_contact_name\": \"\",\n" +
                            "            \"service_phone\": \"\",\n" +
                            "            \"service_contact_name\": \"\",\n" +
                            "            \"owner_phone\": \"\",\n" +
                            "            \"owner_contact_name\": \"\"\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"company_name\": \"Mila115\",\n" +
                            "    \"company_type\": \"broker company\",\n" +
                            "    \"status\": \"active\",\n" +
                            "    \"mc_number\": \"111089\",\n" +
                            "    \"dot_number\": \"111098\",\n" +
                            "    \"ifta\": false,\n" +
                            "    \"address\": \"111\",\n" +
                            "    \"apt_suite_company_co\": null,\n" +
                            "    \"city\": \"Raleigh\",\n" +
                            "    \"state\": \"NC\",\n" +
                            "    \"zip_code\": \"27511\",\n" +
                            "    \"insurance\": \"MetLife\",\n" +
                            "    \"producer_address\": \"123 Washington ave.\",\n" +
                            "    \"producer_apt_suite_company_co\": null,\n" +
                            "    \"producer_city\": \"Austin\",\n" +
                            "    \"producer_state\": \"IN\",\n" +
                            "    \"producer_zip_code\": \"85001\",\n" +
                            "    \"policy_effective_day\": null,\n" +
                            "    \"policy_expiration\": null,\n" +
                            "    \"type_of_insurance\": null,\n" +
                            "    \"automobile_liability\": \"\",\n" +
                            "    \"num_of_truck_insured\": null,\n" +
                            "    \"policy_number\": null,\n" +
                            "    \"employer_id_num\": \"O472GmipBwh8rQUlZ0oHLw==\",\n" +
                            "    \"billing_address\": null,\n" +
                            "    \"bank_name\": null,\n" +
                            "    \"routing_number\": null,\n" +
                            "    \"account_number\": null,\n" +
                            "    \"president_full_name\": null,\n" +
                            "    \"trucks_in_fleet\": null,\n" +
                            "    \"scac_code\": \"\",\n" +
                            "    \"other_licenses\": false,\n" +
                            "    \"incorporated_in\": null,\n" +
                            "    \"warning\": \"\",\n" +
                            "    \"notes\": null,\n" +
                            "    \"users\": [],\n" +
                            "    \"license_name\": null\n" +
                            "}")
                    .when().patch("/companies/252/");
            System.out.println("Method path's code is: "+pathResponse.statusCode());
        }
    }

