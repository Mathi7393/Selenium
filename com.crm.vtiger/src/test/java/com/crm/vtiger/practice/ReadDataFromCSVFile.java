package com.crm.vtiger.practice;

import java.io.FileReader;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

public class ReadDataFromCSVFile {
	static String userName;
	static String password;

	public static void main(String[] args) throws Throwable {

		// To Read the Data into any file
		FileReader fr = new FileReader("./src/test/resources/selenium.csv");

		// To write the Data into CSV file
		CSVReader csvr = new CSVReader(fr);

		String cell[];
		try {
			while ((cell = csvr.readNext()) != null) {
				userName = cell[0];
				password = cell[1];
//				System.out.println(userName + "\n" + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
		
	}

}
