package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_JDBC {
	public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver"); //1.Registering Driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepdb","root","root"); //2.Creating Connection
		Statement stmt=con.createStatement(); //3. Creating Statement
		stmt.executeUpdate("insert into Student  values (1,'Deep',18,'Kanchrapara','9123721390')"); //4. Inserting Data into Table oF the Database
		stmt.executeUpdate("insert into Student  values (2,'Raj',19,'Kanchrapara','9123721390')");
		stmt.executeUpdate("insert into Student  values (3,'Abhi',16,'Kanchrapara','9123721390')");
		stmt.executeUpdate("insert into Student  values (4,'Tatha',17,'Kanchrapara','9123721390')");
		System.out.println("Inserted Succesfully!!");
		con.close(); //5. Closing Connection
	} catch (Exception e) {
		e.printStackTrace();
	} 
}
}