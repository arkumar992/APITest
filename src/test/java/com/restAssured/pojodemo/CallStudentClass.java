package com.restAssured.pojodemo;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CallStudentClass {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		
		
		StudentDemo sd = new StudentDemo();
		sd.setName("arunkumarr");
		sd.setIds("Abc123");
		sd.setSub(Arrays.asList("Tamil","English"));
		
		ObjectMapper mapper = new ObjectMapper(); // its most important for converting normal object values to Json format.
		String studetJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sd); // remember this function
		System.out.println(studetJson);
	}

}
