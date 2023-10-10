package com.crm.vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organisationInfoPage {
	@FindBy(css = ".dvHeaderText")
	private WebElement OrgNameHeader;
	
	public organisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getCreatedOrgName() {
		return OrgNameHeader.getText();
	}
}
