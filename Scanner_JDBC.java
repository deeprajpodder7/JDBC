package com.student;

import java.util.*;
import java.sql.*;

public class Scanner_JDBC {
		public static void main(String[] args) {
			Scanner sc= new Scanner (System.in);
			System.out.println("enter sId ");
			int s_id=sc.nextInt();
			System.out.println("enter sName: ");
			String s_name=sc.next();
			System.out.println("enter sAge: ");
			int s_age=sc.nextInt();
			System.out.println("enter sCity: ");
			String s_city=sc.next();
			System.out.println("enter sPhone: ");
			long s_phone=sc.nextLong();
			try {
				
				Class.forName("com.mysql.jdbc.Driver"); //1.Registering Driver
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepdb","root","root"); //2.Creating Connection
				PreparedStatement stmt = con.prepareStatement("insert into Studentmanage values(?, ?, ?,?,?)");	//creating statement
				  stmt.setInt(1, s_id);
		            stmt.setString(2, s_name);
		            stmt.setInt(3, s_age);
		            stmt.setString(4,s_city);
		            stmt.setLong(5,s_phone); } 
			catch(Exception e) {
		            	System.out.println(e);
		            }


	}

}
