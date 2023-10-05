package com.crm.vtiger.practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String Browser=p.getProperty("Browser");
		String URL=p.getProperty("URL");
		String Username=p.getProperty("username");
		String Password=p.getProperty("password");
		
		System.out.println(Browser+"\n"+URL+"\n"+Username+"\n"+Password);

	}

}
