package com.crm.vtiger.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.vtiger.GenericUtility.WebDriverUtility;

public class PracticeRobotClassGoogle {

	public static void main(String[] args) throws AWTException {
		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		driver.get("https://www.google.com/");
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
		Robot r = new Robot();
		for (int i = 0; i <10 ; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
