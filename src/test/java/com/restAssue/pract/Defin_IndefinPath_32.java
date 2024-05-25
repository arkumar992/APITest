package com.restAssue.pract;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class Defin_IndefinPath_32 {

	//definite path -- will retun exact result  example if mentioned index in json path it will return output as respective data type so we need to mention correct data type
	
	//Indefinite path  --- it will return multiple output(list of output) due to path is deep scan(..$author),expression(? expresion), solved path,muliple array index [0,1],[0:2]
	

	
	public static void definePathexample() throws IOException {
		
		File file = new File("src/test/resources/BookJson.json");
		
		double pricelist		= JsonPath.read(file, "$.store.book[2].price");
        System.out.println("price "+ pricelist);
			
		
	}
	
	public static void inDefinePathexample() throws IOException {
	File file = new File("src/test/resources/BookJson.json");
	
	List<Object> pricelist		= JsonPath.read(file, "$..price");

	for (Object price : pricelist) {
		
		System.out.println("Indefinte method price "+ price);
		
	}
			
		}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		definePathexample();
		inDefinePathexample();
;	}

}
