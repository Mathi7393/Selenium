package com.crm.vtiger.organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.vtiger.GenericUtility.ExcelFileUtility;
import com.crm.vtiger.GenericUtility.JavaUtility;
import com.crm.vtiger.GenericUtility.PropertyFileUtility;
import com.crm.vtiger.GenericUtility.WebDriverUtility;
import com.crm.vtiger.ObjectRepositary.CreateOrganizationPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.LoginPage;
import com.crm.vtiger.ObjectRepositary.OrganizationsPage;
import com.crm.vtiger.ObjectRepositary.organisationInfoPage;

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
//		eutil.writeDataIntoExcel("Data", 1, 0, "testyantra");
		String com = eutil.getExcelFileData("Data", 1, 0) + JU.getRandom();
//		Abstraction
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PW);
		HomePage hp = new HomePage(driver);
		hp.clickOrgLink();
		OrganizationsPage orgp= new OrganizationsPage(driver);//click on + image
		orgp.clickAddOrg();
		CreateOrganizationPage crOrgP= new CreateOrganizationPage(driver);
		crOrgP.addOrg(com);
		organisationInfoPage orgInfoP=new organisationInfoPage(driver);
		String comname=orgInfoP.getCreatedOrgName();
	
		if (comname.contains(com)) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}
		hp.logout(driver);
		driver.quit();
	}

}
