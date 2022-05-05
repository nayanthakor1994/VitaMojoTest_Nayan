package com.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.TestUtil;

public class LoginPageObjects {
	
	public WebDriver driver;
	TestUtil util;
	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
	}
	
	public final String Login = "Login";
	
	By loginMenuButton = By.xpath("//a[contains(@data-test,'login-link')]");
	By txtEmail = By.id("email");
	By txtPassword = By.id("password");
	By forgotPassword = By.xpath("//button[text()='Forgot password?']");
	By btnLogin = By.xpath("//button[@data-test='auth-button' and text()='Login']");
	
	By loginTab = By.xpath("//li[@data-test='auth-tab-login']");
	By loginPageTitle = By.xpath("//h2[text()='Login']");
	
	By validatationEmail = By.xpath("//span[@data-test='email-validation-msg']");
	By validatationPassword = By.xpath("//span[@data-test='password-validation-msg']");
	
	By pageTitle = By.xpath("//h2[@display='block']");
	By btnBack = By.xpath("//button[@data-test='header-back-btn']");
	
	public void clickOnMenuLoginButton() {
		util.clickLocator(loginMenuButton);
	}

	public void waitUntilLoginPageLoaded() {
		util.waitForWebElementToBePresent(loginPageTitle, 30);
	}
	
	public void enterEmailAddress(String email) {
		util.enterText(txtEmail, email);
	}
	
	public void enterPassword(String password) {
		util.enterText(txtPassword, password);
	}
	
	public void clickOnLoginButton() {
		util.clickLocator(btnLogin);
	}
	
	public void clickOnForgotPassword() {
		util.clickLocator(forgotPassword);
	}
	
	public String getPageTitleText() {
		return util.getText(pageTitle);
	}
	
	public void clickOnBackButton() {
		util.clickLocator(btnBack);
	}
	
	
}
