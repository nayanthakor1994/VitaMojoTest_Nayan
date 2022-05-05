package com.api.pages;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIPage {
	
RequestSpecification request;
	
	public Response get(String URL) {
		request = RestAssured.given();
		request.headers(getHeader());
		return request.get(URL);
	}
	
	public Map<String, Object> getHeader() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "*/*");
		headerMap.put("tenant", "695a1486-80e7-4ee6-bc55-f4911944ef2a");
		return headerMap;
	}
	
	public Response post(String apiURL,String newBody) {
		System.out.println("API URL for POST request : " + apiURL);
		System.out.println("API body for POST request : " + newBody);
		request = RestAssured.given();
		request.headers(getHeader());
		request.body(newBody);
		return request.post(apiURL);
	}

}
