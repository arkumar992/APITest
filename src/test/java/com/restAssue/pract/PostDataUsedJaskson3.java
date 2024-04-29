package com.restAssue.pract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostDataUsedJaskson3 {
	
	@Test()
	public void postDatauseJackson() {
		
		HashMap<String, Object> jsonbody = new HashMap<String , Object>();
		
		jsonbody.put("Name", "Lenovo1");
		jsonbody.put("Core", "Practive");
		List<String> subject = new ArrayList<String>();
		
		subject.add("Compute");
		subject.add("Jso");
		
		jsonbody.put("Sub", subject);
		System.out.println(jsonbody);
		// just added jackson databind jar , system automatically convert normal hashmap data to json data.
		RestAssured.given().baseUri("http://localhost:3000").header("content-type", "application/json").body(jsonbody)
		.log().all().when().post("/Students").then().log().all();
	}
	
	

}
