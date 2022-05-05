package com.api.stepDefination;

import org.json.JSONObject;
import org.testng.Assert;

import com.api.pages.Endpoints;
import com.api.pages.RegistrationAPIPage;
import com.utility.TestUtil;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class RegistrationAPISteps {

	RegistrationAPIPage registerPage;
	String URL, responseBody, emailID;
	Response response;
	JSONObject jsonObj;
	int responseCode;
	@Before
	public void setup() {
		registerPage = new RegistrationAPIPage();
	}

	@Given("user has registration api url {string}")
	public void user_has_registration_api_url(String apiUrl) {
		URL = apiUrl + Endpoints.Registration;
	}

	@When("create new user with {string}, {string} and {string} and verify response {int}")
	public void create_new_user_with_and_and_verify_response(String name, String email, String password, int code) {
		emailID = "Random."+TestUtil.randomGenerator(3) + "."+email;
		response = registerPage.registerToApplication(URL, name, emailID, password);
		responseCode = response.getStatusCode();
		System.out.println("Response code is----------->" + responseCode);
		Assert.assertEquals(responseCode, code, "Verify status code from response");
	}
	
	@When("verify registered {string}")
	public void verify_registered(String username) {
		responseBody = response.asString();
		System.out.println("Response body is----------->" + responseBody);
		jsonObj = new JSONObject(responseBody);
		Assert.assertEquals(jsonObj.getJSONObject("payload").getJSONObject("user").get("email"), emailID,
				"Verify email id of user");
		Assert.assertEquals(
				jsonObj.getJSONObject("payload").getJSONObject("user").getJSONObject("profile").get("firstName"),
				username, "Verify name of the user");
	}
}
