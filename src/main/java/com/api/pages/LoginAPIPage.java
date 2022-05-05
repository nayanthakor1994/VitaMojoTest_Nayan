package com.api.pages;

import io.restassured.response.Response;

public class LoginAPIPage {
	
	
	APIPage apiPage;
	public LoginAPIPage() {
		apiPage = new APIPage();
	}
	
	public Response loginToApplication(String URL, String email, String password) {
		String body = getLoginBody(email, password);
		Response res = apiPage.post(URL, body);
		return res;
	}
	
	private String getLoginBody(String email, String password) {
		String body = "{\"email\":\""+email+"\",\"password\":\""+password+"\"}";
		return body;
	}

}
