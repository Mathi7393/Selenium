package com.crm.vtiger.practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.crm.vtiger.GenericUtility.WebDriverUtility;

public class HandleMicTestPopUP {

	public static void main(String[] args) {
		ChromeOptions settinngs = new ChromeOptions();
//		settinngs.addArguments("--disable-notifications");
//		settinngs.addArguments("--incognito ");
//This is Media stream popup
		settinngs.addArguments("use-fake-device-for-media-stream");
		settinngs.addArguments("use-fake-ui-for-media-stream");
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		driver.get("https://mictests.com/");
		String currentID = driver.getWindowHandle();
		driver.findElement(By.linkText("Test Webcam")).click();
		Set<String> ids = driver.getWindowHandles();
		
		for (String id : ids) {
			if (!(id.equals(currentID))) {
				driver.switchTo().window(id);
			}
		}
		driver.findElement(By.id("webcam-launcher")).click();
		
		

	}

}
