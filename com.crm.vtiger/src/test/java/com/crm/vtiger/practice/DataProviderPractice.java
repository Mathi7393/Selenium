package com.crm.vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
//	@DataProvider
	@DataProvider(name="dt")
	public Object[][] data() {
		Object data[][]=new Object[2][2];
		data[0][0]="Samsung";
		data[0][1]=15000;
		
		data[1][0]="Nokia";
		data[1][1]=20000;
		
		return data;
	}
	
//	@Test(dataProvider = "data")
	@Test(dataProvider = "dt")
	public void create(String mobilename,int price) {
		System.out.println(mobilename+" "+price);
	}
}
