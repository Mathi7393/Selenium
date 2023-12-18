package com.crm.vtiger.organisation;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtility.BaseClass;
import com.crm.vtiger.ObjectRepositary.CreateOrganizationPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.OrganizationsPage;
import com.crm.vtiger.ObjectRepositary.organisationInfoPage;

@Listeners(com.crm.vtiger.GenericUtility.ListnerImplementation.class)
public class CrateOrganisationTestByUsingTestNG extends BaseClass{
	@Test(retryAnalyzer = com.crm.vtiger.GenericUtility.RetryAnalyser.class)
	public void verifyuserCreateOrganisation() throws Throwable {
		
		String com = eutil.getExcelFileData("Data", 1, 0) + jutil.getRandom();
		
		HomePage hp = new HomePage(driver);

		hp.clickOrgLink();
		Reporter.log("Organisation Link Clicked",true);
		OrganizationsPage orgp = new OrganizationsPage(driver);// click on + image
		orgp.clickAddOrg();
		Reporter.log("add Organisation Link Clicked",true);
//		Assert.fail();
		CreateOrganizationPage crOrgP = new CreateOrganizationPage(driver);
		crOrgP.addOrg(com);
		Reporter.log("Organisation added",true);
		organisationInfoPage orgInfoP = new organisationInfoPage(driver);
		String comname = orgInfoP.getCreatedOrgName();
		
		Assert.assertTrue(comname.contains(com));//Contains Level Comparision
//		Assert.assertEquals(comname,com);//Strict Level Comparision
		System.out.println("Pass");
	}

}
