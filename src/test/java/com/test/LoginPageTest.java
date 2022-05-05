package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.web.pages.LoginPageObjects;

public class LoginPageTest {
	WebDriver driver;
	LoginPageObjects loginPage;
	public LoginPageTest(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPageObjects(driver);
	}

	public void navigateToLoginPage() {
		loginPage.clickOnMenuLoginButton();
		loginPage.waitUntilLoginPageLoaded();
	}
	
	public void verifyLoginPage() {
		Assert.assertEquals(loginPage.getPageTitleText(), loginPage.Login, "Verify user is navigated to login page");
	}
	
	public void userShouldBeAbleEnterDetails(String userName, String password) {
		loginPage.enterEmailAddress(userName);
		loginPage.enterPassword(password);
	}
	
	public void clickOnLoginButton() {
		loginPage.clickOnLoginButton();
	}

}
