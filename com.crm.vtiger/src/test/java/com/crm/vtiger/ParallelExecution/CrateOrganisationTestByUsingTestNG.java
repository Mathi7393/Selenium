package com.crm.vtiger.ParallelExecution;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtility.BaseClassForParallelExecution;
import com.crm.vtiger.ObjectRepositary.CreateOrganizationPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.OrganizationsPage;
import com.crm.vtiger.ObjectRepositary.organisationInfoPage;
@Listeners(com.crm.vtiger.GenericUtility.ListnerImplementation.class)

public class CrateOrganisationTestByUsingTestNG extends BaseClassForParallelExecution{
	@Test
	public void verifyuserCreateOrganisation() throws Throwable {
		
		String com = eutil.getExcelFileData("Data", 1, 0) + jutil.getRandom();
		
		HomePage hp = new HomePage(driver);
		hp.clickOrgLink();
		
		OrganizationsPage orgp = new OrganizationsPage(driver);// click on + image
		orgp.clickAddOrg();
		
		CreateOrganizationPage crOrgP = new CreateOrganizationPage(driver);
		crOrgP.addOrg(com);
		
		organisationInfoPage orgInfoP = new organisationInfoPage(driver);
		String comname = orgInfoP.getCreatedOrgName();
		
		Assert.assertTrue(comname.contains(com));//Contains Level Comparision
//		Assert.assertEquals(comname,com);//Strict Level Comparision
		System.out.println("Pass");
	}

}
