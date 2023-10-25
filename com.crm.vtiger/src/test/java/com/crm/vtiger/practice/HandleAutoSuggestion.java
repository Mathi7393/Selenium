package com.crm.vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.ObjectRepositary.flipkartAutoSuggetionPage;

public class HandleAutoSuggestion {

//	public static void main(String[] args) {
//		WebDriver driver=new ChromeDriver();
//		WebDriverUtility wutil=new WebDriverUtility();
//		wutil.maximizeWebPage(driver);
//		wutil.implicitWait(driver);
//		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.xpath("//span[text()='✕']")).click();
//		driver.findElement(By.name("q")).sendKeys("samsung s24");
////		wutil.visibleElement(driver, driver.findElement(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']")));
//		List<WebElement> suge = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']/descendant::a[@class='oleBil']"));
//		for (WebElement webElement : suge) {
//			System.out.println(webElement.getText());
//			if (webElement.getText().equals("samsung s24")) {
//				webElement.click();
//				break;
//			}
//			
//		}
//
//	}

//	public static void main(String[] args) {
	@Test
	public void clickAutoSugest() {
		
		WebDriver driver = new ChromeDriver();
		flipkartAutoSuggetionPage fa=new flipkartAutoSuggetionPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("iPhone 14 pro");
		
//		List<WebElement> suggetions = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/descendant::div[@class='s-suggestion-container']"));
//		System.out.println(suggetions);
//		for (WebElement sugwebElement : suggetions) {
//			if (sugwebElement.getText().equalsIgnoreCase("iPhone 14 pro")) {
//				System.out.println(sugwebElement.getText());
//			}
//		}
		fa.clickonauto();
		driver.quit();

	}

}
