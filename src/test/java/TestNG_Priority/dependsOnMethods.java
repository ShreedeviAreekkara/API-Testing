package TestNG_Priority;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class dependsOnMethods {
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr ;
    Integer booking_ID;
    String token;
    String base_URL="https://restful-booker.herokuapp.com";
    Integer totalPrice;
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testgeTToken() {
        String payload= "{\n" +
                "            \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "        }";
        rs.baseUri(base_URL);
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload);
        response= rs.when().post();
        String responseBody = response.asString();
        System.out.println(responseBody);
        vr= response.then().statusCode(200);
        token = response.then().extract().path("token");

    }


    @Test
    public void testBookingId() {
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
        rs.baseUri(base_URL);
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payLoad);
        response=rs.when().log().all().post();
        vr= response.then();
        String responseBody = response.asString();
        System.out.println(responseBody);
        vr.statusCode(200);

        booking_ID=response.then().extract().path("bookingid");

    }

    @Test(dependsOnMethods = {"testBookingId","testgeTToken"})
    public void testAputRequest() {
        String put_Payload = "{\n" +
                "    \"firstname\" : \"Sooraj\",\n" +
                "    \"lastname\" : \"Soorianarayanan\",\n" +
                "    \"totalprice\" : 1024,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-02\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast,lunch\"\n" +
                "}";
        rs.baseUri(base_URL);
        rs.basePath("/booking"+"/"+booking_ID);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(put_Payload);
        response=rs.when().log().all().put();
        String responseString = response.asString();
        System.out.println(responseString);
        vr= response.then();
        vr.statusCode(200);
        //There are three types of verification
        //1. Using Matchers
        vr.body("lastname", Matchers.equalTo("Soorianarayanan"));

        //2.a. Using TestNg assertions
        int totalPrice = response.then().extract().path("totalprice");
        Assert.assertEquals(totalPrice,1024);

        //2.b. Using TestNG assertions and JsonPath
        JsonPath jp = new JsonPath(responseString);
        String jsonPathCheckin = jp.getString("bookingdates.checkin");
        String jsonPathLastName = jp.getString("lastname");
        Assert.assertEquals(jsonPathCheckin,"2024-01-01");
        Assert.assertEquals(jsonPathLastName,"Soorianarayanan");

        //3. AssertJ Matching
        //totalPrice = vr.extract().path("totalprice");
        //assertThat(totalPrice).isEqualTo(1024);
        String checkout =vr.extract().path("bookingdates.checkout");
        assertThat(checkout).isNotEmpty().isEqualTo("2024-01-02");

    }
}
