package com.restAssue.pract;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllData {
	
	@Test
	public void getAllStudData() {
		
		RestAssured.baseURI ="http://localhost:3000/";
		
		RequestSpecification requestspecific	= RestAssured.given();
		
		Response response = requestspecific.request(Method.GET,"Students");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
		
		
	}

}
