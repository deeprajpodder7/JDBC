package com.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BMS_Helper {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //loading the driver class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public static Connection con() throws SQLException{ //created  a method con() which returns connection to the Database
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/deepdb","root","root");
	}
	}
