package com.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.TestUtil;

public class SignoutPage {
	
	public WebDriver driver;
	TestUtil util;
	public SignoutPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
	}
	
	By signOut = By.xpath("//button[@data-test='header-profile-sign-out']");
	
	public void clickOnSignOut() {
		util.clickLocator(signOut);
	}
	
	public void waitUntilSignout() {
		util.waitForElementToNotBePresent(signOut, 10);
	}
	
}
