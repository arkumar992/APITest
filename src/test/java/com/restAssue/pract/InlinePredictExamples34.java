package com.restAssue.pract;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class InlinePredictExamples34 {

	// we can give filter/condition in json path && || ! not equals --it is called inline predicate
	
	
	public static void inLinePredict() throws IOException {
		File file = new File("src/test/resources/BookJson.json");
		
		// List<Object> pricelist		= JsonPath.read(file, "$.store.book[?(@.price<10)]"); price less than 10 books .
		 // List<Object> pricelist		= JsonPath.read(file, "$.store.book[?(@.price<10 && @.category == 'fiction')].price"); price less than 10 and category is fiction
		 // List<Object> pricelist		= JsonPath.read(file, "$.store.book[?(@.price<10 || @.category == 'fiction')]"); // price less than 10 OR  category is fiction
		 
		List<Object> pricelist		= JsonPath.read(file, "$.store.book[?(!(@.price>10 || @.category == 'fiction'))]"); // price gretha 10 not equals OR category not equls to fiction
		
		for (Object price : pricelist) {
			
			System.out.println("Indefinte method price "+ price);
			
		}
				
			}
		
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		inLinePredict();
		
	}

}
