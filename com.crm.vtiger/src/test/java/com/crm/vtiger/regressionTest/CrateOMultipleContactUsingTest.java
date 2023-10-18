package com.crm.vtiger.regressionTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtility.BaseClass2;
import com.crm.vtiger.GenericUtility.ExcelFileUtility;
import com.crm.vtiger.ObjectRepositary.ContactsInfoPage;
import com.crm.vtiger.ObjectRepositary.ContactsPage;
import com.crm.vtiger.ObjectRepositary.CreateNewContactPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
@Listeners(com.crm.vtiger.GenericUtility.ListnerImplementation.class)
public class CrateOMultipleContactUsingTest extends BaseClass2 {

	@Test(dataProvider = "getMultipleRowData",dataProviderClass = ExcelFileUtility.class, groups = {"smoke","Regression"})
	public void verifyUserCreateConact(String Lname) throws Throwable {
		String lastName = Lname+jutil.getRandom();;

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
