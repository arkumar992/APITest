package com.restAssue.pract;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExamples45 {
	
	RequestSpecification requestspeci;
	
	@BeforeClass
	public void setRequestSpecification() {
		
		requestspeci = RestAssured.with().baseUri("http://localhost:3000").basePath("/Students"); //given() /with() both are similar only
		RestAssured.requestSpecification=requestspeci; //default request specification
	}
	
	
	@Test
	public void getAlldataBDDformat() {
		
		RestAssured.given().spec(requestspeci).when().get().prettyPrint(); //spec function used for getting request specification details  // // we no need to mention spec method because we already set line no 18 default request specification
	
	}

	
	@Test
	public void getspecificdataBDDformat() {
		
		RestAssured.given().when().get("/101").prettyPrint(); // we no need to mention spec method because we already set line no 18 default request specification 
	
	}

	
@Test()
	// Videos 46
	public void postDatainBDDformat() {
		
	RequestSpecification defaultrequestspecioverride = RestAssured.with().contentType(ContentType.JSON).baseUri("http://localhost:3000").basePath("/Students");
	 
	
		RestAssured.given().spec(defaultrequestspecioverride).body(" {\r\n" + 
				"    \"Name\": \"Automation\",\r\n" + 
				"    \"Sub\": [\r\n" + 
				"      \"post\",\r\n" + 
				"      \"method\"\r\n" + 
				"    ]\r\n" + 
				"  }").when().post("/Students").prettyPrint();
		
	}
	

}
