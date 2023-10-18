package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	@FindBy(css = ".dvHeaderText")
	private WebElement contHeaderName;
	
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getContHeaderName() {
		return contHeaderName.getText();
		
	}
}
