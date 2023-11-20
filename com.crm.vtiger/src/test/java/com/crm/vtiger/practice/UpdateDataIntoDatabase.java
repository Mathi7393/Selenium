package com.crm.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataIntoDatabase {

	public static void main(String[] args) throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceseleniumdb", "root",
				"Password@123");
		Statement state = con.createStatement();
		
		int data = state.executeUpdate("insert into advsel values(5,'Deepa','typ5');");

		if (data>=1) {
			System.out.println("DATA ADDED");
		}
		
		ResultSet data1 = state.executeQuery("select * from advsel;");

		while (data1.next()) {
			String values = data1.getInt(1) + " " + data1.getString(2) + " " + data1.getString(3);
			System.out.println(values);
		}

	}
}