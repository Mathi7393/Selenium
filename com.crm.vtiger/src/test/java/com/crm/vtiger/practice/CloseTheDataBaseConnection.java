package com.crm.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CloseTheDataBaseConnection {

	public static void main(String[] args) throws Throwable {
		Connection con = null;
//		ResultSet data1=null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceseleniumdb", "root", "Password@123");
			Statement state = con.createStatement();

//			data1 = state.executeQuery("select * from advsel;");
			ResultSet data1 = state.executeQuery("select * from advsel;");

			while (data1.next()) {
				String values = data1.getInt(1) + " " + data1.getString(2) + " " + data1.getString(3);
				System.out.println(values);
			}
		} finally {
			con.close();
			System.out.println("connection closed");
//			String values = data1.getInt(1) + " " + data1.getString(2) + " " + data1.getString(3);
//			System.out.println(values);
		}

	}

}
