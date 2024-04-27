package com.webservices.testone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpgetRequestExample {

	
	public void getMethod() throws IOException {
		
		URL url = new URL("http://jsonplaceholder.typicode.com/posts");
		//URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
		URLConnection connect = url.openConnection();
	HttpURLConnection ht = (HttpURLConnection) connect ;
	//HttpURLConnection ht = (HttpURLConnection)url.openConnection();
	
	ht.setRequestMethod("GET");
	ht.connect();
	System.out.println("Response code "+ ht.getResponseCode());
	System.out.println("Response message "+ ht.getResponseMessage());
	

	InputStream in = ht.getInputStream();
	
	InputStreamReader re = new InputStreamReader(in);
	BufferedReader bf = new BufferedReader(re);
	
	
	String line;
	
	StringBuffer sb = new StringBuffer();
	
	
	while(( line=bf.readLine())!=null) {
		
		
		sb.append(line);
		
	}
	System.out.println("testing"+sb);
	
	
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HttpgetRequestExample hc = new HttpgetRequestExample();
		hc.getMethod();

	}

}
