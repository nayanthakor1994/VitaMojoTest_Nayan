package com.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.TestUtil;

public class HomePageObjects {

	public WebDriver driver;
	TestUtil util;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
	}

	By userHomePage = By.xpath("//button[@data-test='header-profile-back-btn']");
	By logoImage = By.xpath("//img[@data-test='logo']");
	By userNameLogo = By.xpath("//a[@data-test='preorder.profile.orders-history-link']");
	By myOrders = By.xpath("//a[@data-test='preorder.profile.orders-history-link']//span[text()='My Orders']");
	By myAccount = By.xpath("//a[@data-test='preorder.profile.settings-link']//span[text()='My Account']");
	By loggedInUser = By.xpath("//a[@data-test='preorder.profile.orders-history-link']//span[2]");
	
	public void waitForHomePage() {
		util.waitForWebElementToBePresent(userHomePage, 20);
	}

	public boolean isHomePageLoaded() {
		return util.isElementPresent(userHomePage, 20);
	}

	public boolean isMainPageLoaded() {
		return util.isElementPresent(logoImage, 20);
	}

	public boolean isMyOrdersDisplayed() {
		return util.isElementPresent(myOrders, 20);
	}

	public boolean isMyAccountDisplayed() {
		return util.isElementPresent(myAccount, 20);
	}

	public void waitUntilMainPageLoaded() {
		util.waitForWebElementToBePresent(logoImage, 20);
	}

	public void clickOnUserName() {
		util.clickLocator(userNameLogo);
	}
	
	public String getLoggedInUserName() {
		return util.getText(loggedInUser);
	}
}
