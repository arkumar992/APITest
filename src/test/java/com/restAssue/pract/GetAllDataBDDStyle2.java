package com.restAssue.pract;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured; 
//import static  io.restassured.RestAssured. *; // if this line used then no need to mention RestAssured in before given
public class GetAllDataBDDStyle2 {
	
	@Test(enabled = false)
	public void getAlldataBDDformat() {
		
		RestAssured.given().baseUri("http://localhost:3000").when().get("/Students").prettyPrint();
		
	}

	@Test(enabled = false)
	
	public void postDatainBDDformat() {
		
		RestAssured.given().baseUri("http://localhost:3000").header("content-type", "application/json").body(" {\r\n" + 
				"    \"Name\": \"Automation\",\r\n" + 
				"    \"Sub\": [\r\n" + 
				"      \"post\",\r\n" + 
				"      \"method\"\r\n" + 
				"    ]\r\n" + 
				"  }").when().post("/Students").prettyPrint();
		
	}
	
	@Test(enabled =false)
	public void putDatainBddformat() {
		
		RestAssured.given().baseUri("http://localhost:3000").header("content-type", "application/json").body("{\r\n" + 
				"    \"Name\": \"Automation Test\",\r\n" + 
				"    \"Sub\": [\r\n" + 
				"      \"post\",\r\n" + 
				"      \"method\"\r\n" + 
				"    ]\r\n" + 
				"  }").when().put("/Students/140").prettyPrint();
	}
	@Test(enabled =false)
	public void deleteDatainBddformat() {
		
		RestAssured.given().baseUri("http://localhost:3000").when().delete("/Students/140").prettyPrint();
	}
	
	// post data from json file in body
@Test()
	
	public void postDatainBDDformatfile() {
		
	File file = new File("PostData.json");
		RestAssured.given().baseUri("http://localhost:3000").header("content-type", "application/json").body(file).when().post("/Students").prettyPrint();
		
	}
	
	
	
}
