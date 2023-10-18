package com.crm.vtiger.organisationContact;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtility.BaseClass;
import com.crm.vtiger.ObjectRepositary.ContactsInfoPage;
import com.crm.vtiger.ObjectRepositary.ContactsPage;
import com.crm.vtiger.ObjectRepositary.CreateNewContactPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
@Listeners(com.crm.vtiger.GenericUtility.ListnerImplementation.class)
public class CrateOrganisationContactUsingTestNG extends BaseClass {

	@Test
	public void verifyUserCreateConact() throws Throwable {
		String lastName = eutil.getExcelFileData("Data", 2, 0) + jutil.getRandom();

		HomePage hp = new HomePage(driver);
		hp.clickContact();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickAddContact();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.addContact(lastName);
		
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String createdContHeader = cip.getContHeaderName();
				
		Assert.assertTrue(createdContHeader.contains(lastName));
		System.out.println("Pass");

	}
}
