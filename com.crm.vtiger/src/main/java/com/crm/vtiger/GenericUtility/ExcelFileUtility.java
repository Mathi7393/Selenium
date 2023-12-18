package com.crm.vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

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
		FileInputStream fis = new FileInputStream(IpathConstant1.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rownumber).createCell(cellNumber).setCellValue(Value);
		FileOutputStream fos=new FileOutputStream(IpathConstant1.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	public String getExcelFileData(String sheetname, int rownumber, int cellNumber) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstant1.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rownumber).getCell(cellNumber).getStringCellValue();
		return value;
	}
	
	@DataProvider
	public Object[][] getMultipleRowData() throws Throwable{
		FileInputStream fis = new FileInputStream(IpathConstant1.excelFilePath);
		Sheet sh = WorkbookFactory.create(fis).getSheet("DataProvider");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object data[][]=new Object[lastrow][lastcell];
		DataFormatter df=new DataFormatter();
		for (int i = 0; i < lastrow; i++) {
			for (int j = 0; j < lastcell; j++) {
				data[i][j]=df.formatCellValue(sh.getRow(i).getCell(j));
			}
			
		}
		return data;
	}
}
