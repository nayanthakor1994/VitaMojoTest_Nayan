package com.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.TestUtil;

public class RegistrationPageObjects {

	public WebDriver driver;
	TestUtil util;

	public RegistrationPageObjects(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
	}
	
	public final String CreateYourAccount = "Create your account";

	By createAccountTab = By.xpath("//li[@data-test='auth-tab-register']");
	By createAccountPageTitle = By.xpath("//h2[text()='Create your account']");
	By txtName = By.id("firstName");
	By txtEmail = By.id("email");
	By txtPhoneCode = By.xpath("//input[@id='phoneNumber']/parent::div//*[name()='svg']");
	By txtPhoneNumber = By.id("phoneNumber");
	By txtPassword = By.id("password");
	By dicountAndOffer = By.xpath("//input[@name='marketing']/parent::label");
	By btnCreateAccount = By.xpath("//button[@data-test='auth-button']");

	By validatationFirstname = By.xpath("//span[@data-test='firstName-validation-msg']");
	By validatationEmail = By.xpath("//span[@data-test='email-validation-msg']");
	By validatationPhoneNumber = By.xpath("//span[@data-test='phoneNumber-validation-msg']");
	By validatationPassword = By.xpath("//span[@data-test='password-validation-msg']");

	By pageTitle = By.xpath("//h2[@display='block']");
	
	public void waitUntilCreateAccountPageLoaded() {
		util.waitForWebElementToBePresent(createAccountPageTitle, 30);
	}
	
	public void clickOnCreateAccountTab() {
		util.clickLocator(createAccountTab);
	}

	public void enterName(String name) {
		util.enterText(txtName, name);
	}

	public void enterEmailAddress(String email) {
		util.enterText(txtEmail, email);
	}
	
	private By getCountryCodeXpath(String code) {
		return By.xpath("//label[@for='phoneNumber']/following-sibling::div//li//span[contains(text(),'"+code+"')]");
	}
	
	public void enterPhoneNumber(String code, String phoneNumber) {
		util.clickLocator(txtPhoneCode);
		util.dummyWait(2);
		By countryCode = getCountryCodeXpath(code);
		util.clickLocator(countryCode);
		util.dummyWait(2);
		util.enterText(txtPhoneNumber, phoneNumber);
	}
	
	public void enterPassword(String password) {
		util.enterText(txtPassword, password);
	}
	
	public void clickOnCreateAccountButton() {
		util.clickLocator(btnCreateAccount);
	}

	public String getPageTitleText() {
		return util.getText(pageTitle);
	}

}
