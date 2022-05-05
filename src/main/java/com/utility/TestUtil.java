package com.utility;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	Actions actions;
	public static final int maxTimeout = 30;
	
	public TestUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, maxTimeout);
		actions = new Actions(driver);
		jse = (JavascriptExecutor) driver;
	}
	
	
	public void waitForWebElementToBeClickable(By locator) {
		scrollToElement(locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForWebElementToBeClickable(By locator, int variableWaitTime) {
		WebDriverWait variableWait = new WebDriverWait(driver, variableWaitTime);
		scrollToElement(locator);
		variableWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitForWebElementToBeClickableReturnElement(By locator) {
		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return clickableElement;
	}
	
	public void waitForWebElementToBePresent(By locator) {
		scrollToElement(locator);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForWebElementToBePresent(By locator, int variableWaitTime) {
		WebDriverWait variableWait = new WebDriverWait(driver, variableWaitTime);
		scrollToElement(locator);
		variableWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForWebElementToBePresentReturnElement(By locator) {
		scrollToElement(locator);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForElementToNotBePresent(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.numberOfElementsToBe(locator, 0));
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void scrollToElement(By locator) {
		WebElement element = getElement(locator);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);", element);
	}
	
	public boolean isElementPresent(By by, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	public void clickLocator(By locator) {
		scrollToElement(locator);
		try {
			getElement(locator).click();
		} catch (Exception e1) {
			actions.moveToElement(waitForWebElementToBeClickableReturnElement(locator)).click().build().perform();
		}
	}
	
	public void jsClick(By locator) {
		scrollToElement(locator);
		try {
			jse.executeScript("arguments[0].click();", waitForWebElementToBePresentReturnElement(locator));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", waitForWebElementToBePresentReturnElement(locator));
		}
	}
	
	public void enterText(WebElement inputField, String text) {
		try {
			inputField.click();
			inputField.clear();
			inputField.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterText(By locator, String text) {
		try {
			WebElement inputField = getElement(locator);
			inputField.click();
			inputField.clear();
			inputField.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dummyWait(int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='dummywait']")));
		} catch (Exception e) {
		}
	}
	
	public String getText(By locator) {
		try {
			return waitForWebElementToBeClickableReturnElement(locator).getText();
		} catch (Exception e1) {
			return getTextByJS(locator);
		}
	}
	
	public String getTextByJS(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) ((js).executeScript("return arguments[0].value",
				driver.findElement(locator)));
		return value;
	}
	
	public static String randomGenerator(int size) {
		char[] chars = "QWERTYUIOPLKJHGFDSAZXCVBNM1234567890".toCharArray();
		StringBuilder sb = new StringBuilder(5);
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String dcValue = sb.toString();
		return dcValue;
	}
}
