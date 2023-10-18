package com.crm.vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@DataProvider
//	@DataProvider(name="dt")
	public Object[][] data() {
		Object data[][]=new Object[3][3];
		data[0][0]="Samsung";
		data[0][1]=15000;
		data[0][2]="4 star";
		
		data[1][0]="Nokia";
		data[1][1]=20000;
		data[1][2]="5 star";
		
		data[2][0]="RedMi";
		data[2][1]=15000;
		data[2][2]="5 star";
		
		return data;
	}
	
	@Test(dataProvider = "data")
//	@Test(dataProvider = "dt")
	public void create(String mobilename,int price, String ratings) {
		System.out.println(mobilename+" "+price+" "+ratings);
	}
}
