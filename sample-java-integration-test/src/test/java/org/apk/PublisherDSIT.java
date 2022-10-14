package org.apk;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PublisherDSIT {
    String endpoint;

    @BeforeTest
    void checkEndpoint() {
        endpoint = System.getProperty("endpoint");
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = "https://localhost:9443";
        }
    }

    @Test
    public void getApis() {
        given().when().get(endpoint + "/api/am/publisher/v3/apis?limit=2&offset=2&sortBy=name&sortOrder=1")
                .then().assertThat().body("count", equalTo(2));
    }
}
