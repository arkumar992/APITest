package com.restAssue.pract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;



import com.google.common.io.ByteStreams;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import io.restassured.internal.util.IOUtils;

public class ReadingJsonUseJway30_31 {

	public static void readJson() throws IOException {
		
		File file = new File("src/test/resources/BookJson.json");
		
List<Object> pricelist		= JsonPath.read(file, "$..price");

for (Object price : pricelist) {
	
	System.out.println("price "+ price);
	
}
		
	}
	
	
	public static void readOneTimeJsonfile() throws IOException {
		
		
		InputStream  fr = new FileInputStream("src/test/resources/BookJson.json");
		
		//readAllBytes method not coming so i used below step for bytes array
		
		// byte[] bytes = ByteStreams.toByteArray(fr); // this line also will work
		
		byte[] bytes = IOUtils.toByteArray(fr);   
		
Object pareJsondoc	=	Configuration.defaultConfiguration().jsonProvider().parse(bytes);  

List<Object> categorylist		= JsonPath.read(pareJsondoc, "$..category");

for (Object category : categorylist) {
	
	System.out.println("category "+ category);
	
}

		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readOneTimeJsonfile();
		// readJson();

	}

}
