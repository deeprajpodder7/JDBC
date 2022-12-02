package com.sms.update;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.sms.Helper;

public class UpdateRecord {
	public void updateRecord() throws Exception{
		Scanner sc=new Scanner(System.in);
		Connection con=Helper.con();
		Statement stmt=con.createStatement(); // Creating Statement
		System.out.println("Enter student id whose city you want to change: ");
		int s_id=sc.nextInt();
		System.out.println("Enter student	 city: ");
		String s_city=sc.nextLine();
		stmt.executeUpdate("update from Menudriver set e_city=' "+s_city+" 'where e_id=" +s_id);
		
	}
}
