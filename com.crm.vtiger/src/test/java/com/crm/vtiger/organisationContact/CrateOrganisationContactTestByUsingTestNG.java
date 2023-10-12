package com.crm.vtiger.organisationContact;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtility.BaseClass;
import com.crm.vtiger.ObjectRepositary.ContactsPage;
import com.crm.vtiger.ObjectRepositary.CreateNewContactPage;
import com.crm.vtiger.ObjectRepositary.HomePage;

public class CrateOrganisationContactTestByUsingTestNG extends BaseClass{
	@Test
	public void verifyuserCreateContact(String[] args) throws Throwable {
		String lastName = eutil.getExcelFileData("Data", 1, 0) + jutil.getRandom();
		
		HomePage hp= new HomePage(driver);
		hp.clickContact();
		
		ContactsPage conp=new ContactsPage(driver);
		conp.clickAddContact();
		
		CreateNewContactPage creConP=new CreateNewContactPage(driver);
		creConP.addContact(lastName);
		
		String LName = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		
		
	}
}
