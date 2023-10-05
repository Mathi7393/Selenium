package com.crm.vtiger.practice;

import java.io.FileWriter;

import com.opencsv.CSVWriter;

public class WriteDataIntoCSVFile {

	public static void main(String[] args) throws Throwable {
		// To write the Data into any file
		FileWriter fr = new FileWriter("./src/test/resources/selenium.csv");
		
		// To write the Data into CSV file
		CSVWriter csvw = new CSVWriter(fr);
		
		String dt[]=new String[2];
		dt[0]="admin";//application user name
		dt[1]="password";//application password
		
		csvw.writeNext(dt);
		
		csvw.flush();
		System.out.println("dataAdded");
	}

}
