package com.webservices.testone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class HttpPostRequest {


	public void postReq() throws IOException {

		URL url = new URL("http://jsonplaceholder.typicode.com/posts");
		URLConnection connect = url.openConnection();
		HttpURLConnection ht = (HttpURLConnection) connect ;
		ht.setRequestMethod("POST");
		ht.setRequestProperty("Cotent-Type", "application/json; charset=UTF-8");
		ht.setDoOutput(true);

		String jsonbody = "\r\n" + 
				"{\r\n" + 
				"    \r\n" + 
				"    \"tiltle\":\"foo\",\r\n" + 
				"    \"userId\":1,\r\n" + 
				"    \"body\":\"bar\"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";

		byte[] inputvalue =	jsonbody.getBytes();

		OutputStream ocp = ht.getOutputStream();
		ocp.write(inputvalue);
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
		System.out.println(sb);


	}
	
	
	public void putReq() throws IOException {
		
		URL url = new URL("http://jsonplaceholder.typicode.com/posts/1");
		URLConnection connect = url.openConnection();
		HttpURLConnection ht = (HttpURLConnection) connect ;
		ht.setRequestMethod("PUT");
		ht.setRequestProperty("Cotent-Type", "application/json; charset=UTF-8");
		ht.setDoOutput(true);

		String jsonbody = "{\r\n" + 
				"\"id\": 1,\r\n" + 
				"\r\n" + 
				"\"title\":\"foo\",\r\n" + 
				"\"body\": \"bar\",\r\n" + 
				"\"userId\":1}";

		byte[] inputvalue =	jsonbody.getBytes();

		OutputStream ocp = ht.getOutputStream();
		ocp.write(inputvalue);
		System.out.println("Response code "+ ht.getResponseCode());
		System.out.println("Response message "+ ht.getResponseMessage());

		InputStream in = ht.getInputStream();

		InputStreamReader re = new InputStreamReader(in);
		BufferedReader bf = new BufferedReader(re);


		String line;

		StringBuffer sb = new StringBuffer();


		while(( line=bf.readLine())!= null) {


			sb.append(line);

		}
		System.out.println(sb);

		
		
	}

	public void delReq() throws IOException {

		URL url = new URL("http://jsonplaceholder.typicode.com/posts/1");
		URLConnection connect = url.openConnection();
		HttpURLConnection ht = (HttpURLConnection) connect ;
		ht.setRequestMethod("DELETE");
		ht.setRequestProperty("Cotent-Type", "application/json; charset=UTF-8");
		ht.setDoOutput(true);

		
		System.out.println("Response code "+ ht.getResponseCode());
		System.out.println("Response message "+ ht.getResponseMessage());

		InputStream in = ht.getInputStream();

		InputStreamReader re = new InputStreamReader(in);
		BufferedReader bf = new BufferedReader(re);


		String line;

		StringBuffer sb = new StringBuffer();


		while(( line=bf.readLine())!= null) {


			sb.append(line);

		}
		System.out.println(sb);

		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		HttpPostRequest po = new HttpPostRequest();
		//po.postReq();
		po.putReq();
		//po.delReq();

	}

}
