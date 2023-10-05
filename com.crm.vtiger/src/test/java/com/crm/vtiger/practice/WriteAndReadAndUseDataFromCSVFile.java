package com.crm.vtiger.practice;

import java.io.FileReader;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class WriteAndReadAndUseDataFromCSVFile {
	static String userName;
	static String password;
	public static void main(String[] args) throws Throwable {
		FileWriter fw=new FileWriter("./src/test/resources/selenium.csv");
		CSVWriter csvw=new CSVWriter(fw);
		String input[]= {"admin","password"};
		csvw.writeNext(input);
		csvw.flush();
		
		FileReader fr=new FileReader("./src/test/resources/selenium.csv");
		CSVReader csvr=new CSVReader(fr);
		String data[];
		try {
			while ((data = csvr.readNext()) != null) {
				userName = data[0];
				password = data[1];
//				System.out.println(userName + "\n" + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

	}

}
