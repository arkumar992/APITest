package com.restAssue.pract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidat17_18 {
	
	@Test(enabled = false)
	
	// output compared with jsonschema using matchesJsonSchemaInClasspath
	public void jsonschmaValidation() {
		
		
		File file = new File("src//test//resources//PostReqest.json");
		RestAssured.given().baseUri("http://localhost:3000").header("content-type", "application/json").body(file).when().post("/Students")
		.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("PostReqeJsonSchemaValidation.json")); // its accepting only in classpath(must in src/test/resources) located json file
			
	}
	
	// output compared with jsonschema using matchesJsonSchema when different location schma file aviable
	
	
	@Test()
public void jsonschmaValidationwithoutClasspath() throws FileNotFoundException {
		
		
		File file = new File("src//test//resources//PostReqest.json");
		File schma = new File("D:\\Sel\\API\\PostReqeJsonSchemaValidaDiffLOC.json"); // differnt location in json file placed 
		InputStream in =  new FileInputStream("D:\\Sel\\API\\PostReqeJsonSchemaValidaDiffLOC.json"); // another method read a file
		Reader rd = new FileReader("D:\\Sel\\API\\PostReqeJsonSchemaValidaDiffLOC.json"); // another method read a file
		
		RestAssured.given().baseUri("http://localhost:3000").header("content-type", "application/json").body(file).when().post("/Students")
		.then().body(JsonSchemaValidator.matchesJsonSchema(rd)); // its accepting only in classpath(must in src/test/resources) located json file
			
	}
}
