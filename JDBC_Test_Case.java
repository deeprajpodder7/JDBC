package com.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class JDBC_Test_Case {
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); //1.Registering Driver
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepdb","root","root"); //2.Creating Connection
			Statement stmt=con.createStatement(); //3. Creating Statement
			ResultSet rs= stmt.executeQuery("select * from Student");
			while(rs.next()) {
			System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " +rs.getInt(3) + " " + rs.getString(4) + " " +rs.getLong(5));	
			}
			con.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		}}
