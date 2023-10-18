package com.crm.vtiger.organisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtility.BaseClass;
import com.crm.vtiger.GenericUtility.ExcelFileUtility;
import com.crm.vtiger.ObjectRepositary.CreateOrganizationPage;
import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.OrganizationsPage;
import com.crm.vtiger.ObjectRepositary.organisationInfoPage;

public class CrateMultipleOrgTest extends BaseClass{
	@Test(dataProvider = "getMultipleRowData",dataProviderClass = ExcelFileUtility.class)
	public void verifyUserCreateMultipleOrganisationTest(String OrganizationName) {
		String orgName=OrganizationName+jutil.getRandom();
		HomePage hp=new HomePage(driver);
		hp.clickOrgLink();
		OrganizationsPage orgp=new OrganizationsPage(driver);
		orgp.clickAddOrg();
		CreateOrganizationPage corgp=new CreateOrganizationPage(driver);
		corgp.addOrg(orgName);
		organisationInfoPage orginfop=new organisationInfoPage(driver);
		String orgHeadreName = orginfop.getCreatedOrgName();
		orginfop.getCreatedOrgName();
		Assert.assertTrue(orgHeadreName.contains(orgName));
		System.out.println("pass");
	}
	
	@Test
	public void regional() {
		System.out.println("regional");
	}
	
}
