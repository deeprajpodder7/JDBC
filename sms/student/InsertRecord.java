package com.sms.student;

import java.sql.*;
import java.util.Scanner;

import com.sms.Helper;




public class InsertRecord {
	Scanner sc=new Scanner(System.in);
	int s_id,s_age,e_phone;
	String s_name,s_city;
	
	public void insertRecord()throws Exception{
		System.out.println("Enter student id: ");
		s_id=sc.nextInt();
		System.out.println("Enter student name: ");
		s_name=sc.next();
		System.out.println("Enter student age: ");
		s_age=sc.nextInt();
		System.out.println("Enter student city: ");
		s_city=sc.next();
		
		
		Connection con=Helper.con();
		PreparedStatement stmt=con.prepareStatement("insert into StudentManage values(?,?,?,?)");
		stmt.setInt(1, s_id);
		stmt.setString(2, s_name);
		stmt.setInt(3, s_age);
		stmt.setString(4, s_city);
		stmt.executeUpdate();
	  }
}
