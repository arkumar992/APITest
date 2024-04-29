package com.restAssue.pract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchmaValidaUseHamCrest20 {
	
	@Test
	public void HamCresetMethod() throws IOException {
	
	File file = new File("src//test//resources//PostReqest.json");
	
	String jsonContent = FileUtils.readFileToString(file,"UTF-8"); // using Apache common io jar then FileUtils use for covert to string
	
	InputStream fileinput = new FileInputStream("D:\\Sel\\API\\PostReqeJsonSchemaValidaDiffLOC.json");
	
	MatcherAssert.assertThat(jsonContent, JsonSchemaValidator.matchesJsonSchema(fileinput)); // easy way to compare
	
	
	}

}
