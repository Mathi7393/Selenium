package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Identify the web element using selenium annotation
	@FindBy(name = "user_name")

	// declare the web element as private
	private WebElement userNameText;

	@FindBy(name = "user_password")
	private WebElement passwordText;
	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*public WebElement getUserNameText() {
		return userNameText;
	}

	public WebElement getPasswordText() {
		return passwordText;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}*/
	/**
	 * this method perform login action
	 * for code optimization instead getter methods we are using Business Libraries
	 * @param UN
	 * @param PW
	 */
	public void login(String UN, String PW) {
		userNameText.sendKeys(UN);
		passwordText.sendKeys(PW);
		loginButton.click();
	}
}
