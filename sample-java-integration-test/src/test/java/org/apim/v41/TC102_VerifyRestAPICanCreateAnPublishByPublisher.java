package org.apim.v41;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC102_VerifyRestAPICanCreateAnPublishByPublisher {
	String apiID;
	@Test
	void createApplication() {
		Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
				.contentType("application/json")
				.body(getPayload())
				.when().post("https://localhost:9443/api/am/publisher/v3/apis?openAPIVersion=v3");

		//System.out.println(response.body().asPrettyString());
		assertEquals(response.statusCode(), 201,"Assert status code is 201 -> ");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		apiID = jsonPathEvaluator.get("id");
		System.out.println("API ID : " + apiID);
		
		assertEquals(jsonPathEvaluator.get("name"), "PizzaShack","Assert API name is PizzaShack -> ");
		assertEquals(jsonPathEvaluator.get("context"), "/pizzashack","Assert API context is /pizzashack -> ");
		assertEquals(jsonPathEvaluator.get("version"), "1.0.0","Assert API version is 1.0.0 -> ");
		assertEquals(jsonPathEvaluator.get("lifeCycleStatus"), "CREATED","Assert API lifeCycleStatus is CREATED -> ");
	}
	
	
	String getPayload() {
		return "{\"name\":\"PizzaShack\",\"version\":\"1.0.0\",\"context\":\"/pizzashack\",\"policies\":[\"Unlimited\"],\"endpointConfig\":{\"endpoint_type\":\"http\",\"sandbox_endpoints\":{\"url\":\"https://localhost:9443/am/sample/pizzashack/v1/api/\"},\"production_endpoints\":{\"url\":\"https://localhost:9443/am/sample/pizzashack/v1/api/\"}}}";
	}
}
