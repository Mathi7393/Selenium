package com.crm.vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility1 {

	public int getRandom() {
		Random r = new Random();
		int random = r.nextInt(10000);
		return random;
	}

	public String getSysDate() {
		Date d=new Date();
		String Date=d.toString();
		return Date;
	}
	/**
	 * This Method is used to get System date and modifying according to our requirement
	 * because we will going to store the screenshots with system date and time but it is containing ":" 
	 * which will not accept for file name
	 * @return
	 */
	public String getModifiedDate() {
		Date d=new Date();
		String[] date = d.toString().split(" ");
		String date1 = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":", "-");
		String CurrentDate=date1+" "+month+" "+year+" "+time;
		return CurrentDate;
	}
}
