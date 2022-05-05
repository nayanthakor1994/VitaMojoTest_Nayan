package com.web.stepDefination;

import com.test.LoginPageTest;
import com.test.RegistrationPageTest;
import com.web.base.DriverFactory;
import com.web.pages.SignoutPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	LoginPageTest loginPage;
	RegistrationPageTest registerPage;
	SignoutPage signOut;
	
	@Before
	public void setup() {
		loginPage = new LoginPageTest(DriverFactory.getTLDriver());
		registerPage = new RegistrationPageTest(DriverFactory.getTLDriver());
		signOut = new SignoutPage(DriverFactory.getTLDriver());
	}
	
	@Given("Redirected to login page")
	public void redirected_to_login_page() {
		loginPage.navigateToLoginPage();
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginPage.verifyLoginPage();
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String email, String password) {
		loginPage.userShouldBeAbleEnterDetails(email, password);
	}

	@When("user clicked on login button")
	public void user_clicked_on_login_button() {
		loginPage.clickOnLoginButton();
	}
	
	@Then("user is navigated to the home page {string}")
	public void user_is_navigated_to_the_home_page(String userName) {
		registerPage.verifyRegistrationSuccessful(userName);
		signOut.clickOnSignOut();
		signOut.waitUntilSignout();
	}
	
}
