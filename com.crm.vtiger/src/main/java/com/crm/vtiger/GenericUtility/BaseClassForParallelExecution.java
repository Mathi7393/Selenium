package com.crm.vtiger.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.LoginPage;

public class BaseClassForParallelExecution {
	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver;

	@BeforeSuite
	public void bs_config() {
		System.out.println("Database Connection establised Sucessfully");
	}

	@BeforeTest
	public void bc_config() throws Throwable {
		String Browser = putil.getPropertyFileData("Browser");
//		String Browser = System.getProperty("Browser");
		String URL = putil.getPropertyFileData("URL");
//		Runtime Polymorphism or Method overriding
		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		driver.get(URL);
	}

	@BeforeMethod
	public void bm_config() throws Throwable {
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
	}
	
	@AfterMethod
	public void am_config() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	
	@AfterTest
	public void ac_config() {
		driver.quit();
	}
	
	@AfterSuite
	public void as_config() {
		System.out.println("Database Connection disattached Sucessfully");
	}
}