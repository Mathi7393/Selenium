package com.crm.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
//		Sheet sh=wb.createSheet("Data2");
//		Row row=sh.createRow(0);
//		Cell cell = row.createCell(0);
//		cell.setCellValue("username");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
//		wb.createSheet("data2").createRow(0).createCell(0).setCellValue("username");
		wb.getSheet("data2").createRow(0).createCell(1).setCellValue("Password");
		wb.write(fos);
		
		System.out.println("DataAdded");
	}

}
