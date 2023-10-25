package com.crm.vtiger.ObjectRepositary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartAutoSuggetionPage {
	@FindBy(xpath = "//div[@class='left-pane-results-container']/descendant::div[@class='s-suggestion-container']")
	private List<WebElement> suggetions;
	
	public flipkartAutoSuggetionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonauto() {
		System.out.println(suggetions);
		for (WebElement sugwebElement : suggetions) {
			if (sugwebElement.getText().equalsIgnoreCase("iPhone 14 pro")) {
				System.out.println(sugwebElement.getText());
			}
		}
	}
}
