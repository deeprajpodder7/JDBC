package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_JDBC {
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); //1.Registering Driver
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepdb","root","root"); //2.Creating Connection
			Statement stmt=con.createStatement(); //3. Creating Statement
			stmt.executeUpdate("update Student set sCity='Halisahar' where sName='Tatha'");  //updating existing record in the table
			stmt.executeUpdate("delete from Student where sId='2'");
			ResultSet rs= stmt.executeQuery("select * from Student");
			while(rs.next()) {
			System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " +rs.getInt(3) + " " + rs.getString(4) + " " +rs.getLong(5));	
			}
			con.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
			}
}
