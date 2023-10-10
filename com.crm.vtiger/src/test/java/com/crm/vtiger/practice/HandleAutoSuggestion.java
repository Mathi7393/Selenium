package com.crm.vtiger.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.vtiger.GenericUtility.WebDriverUtility;

public class HandleAutoSuggestion {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("samsung s24");
		wutil.visibleElement(driver, driver.findElement(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']")));
		List<WebElement> suge = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']/descendant::a[@class='oleBil']"));
		for (WebElement webElement : suge) {
			System.out.println(webElement.getText());
			if (webElement.getText().equals("samsung s24")) {
				webElement.click();
				break;
			}
			
		}

	}

}
