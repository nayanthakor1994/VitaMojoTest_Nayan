package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utility.TestUtil;
import com.web.pages.HomePageObjects;
import com.web.pages.RegistrationPageObjects;

public class RegistrationPageTest {

	WebDriver driver;
	RegistrationPageObjects registerPage;
	HomePageObjects homePage;
	public RegistrationPageTest(WebDriver driver) {
		this.driver = driver;
		registerPage = new RegistrationPageObjects(driver);
		homePage = new HomePageObjects(driver);
	}

	public void navigateToRegistrationPage() {
		registerPage.clickOnCreateAccountTab();
		registerPage.waitUntilCreateAccountPageLoaded();
		Assert.assertEquals(registerPage.getPageTitleText(), registerPage.CreateYourAccount,
				"Verify user is navigated to Create Your Account page");
	}

	public void userShouldBeAbleToEnterRegistrationDetails(String userName, String email, String password) {
		registerPage.enterName(userName);
		email = "Random."+TestUtil.randomGenerator(3) + "."+email;
		registerPage.enterEmailAddress(email);
		registerPage.enterPassword(password);
	}

	public void clickOnCreateAccount() {
		registerPage.clickOnCreateAccountButton();
	}

	public void verifyRegistrationSuccessful(String username) {
		Assert.assertEquals(homePage.getLoggedInUserName(), username,
				"Verify user is navigated to Create Your Account page");
		homePage.clickOnUserName();
		homePage.waitForHomePage();
		
		Assert.assertTrue(homePage.isMyOrdersDisplayed(), "Verify that my order tab is displayed");
		Assert.assertTrue(homePage.isMyAccountDisplayed(), "Verify that my account tab is displayed");
	}
}
