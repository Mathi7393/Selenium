package com.crm.vtiger.practice;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.vtiger.GenericUtility.WebDriverUtility;

public class PracticeForRobotlassFaceBook2 {

	public static void main(String[] args) throws AWTException, Throwable {

		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);

		driver.get("https://www.facebook.com/signup");
		/*
		 * Actions action=new Actions(driver); action.moveByOffset(910, 433).perform();
		 */

		Robot q = new Robot();
//		Actions actions = new Actions(driver);
		driver.findElement(By.id("day")).click();
		driver.findElement(By.xpath("//option[text()='1']")).click();
		driver.findElement(By.id("day")).click();
//		driver.findElement(By.xpath("//select[@title='Day']")).click();
		Thread.sleep(5000);
//		WebElement day = driver.findElement(By.xpath("//select[@title='Day']/child::option[@value='1']"));
//		System.out.println(day.getText());
//		actions.moveToElement(day).click().perform();

//		System.out.println(day.getText());
		for (int i = 1; i < 5; i++)

		{
//			actions.moveToElement(driver.findElement(By.xpath("//select[@title='Day']/child::option[@value='1']")));

			q.keyPress(KeyEvent.VK_DOWN);
			q.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(3000);

		}
		q.keyPress(KeyEvent.VK_ENTER);
		q.keyRelease(KeyEvent.VK_ENTER);

//		driver.findElement(By.xpath("//select[@title='Month']")).click();
//		Robot p=new Robot();
//		for(int i=1;i<=4;i++)
//		{
//			p.keyPress(KeyEvent.VK_DOWN);
//			p.keyRelease(KeyEvent.VK_DOWN);
//		}
//		
//		p.keyPress(KeyEvent.VK_ENTER);
//		p.keyRelease(KeyEvent.VK_ENTER);
//		
//		driver.findElement(By.id("year")).click();
//		Robot q=new Robot();
//		for(int i=1;i<=23;i++)
//		{
//			q.keyPress(KeyEvent.VK_DOWN);
//			q.keyRelease(KeyEvent.VK_DOWN);
//		}
//		q.keyPress(KeyEvent.VK_ENTER);
//		q.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		driver.quit();

	}

}
