package com.crm.vtiger.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisplayLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.in/");
		List<WebElement> allLink = driver.findElements(By.xpath("//a"));
		for (int i = 0; i < allLink.size(); i++) {
			String links=allLink.get(i).getAttribute("href");
			System.out.println(links);
		}
	}

}
