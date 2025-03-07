package Shreedevi_Automation_Projects.Non_BDD_Style.POST;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ra_006 {
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr ;
    int booking_ID;

    @Test
    public void post_request(){
        String payload = "{\n" +
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
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload);
        response = rs.when().post();
        vr = response.then().statusCode(200);
        booking_ID =  vr.extract().path("bookingid");// vr can also be written as response.then() here
        System.out.println(booking_ID);
    }
}
