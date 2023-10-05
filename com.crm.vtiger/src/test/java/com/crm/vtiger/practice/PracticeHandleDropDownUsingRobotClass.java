package com.crm.vtiger.practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.vtiger.GenericUtility.ExcelFileUtility;
import com.crm.vtiger.GenericUtility.PropertyFileUtility;
import com.crm.vtiger.GenericUtility.WebDriverUtility;

public class PracticeHandleDropDownUsingRobotClass {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		PropertyFileUtility putil = new PropertyFileUtility();
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		String URL = putil.getPropertyFileData("URL");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//a[.='Organizations']/ancestor::table[2]/tbody/tr//tr/td[6]/a")).click();//By table values
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("testyanra19931");
		driver.findElement(By.xpath("//select[@name='industry']")).click();
		Robot r=new Robot();
		for (int i = 0; i < 14; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String comname = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		if (comname.contains("testyanra1993")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		WebElement logout = driver.findElement(By.xpath(".//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}
