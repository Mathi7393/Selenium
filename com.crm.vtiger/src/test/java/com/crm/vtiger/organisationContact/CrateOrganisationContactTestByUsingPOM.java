package com.crm.vtiger.organisationContact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.vtiger.GenericUtility.JavaUtility;
import com.crm.vtiger.GenericUtility.PropertyFileUtility;
import com.crm.vtiger.ObjectRepositary.ContactsPage;
import com.crm.vtiger.ObjectRepositary.CreateNewContactPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.LoginPage;

public class CrateOrganisationContactTestByUsingPOM {

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
		
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
		
		HomePage hp= new HomePage(driver);
		hp.clickContact();
		ContactsPage conp=new ContactsPage(driver);
		conp.clickAddContact();
		CreateNewContactPage creConP=new CreateNewContactPage(driver);
		creConP.addContact(lastName);
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
