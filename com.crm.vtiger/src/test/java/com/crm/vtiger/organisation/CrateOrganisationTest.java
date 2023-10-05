package com.crm.vtiger.organisation;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CrateOrganisationTest {
///hhhhh
	public static void main(String[] args) {
		Random r=new Random();
		int random=r.nextInt(10000);
		String com="Sustine"+random;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(com);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String comname = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		if (comname.contains(com)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("fail");
		}
		WebElement logout = driver.findElement(By.xpath(".//img[@src='themes/softed/images/user.PNG']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}
