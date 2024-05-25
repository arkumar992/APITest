package com.restAssue.pract;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

import static com.jayway.jsonpath.Filter.filter;
public class FilterPredicatteAPI35 {
	
	 File file = new File("src/test/resources/BookJson.json");

	public  void filterAPIPredictExamble() throws IOException {
		
		Filter priceLessthanten = Filter.filter(Criteria.where("price").lt(10));  //. using filter class filter method enter criteria  via criteria class functions
		
		List<Object> pricelist = JsonPath.read(file, "$.store.book[?]", priceLessthanten);
		
		System.out.println(pricelist);
		
	}
	
	
	public  void secondfilterAPIPredictExamble() throws IOException {
	
		Filter secondcriteria = Filter.filter(Criteria.where("price").lt(10).and("category").is("fiction")); // price less than 10 and category is fiction
		
		List<Object> pricelist = JsonPath.read(file, "$.store.book[?]", secondcriteria);
		System.out.println(pricelist);
		// we can write instead of  List <Object> , we can use MAP because key and value have JSON and if use this we can get particular key value to print
		
		List<Map<String,Object>> secondcriter = JsonPath.read(file, "$.store.book[?]", secondcriteria);
		
		System.out.println(secondcriter.get(0).get("author"));
	
	}
	
	
	public  void thirdfilterAPIPredictExamble() throws IOException {
		
		//we can writer direct filter method when if static import done initially
	Filter thirdcriter	= filter(Criteria.where("price").gt(10).and("category").is("fiction")); // greather than 10 and category equals fiction
	List<Map<String,Object>> result = JsonPath.read(file, "$.store.book[?]", thirdcriter);
	System.out.println("thirdFiterResult"+ result);
	System.out.println(result.get(0).get("author"));
	
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FilterPredicatteAPI35 filterAPI =  new FilterPredicatteAPI35();
		
		filterAPI.filterAPIPredictExamble();
		filterAPI.secondfilterAPIPredictExamble();
		filterAPI.thirdfilterAPIPredictExamble();
	}

}
