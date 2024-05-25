package com.restAssue.pract;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class CustomPredicate36 {

	
	public void myCustomPredict() throws IOException {
		// we can writer our own customized predicate using Predicate interface apply method
		
		//Functional interface is have one Method only with some interface. example Predicate interface.
		
		File file = new File("src/test/resources/BookJson.json");
		
		/*Predicate bookwithISBN = new Predicate() {

			@Override
			public boolean apply(PredicateContext ctx) {
				// TODO Auto-generated method stub
				
				boolean customPredicate = ctx.item(Map.class).containsKey("isbn");
				 // boolean customPredicate1 = ctx.item(List.class).contains(bookwithISBN); // we can define our requirment based class in item method
							
				//
				return customPredicate;	
				
			}
			
		};*/
		
		
		//we can writ using lamda expression instead of above lines note instead of ref is anything we can give because its parameter reference
		
		Predicate bookwithISBN  = ref->ref.item(Map.class).containsKey("isbn");
		
List<Map<String,Object>>	 result = 	JsonPath.read(file, "$.store.book[?].isbn", bookwithISBN);
		System.out.println(result);	
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CustomPredicate36  cp= 	new CustomPredicate36();
		cp.myCustomPredict();
		
		
	}

}
