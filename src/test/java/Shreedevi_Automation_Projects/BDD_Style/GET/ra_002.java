package Shreedevi_Automation_Projects.BDD_Style.GET;

import io.restassured.RestAssured;

public class ra_002 {
    public static void main(String[] args) {
        //BDD Style get request
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .log().all()
                .when().get()
                .then().log().all().statusCode(201);

    }

}
