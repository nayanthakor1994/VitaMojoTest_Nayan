package com.web.stepDefination;

import com.test.LoginPageTest;
import com.test.RegistrationPageTest;
import com.web.base.DriverFactory;
import com.web.pages.SignoutPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	
	LoginPageTest loginPage;
	RegistrationPageTest registerPage;
	SignoutPage signOut;
	
	@Before
	public void setup() {
		loginPage = new LoginPageTest(DriverFactory.getTLDriver());
		registerPage = new RegistrationPageTest(DriverFactory.getTLDriver());
		signOut = new SignoutPage(DriverFactory.getTLDriver());
	}
	
	@Given("user is on Registration page")
	public void user_is_on_registration_page() {
		loginPage.navigateToLoginPage();
		registerPage.navigateToRegistrationPage();
	}

	@When("user enters {string}, {string} and {string}")
	public void user_enters_username_email_address_password(String userName, String email, String password) {
		registerPage.userShouldBeAbleToEnterRegistrationDetails(userName, email, password);
	}

	@When("click on Create Account button")
	public void click_on_create_account_button() {
		registerPage.clickOnCreateAccount();
	}

	@Then("verify that user is successfully able to create account {string}")
	public void verify_that_user_is_successfully_able_to_create_account(String userName) {
		registerPage.verifyRegistrationSuccessful(userName);
		signOut.clickOnSignOut();
		signOut.waitUntilSignout();
	}

}
