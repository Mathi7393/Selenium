package com.crm.vtiger.practice;

import org.testng.annotations.Test;

public class GetDataFromAnotherClass {
	@Test(dataProvider = "data", dataProviderClass = DataProviderPractice.class)
	public void getData(String mobileName, int price, String ratings) {
		System.out.println(mobileName+" "+price+" "+ratings);
	}

}
