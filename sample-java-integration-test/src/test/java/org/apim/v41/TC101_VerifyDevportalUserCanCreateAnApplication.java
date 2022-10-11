package org.apim.v41;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC101_VerifyDevportalUserCanCreateAnApplication {
	
	String applicationID;
	@Test
	void createApplication() {
		Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
				.contentType("application/json")
				.body("{\"name\":\"testApp2\",\"throttlingPolicy\":\"10PerMin\",\"description\":\"desc\",\"tokenType\":\"JWT\",\"groups\":null,\"attributes\":{}}")
				.when().post("https://localhost:9443/api/am/devportal/v2/applications");

		System.out.println(response.body().asPrettyString());
		assertEquals(response.statusCode(), 201,"Assert status code is 201 -> ");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		applicationID = jsonPathEvaluator.get("applicationId");
		System.out.println("Created Application " + applicationID);
	}
	
	@AfterTest
	void deleteAppliation() {

		Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
				.contentType("application/json")
				.delete("https://localhost:9443/api/am/devportal/v2/applications/"+applicationID);
		System.out.println(response.body().asPrettyString());
		assertEquals(response.statusCode(), 200,"Assert status code is 200 -> ");
		System.out.println("Application " + applicationID + " deleted successfully");
	}
}
