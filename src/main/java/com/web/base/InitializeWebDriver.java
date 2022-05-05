package com.web.base;

import com.utility.ReadProperty;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class InitializeWebDriver {

	@Before
	public void launchBrowser() {
		String browserName = ReadProperty.getPropertyValue("browserName");
		DriverFactory.setTLDriver(browserName);
	}

	@After
	public void quitBrowser() {
		DriverFactory.getTLDriver().quit();
	}
}
