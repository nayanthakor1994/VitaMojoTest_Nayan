package com.api.pages;

import com.utility.ReadProperty;

import io.restassured.response.Response;

public class RegistrationAPIPage {
	
	APIPage apiPage;
	public RegistrationAPIPage() {
		apiPage = new APIPage();
	}
	
	public Response registerToApplication(String URL, String name, String email, String password) {
		String body = getRegistrationBody(name, email, password);
		Response res = apiPage.post(URL, body);
		System.out.println(res.getStatusCode());
		System.out.println(res.asString());
		return res;
	}
	
	private String getRegistrationBody(String name, String email, String password) {
		String storeUUID = ReadProperty.getPropertyValue("storeUUID");
		String body = "{\"profile\":{\"firstName\":\""+name+"\"},\"email\":\""+email+"\",\"password\":\""+password
				+"\",\"storeUUID\":\""+storeUUID+"\",\"locale\":\"en-GB\"}";
		
		return body;
	}
}
