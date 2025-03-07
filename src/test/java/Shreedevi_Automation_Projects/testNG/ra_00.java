package Shreedevi_Automation_Projects.testNG;

import io.restassured.RestAssured;

public class ra_00 {

    public static void main(String[] args) {
        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com").basePath("/ping").
                when().get().
                then().statusCode(201);
        //THIS IS CALLED AS BUILDER PATTERN
    }
}
