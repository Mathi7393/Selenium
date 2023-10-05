package com.crm.vtiger.organisationContact;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.vtiger.GenericUtility.JavaUtility;
import com.crm.vtiger.GenericUtility.PropertyFileUtility;

public class CrateOrganisationContactTestByUsingUtilityFile {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		PropertyFileUtility putil=new PropertyFileUtility();
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		String URL = putil.getPropertyFileData("URL");		
		JavaUtility JU=new JavaUtility();
		String lastName = "Kundu" + JU.getRandom();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String LName = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		if (LName.contains(lastName)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		WebElement logout = driver.findElement(By.xpath(".//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
