package Shreedevi_Automation_Projects.BDD_Style.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ra_003 {
    public static void main(String[] args) {
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
        //BDD Style get request
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payLoad)
                .log().all()
                .when().post()
                .then().log().all().statusCode(200);
    }
}
