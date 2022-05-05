package com.web.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utility.ReadProperty;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public synchronized static void setTLDriver (String browser) {
		System.out.println("Browser : " + browser);
		
		if (browser.equals("firefox")) {
			tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver());
			tlDriver.get().manage().window().maximize();
		} else if (browser.equals("chrome")) {
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
			tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver());
			tlDriver.get().manage().window().maximize();
			tlDriver.get().get(ReadProperty.getPropertyValue("URL"));
		}
	}

	public synchronized static WebDriver getTLDriver () {
		try {
			return tlDriver.get();
		}catch (Exception e) {
			return tlDriver.get();
		}
	}

}
