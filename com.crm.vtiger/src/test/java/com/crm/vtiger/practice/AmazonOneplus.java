package com.crm.vtiger.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonOneplus {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.in/");
		ArrayList<String> HL = new ArrayList<String>();
//		ArrayList<String> BL = new ArrayList<String>();
		List<WebElement> Headers = driver
				.findElements(By.xpath("//div[@id='nav-xshop-container']/descendant::a[@class='nav-a  ']"));
		for (WebElement webElement1 : Headers) {
			HL.add(webElement1.getText());
		}
		System.out.println(HL);
		for (WebElement webElement1 : Headers) {
			if (webElement1.getText().equals("Mobiles")) {
				webElement1.click();
				// Thread.sleep(2000);
				break;
			}
		}
//		for(;;) {
//		try {
			driver.findElement(By.xpath("//span[.='OnePlus' and  @class='a-size-base a-color-base']")).click();
//			break;
//		} catch (StaleElementReferenceException e) {
//			e.printStackTrace();
//		}
//		}

		// driver.findElement(By.xpath("(//i[@class='a-icon
		// a-icon-checkbox'])[position()=4]")).click();

////		List<WebElement> brandOptions = driver.findElements(By.xpath(
////				"//span[.='Brands']/ancestor::div[@class='a-section a-spacing-none']/descendant::li[@class='a-spacing-micro']"));
////		for (WebElement webElement2 : brandOptions) {
////			BL.add(webElement2.getText());
////		}
//		System.out.println(BL);
//		for (WebElement webElement2 : brandOptions) {
//			if (webElement2.getText().equals("OnePlus")) {
//				webElement2.click();
//				break;
//			}
//		}
		List<WebElement> products = driver.findElements(By.xpath("//span[.='4.2 out of 5 stars']/ancestor::div[@class='a-section a-spacing-none a-spacing-top-micro']/preceding-sibling::div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']/descendant::span[contains(text(),'OnePlus Nord')]"));
		for (WebElement webElement3 : products) {
			System.out.println(webElement3.getText());
		}
	}
}
