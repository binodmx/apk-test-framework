package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredIT {

    @Test
    public void getUsers() {
        given().when().get("https://reqres.in/api/users?page=2").then().assertThat().body("page", equalTo(2));
        System.out.println("getUsers() integration test ran...");
    }
}
