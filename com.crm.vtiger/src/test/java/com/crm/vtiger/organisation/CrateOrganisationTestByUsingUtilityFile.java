package com.crm.vtiger.organisation;

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
import com.crm.vtiger.ObjectRepositary.LoginPage;

public class CrateOrganisationTestByUsingUtilityFile {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		WebDriverUtility wutil = new WebDriverUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		String URL = putil.getPropertyFileData("URL");
		String Browser = putil.getPropertyFileData("Browser");
		JavaUtility JU = new JavaUtility();
//		Runtime Polymorphism or Method overriding
		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		eutil.writeDataIntoExcel("Data", 1, 0, "Sustine");

		String com = eutil.getExcelFileData("Data", 1, 0) + JU.getRandom();

//		Abstraction
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(com);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String comname = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		if (comname.contains(com)) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		WebElement logout = driver.findElement(By.xpath(".//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
//		driver.getTitle()
		driver.quit();
	}

}
