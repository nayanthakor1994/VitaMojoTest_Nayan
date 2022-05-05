package com.api.stepDefination;

import org.json.JSONObject;
import org.testng.Assert;

import com.api.pages.Endpoints;
import com.api.pages.LoginAPIPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class LoginAPISteps {

	LoginAPIPage loginPage;
	String URL, responseBody;
	Response response;
	JSONObject jsonObj;
	int responseCode;
	@Before
	public void setup() {
		loginPage = new LoginAPIPage();
	}
	
	@Given("user has login api url {string}")
	public void user_has_login_api_url(String apiUrl) {
		URL = apiUrl + Endpoints.login;
	}
	
	@When("user enters {string} and {string} to the post request and verify response {int}")
	public void user_enters_and_to_the_post_request_and_verify_response(String email, String password, int code) {
		response = loginPage.loginToApplication(URL, email, password);
		responseCode = response.getStatusCode();
		System.out.println("Response code is----------->" + responseCode);
		Assert.assertEquals(responseCode, code, "Verify status code from response");
	}
	
	@When("verify logged in user {string} and {string}")
	public void verify_logged_in_user_and(String email, String username) {
		responseBody = response.asString();
		System.out.println("Response body is----------->" + responseBody);
		jsonObj = new JSONObject(responseBody);
		Assert.assertEquals(jsonObj.getJSONObject("payload").getJSONObject("user").get("email"),
				email, "Verify email id of user");
		Assert.assertEquals(jsonObj.getJSONObject("payload").getJSONObject("user").getJSONObject("profile").get("firstName"),
				username, "Verify name of the user");
	}
}
