package com.restAssue.pract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class JsonSchmaValidaUseNetorkNT19 {
	@Test
	public void JsonSchemaValidate() throws IOException {
		
		File file = new File("src//test//resources//PostReqest.json");
		
		ObjectMapper mapper = new ObjectMapper(); // first step
		
	JsonNode jsondata =	mapper.readTree(file);// readTree method allowing file object so we used File class=> It's reading file and storing in Jsonnode
		
		JsonSchemaFactory factory	= JsonSchemaFactory.getInstance(VersionFlag.V4); //3rd step for set schema version using JsonSchemaFactory
		InputStream fileinput = new FileInputStream("D:\\Sel\\API\\PostReqeJsonSchemaValidaDiffLOC.json"); 
	JsonSchema schema	= factory.getSchema(fileinput); // getSchma function allow InputStream object so we used file input stream and stored data at Jsonschma class object 
	Set<ValidationMessage> message = schema.validate(jsondata); // compare json file data again that schema file
	
	if(message.isEmpty()) {
		
		System.out.println(" No error ");
	}
	
	else {
		
		for(ValidationMessage each : message) {
			
			System.out.println(each);
			
		}
		
	}
		
	}

}
