package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	@FindBy(name="accountname")
	private WebElement orgNameTextFiled;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addOrg(String OrgName) {
		orgNameTextFiled.sendKeys(OrgName);
		saveButton.click();
	}
}
