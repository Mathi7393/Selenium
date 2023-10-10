package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	@FindBy(name="lastname")
	private WebElement lastNameText;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addContact(String lastName) {
		lastNameText.sendKeys(lastName);
		saveButton.click();
	}
}
