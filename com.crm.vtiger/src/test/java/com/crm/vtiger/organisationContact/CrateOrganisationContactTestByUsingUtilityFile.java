package com.crm.vtiger.organisationContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.vtiger.GenericUtility.ExcelFileUtility;
import com.crm.vtiger.GenericUtility.JavaUtility;
import com.crm.vtiger.GenericUtility.PropertyFileUtility;
import com.crm.vtiger.GenericUtility.WebDriverUtility;

public class CrateOrganisationContactTestByUsingUtilityFile {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		WebDriverUtility wutil = new WebDriverUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		String URL = putil.getPropertyFileData("URL");		
		String Browser = putil.getPropertyFileData("Browser");
		JavaUtility JU=new JavaUtility();
		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		eutil.writeDataIntoExcel("Data", 0, 2, "mathi");
		String lastName = eutil.getExcelFileData("Data", 0, 2) + JU.getRandom();
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
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
