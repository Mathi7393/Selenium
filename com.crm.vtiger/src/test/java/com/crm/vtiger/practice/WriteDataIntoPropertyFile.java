package com.crm.vtiger.practice;

import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataIntoPropertyFile {

	public static void main(String[] args) throws Throwable {
		Properties p=new Properties();
		p.setProperty("Browser", "Chrome");
		p.setProperty("URL", "http://localhost:8888/");
		p.setProperty("username", "admin");
		p.setProperty("password", "password");
		FileOutputStream fo=new FileOutputStream("./src/test/resources/CommonData.properties");
		p.store(fo, "PropertyFileData");
		System.out.println("Data Added Sucessfully");
	}

}
