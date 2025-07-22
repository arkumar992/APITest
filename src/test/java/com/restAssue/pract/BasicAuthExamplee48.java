package com.restAssue.pract;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthExamplee48 {
	
	@Test
	public void getAlldataBDDformat() {
		
		RestAssured.given().auth().basic("postman", "password").baseUri("http://postman-echo.com").when().get("/basic-auth").prettyPrint();
	
	}

}
