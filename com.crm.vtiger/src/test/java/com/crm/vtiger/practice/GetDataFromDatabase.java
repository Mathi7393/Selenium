package com.crm.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetDataFromDatabase {
	public static void main(String[] args) throws Throwable {
		//load MySql Driver
		Driver driver=new Driver();
		
		//Register the driver
		DriverManager.registerDriver(driver);
		
		//get the connection to MySQL DB
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceseleniumdb","root","Password@123");
		
		//create statement
		Statement state = con.createStatement();
		
		ResultSet data = state.executeQuery("select * from advsel;");
		
		while (data.next()) {
			String values = data.getInt(1)+" "+data.getString(2)+" "+data.getString(3);
			System.out.println(values);
		}
	}
	
	
	
}
