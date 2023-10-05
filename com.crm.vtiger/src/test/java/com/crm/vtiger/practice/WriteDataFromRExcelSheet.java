package com.crm.vtiger.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromRExcelSheet {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Data");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
//		String data = WorkbookFactory.create(fis).getSheet("Data").getRow(0).getCell(0).getStringCellValue();
		System.out.println(data);
//		String data1 = WorkbookFactory.create(fis).getSheet("Data").getRow(0).getCell(1).getStringCellValue();
//		System.out.println(data1);//IllegalStateException because of data type mismatch
//		
//		String data1 = WorkbookFactory.create(fis).getSheet("Data").getRow(0).getCell(1).toString();
//		System.out.println(data1);
		
		DataFormatter df=new DataFormatter();
		String data2 = df.formatCellValue(cell);
		System.out.println(data2);
	}

}
