package com.crm.vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic method to fetch data from Excel File
 * 
 * @author mathi
 * @mathi
 */
public class ExcelFileUtility {
	/**
	 * This method help us to fetch data from Excel file
	 * 
	 * @param key
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetname, int rownumber, int cellNumber, String Value) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstant.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rownumber).createCell(cellNumber).setCellValue(Value);
		FileOutputStream fos=new FileOutputStream(IpathConstant.excelFilePath);
		wb.write(fos);
	}
	public String getExcelFileData(String sheetname, int rownumber, int cellNumber) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstant.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).createRow(rownumber).createCell(cellNumber).getStringCellValue();
		return value;
	}
}
