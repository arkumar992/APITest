package com.restAssue.pract;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class FluentAPI_32 {


	public static void method1FluentAPI() throws IOException {


		File fi = new File("src/test/resources/BookJson.json");

		DocumentContext context	= JsonPath.parse(fi);

		List<Object>	pricelist		= 	 context.read("$..price");
		for (Object price : pricelist) {

			System.out.println("price method 1 "+ price);

		}

	}


	public static void method2FluentAPI() throws IOException {


		File fi = new File("src/test/resources/BookJson.json");
		
		Configuration config	=  Configuration.defaultConfiguration();
		
		List<Object>	pricelist2 = JsonPath.using(config).parse(fi).read("$..price");
		
		for (Object price : pricelist2) {

			System.out.println("price per 2nd method  "+ price);

		}


	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		method1FluentAPI();
		method2FluentAPI();
	}

}
