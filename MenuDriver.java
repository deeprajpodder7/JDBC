package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDriver {
Scanner sc=new Scanner(System.in);
int e_id,e_age,e_salary;
String e_name,e_city;
//saving employee details
public void saveMenuDriver()throws Exception{
	System.out.println("Enter employee id: ");
	e_id=sc.nextInt();
	System.out.println("Enter employee name: ");
	e_name=sc.next();
	System.out.println("Enter employee age: ");
	e_age=sc.nextInt();
	System.out.println("Enter employee city: ");
	e_city=sc.next();
	System.out.println("Enter employee salary: ");
	e_salary=sc.nextInt();
	
	Connection con=Helper.con();
	PreparedStatement stmt=con.prepareStatement("insert into MenuDriver values(?,?,?,?,?)");
	stmt.setInt(1, e_id);
	stmt.setString(2, e_name);
	stmt.setInt(3, e_age);
	stmt.setString(4, e_city);
	stmt.setInt(5, e_salary);
	stmt.executeUpdate();
  }

//fetching employee details in the database
public void fetchMenuDriver() throws Exception{
	Connection con=Helper.con();
	Statement stmt=con.createStatement(); //3. Creating Statement
	ResultSet rs= stmt.executeQuery("select * from MenuDriver");
	while(rs.next()) {
	System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " +rs.getInt(3) + " " + rs.getString(4) + " " +rs.getInt(5)); }
}
//updating employee details in database
public void updateMenuDriver() throws Exception{
	Connection con=Helper.con();
	Statement stmt=con.createStatement(); //3. Creating Statement
	System.out.println("Enter employee city: ");
	e_city=sc.nextLine();
	stmt.executeUpdate("update from Menudriver set e_city=' "+e_city+" 'where e_id=" +e_id);
	
}

//deleting employee details
public void deleteMenuDriver() throws Exception{
	Connection con=Helper.con();
	Statement stmt=con.createStatement(); //3. Creating Statement
	System.out.println("Enter employee id: ");
	e_id=sc.nextInt();
	stmt.executeUpdate("delete from Menudriver where e_id="+e_id);
}
}


