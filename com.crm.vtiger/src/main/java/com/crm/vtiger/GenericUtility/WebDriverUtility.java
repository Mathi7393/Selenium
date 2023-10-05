package com.crm.vtiger.GenericUtility;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize window
	 * @param driver
	 */
	public void maximizeWebPage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize window
	 * @param driver
	 */
	public void minimizeWebPage(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to make the web page to wait for certain time until the condition met
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstant.implicitWaitDuration));
	}
	/**
	 * This method is used to make the web page to wait for certain time until the condition met-element is visible
	 * @param driver
	 * @param element
	 */
	public void visibleElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to make the web page to wait for certain time until the condition met-element is clickable
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method is used to check the alert pop-up is present in the web page
	 * this method is used to check pop up is alert type or not
	 * @param driver
	 * @param element
	 */
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method is used to check the Web page title
	 * @param driver
	 * @param title
	 */
	public void titlePresent(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method is used to check the url of the Web page
	 * @param driver
	 * @param url
	 */
	public void urlPresent(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * This method is used avoid the exception by using Explicit wait method
	 * @param driver
	 */
	public void ignoreException(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
}
