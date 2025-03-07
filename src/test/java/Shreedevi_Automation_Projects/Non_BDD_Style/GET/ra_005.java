package Shreedevi_Automation_Projects.Non_BDD_Style.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ra_005 {
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr ;

    @Test
    public void getRequest(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/ping");
        response=rs.when().get();
        vr = response.then().statusCode(201);

    }
}
