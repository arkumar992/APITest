package com.restAssue.pract;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderExample47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecBuilder re = new RequestSpecBuilder();
		re.setBaseUri("http://localhost:3000");
		re.setBasePath("/Students");
		RequestSpecification rs = re.build();
		//we can right one line of code as below . no need above three lines if using below line
		// RequestSpecification rs =	re.setBaseUri("").setBasePath("").build();
		
		 RestAssured.given().spec(rs).when().get().prettyPrint();
		// we can right mention specification variable at direcly in  given funtion like below
		//RestAssured.given(rs).when().get().prettyPrint();

	}

}
