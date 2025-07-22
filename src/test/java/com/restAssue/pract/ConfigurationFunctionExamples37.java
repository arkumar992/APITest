package com.restAssue.pract;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class ConfigurationFunctionExamples37 {


	String json = "{\r\n" + 
			"  \"Students\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 100,\r\n" + 
			"      \"Name\": \"Arun\",\r\n" + 
			"      \"Sub\": [\r\n" + 
			"        \"Tamil\",\r\n" + 
			"        \"English\"\r\n" + 
			"      ]\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 101,\r\n" + 
			"      \"Sub\": [\r\n" + 
			"        \"Maths\",\r\n" + 
			"        \"Science\"\r\n" + 
			"      ]\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"	]\r\n" + 
			"\r\n" + 
			"}";
	
	File file = new File("src/test/resources/BookJson.json");

	// this method show define path data if wrong or not available it will retun null
	public void method1() {






		/*Configuration config	=  Configuration.defaultConfiguration();

		config = config.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);*/ //  1) Null value return when definete path doesn't have exact json path

		// instead above two lines we can write below as well
		Configuration config = Configuration.builder().options(Option.DEFAULT_PATH_LEAF_TO_NULL).build();
		// List<Object>	namelist  = JsonPath.using(config).parse(json).read("$.Students[0].Name");
		String	name  = JsonPath.using(config).parse(json).read("$.Students[1].Name"); //1) Null  Option  : when using definite path but key not found in JSON at the time Path not found exception will get we can use DEFAULT_PATH_LEAF_TO_NULL method overcome
		List<Object>	namelist = JsonPath.using(config).parse(json).read("$.Students[*].Name");
		System.out.println(name); // output : null
		System.out.println(namelist); // output : ["Arun",null]


	}

	//  this method show how to get all data as list even definte path if used in json path
	public void method2() throws IOException {

		Configuration config	=  Configuration.defaultConfiguration();
		config = config.addOptions(Option.ALWAYS_RETURN_LIST); //this method convert alldata type value as list  
		List<Object>	namelist  = JsonPath.using(config).parse(json).read("$.Students[0].Name"); // if we put [1] path not fount exception will come
		List<Object> pricelist=JsonPath.using(config).parse(file).read("$.store.book[2].price"); 
		System.out.println(namelist+ " "+ pricelist); // output : ["Arun"]
	} 

	//this method  will return null when we won't exception but if we mentioned ALWAYS_RETURN_LIST config then empty array will show instead of null.

	public void method3() {

		Configuration config	=  Configuration.defaultConfiguration();
		config = config.addOptions(Option.SUPPRESS_EXCEPTIONS);
		String	namelist2  = JsonPath.using(config).parse(json).read("$.Students[1].Name"); // student 1 name key not available
		config = config.addOptions(Option.ALWAYS_RETURN_LIST);

		List<String>	namelist  = JsonPath.using(config).parse(json).read("$.Students[1].Name");
		System.out.println(namelist); // output : []

		System.out.println(namelist2); //output : null
	}

	// below method for set mandatory key when we using indefine path. students[1] name details not available so get exception to identify
	public void method4() {
		Configuration config	=  Configuration.defaultConfiguration();
		
		config = config.addOptions(Option.REQUIRE_PROPERTIES); // using this function we can get console exception for path not found - No results for path: $['Students'][1]['Name'
		
		List<String>	namelist  = JsonPath.using(config).parse(json).read("$.Students[*].Name");
		System.out.println(namelist); // output : get path not found exception - No results for path: $['Students'][1]['Name']

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ConfigurationFunctionExamples37 mm =  new ConfigurationFunctionExamples37();
		// mm.method1();
		//mm.method2();
		//mm.method3();
		mm.method4();

	}

}
