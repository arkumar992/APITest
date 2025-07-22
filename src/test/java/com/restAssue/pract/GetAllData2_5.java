package com.restAssue.pract;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllData2_5 {

	@Test(enabled = false)
	
	// Below method for video 2 - Get request Non BDD style
	public void getAllStudData() {

		RestAssured.baseURI ="http://localhost:3000/";

		RequestSpecification requestspecific	= RestAssured.given();

		Response response = requestspecific.request(Method.GET,"Students");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());


	}

	@Test(enabled = false)
	// Below method for video 3 - Post Request Non Bdd Style
	public void creatAnemployee() {

		RestAssured.baseURI ="http://localhost:3000"; //if end with / then request should not start with /
		RequestSpecification requestspecifi	= RestAssured.given().header("Content-Type","application/json").body("{\r\n" + 
				"    \"Name\": \"RestAss\",\r\n" + 
				"    \"Sub\": [\r\n" + 
				"      \"Social\",\r\n" + 
				"      \"Tamil\"\r\n" + 
				"    ]\r\n" + 
				"  }");

		Response re	= requestspecifi.request(Method.POST,"/Students");

		System.out.println(re.asPrettyString());
		System.out.println(re.getStatusLine());
	}
	
	@Test(enabled = false)
	
	// below method for video 4 - Put request Non bdd style
	public void updateStudent() {
		
		RestAssured.baseURI = "http://localhost:3000";
	RequestSpecification requestspec	= RestAssured.given().header("content-type","application/json").body(" {\r\n" + 
				"    \"Name\": \"id138updated\",\r\n" + 
				"    \"Sub\": [\r\n" + 
				"      \"rest\",\r\n" + 
				"      \"assured\"\r\n" + 
				"    ]\r\n" + 
				"  }");
	Response res = requestspec.request(Method.PUT,"/Students/138");
	System.out.println(res.asPrettyString());
	System.out.println(res.getStatusLine());
	}
	// below method for video 5 - Delete request non bdd style
	@Test()
	public void deleteaId() {
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification res =RestAssured.given();
		
		Response rs = res.request(Method.DELETE,"/Students/149");
		
		System.out.println(rs.asPrettyString());
		System.out.println(rs.getStatusLine());
	}
	

}
