package Shreedevi_Automation_Projects.BDD_Style.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ra_004 {
    String token;
    Integer booking_id;
    @BeforeTest
    public void get_Token() {
        String auth_Payload = "{\n" +
                "            \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "        }";
        token = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .body(auth_Payload)
                .contentType(ContentType.JSON)
                .when().post()
                .then().log().all().extract().path("token");

    }
    @Test
    public void getBooking_id(){
        String payLoad = "{\n" +
                "    \"firstname\" : \"Sooraj\",\n" +
                "    \"lastname\" : \"Govind\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        booking_id= RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payLoad)
                .when().post()
                .then().log().all().extract().path("bookingid");
    }
    @Test
    public void put_request() {
        String put_Payload = "{\n" +
                "    \"firstname\" : \"Sooraj\",\n" +
                "    \"lastname\" : \"Govind\",\n" +
                "    \"totalprice\" : 1024,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-02\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast,lunch\"\n" +
                "}";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking"+"/"+booking_id)
                .contentType(ContentType.JSON)
                .body(put_Payload)
                .cookie("token",token)
                .when().put()
                .then().log().all().statusCode(200);

    }
}
