package com.crm.vtiger.ParallelExecution;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtility.BaseClassForParallelExecution;
import com.crm.vtiger.GenericUtility.ExcelFileUtility;
import com.crm.vtiger.ObjectRepositary.ContactsInfoPage;
import com.crm.vtiger.ObjectRepositary.ContactsPage;
import com.crm.vtiger.ObjectRepositary.CreateNewContactPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
@Listeners(com.crm.vtiger.GenericUtility.ListnerImplementation.class)
public class CrateOMultipleContactUsingTest extends BaseClassForParallelExecution {

	@Test(dataProvider = "getMultipleRowData",dataProviderClass = ExcelFileUtility.class)
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
