package com.restAssured.pojodemo;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

//DeSerialization means . we recevied json data from network , those data we can map to pojo class then get value.
//here we can do in multiple way 
public class DeSerialization38_41 {

	
	
	String json = "{\r\n" + 
			"  \"name\" : \"arunkumarr\",\r\n" + 
			"  \"ids\" : \"Abc123\",\r\n" + 
			"  \"sub\" : [ \"Tamil\", \"English\" ]\r\n" + 
			"}";
	
	
	// below is first way of deserialization
	public void usingObjectMapper() throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper(); // used object mapper
		StudentDemo student	= mapper.readValue(json, StudentDemo.class); // readvalue fuction is read json data and mappping to pojo class
		
	System.out.println(student.getIds());	
	System.out.println(student.getName());
	System.out.println(student.getSub());
		
	
	}
	
	// below is second way of deserialization
	public void usingjwayJsonpath() {
		
		JacksonMappingProvider mapper = new JacksonMappingProvider(); // using JacksonMappingProvider for to config. in market multiple mapping provider available 
		
		Configuration config    = Configuration.builder().mappingProvider(mapper).build(); // mappingProvider using for map data
		
		StudentDemo student = 	JsonPath.using(config).parse(json).read("$", StudentDemo.class);
		
		System.out.println(student.getIds());	
		System.out.println(student.getName());
		System.out.println(student.getSub());
		
	}
	
	
	//  below is third way of deserialization
	
	public void usingRestAssuredJsonPath() {
		
		io.restassured.path.json.JsonPath jsonpath = io.restassured.path.json.JsonPath.from(json);  // in second way we used jway jsonpath so we need to mentione import statement for restassured jsopath
		
		StudentDemo student	= jsonpath.getObject("$", StudentDemo.class); // we can mention $ or empty string
		System.out.println(student.getIds());	
		System.out.println(student.getName());
		System.out.println(student.getSub());
		
	}
	
	// Foutway using dirlect get json data from hit API. so As functon using restassued
	
	public void usingAsFunction() {
		
	Map<String, Object> response =	RestAssured.given().baseUri("http://localhost:3000").when().get("/Students/101").then()	.extract().body().as(new TypeRef <Map<String , Object>>() {
			
		});
	
	System.out.println(response); // total response
	
	System.out.println(response.get("id"));
	System.out.println(response.get("Name"));
	System.out.println(response.get("Sub"));
		
	}
	
	
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		DeSerialization38_41 objects = new DeSerialization38_41();
		objects.usingObjectMapper();
		 //objects.usingjwayJsonpath();
		
		//objects.usingRestAssuredJsonPath();
		
		objects.usingAsFunction();

	}

}
