package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
// anyway we are creating object for utility packages in test case so we need to avoid object creation 
// but anyway we need to use the methods present in utility class so we are inheriting those class by using extends key word
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(xpath = ".//img[@src='themes/softed/images/user.PNG']")
	private WebElement aministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOrgLink() {
		orgLink.click();
	}

	public void clickContact() {
		contactLink.click();
	}

	public void logout(WebDriver driver) {
		moveToElement(driver, aministratorImg);
		signoutLink.click();
	}
}
