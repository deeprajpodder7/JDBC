package com.banking.bms;

import java.sql.*;
import java.util.Scanner;

import com.banking.BMS_Helper;

public class PinChange {
	int db_acc, db_pin;
	Scanner sc=new Scanner(System.in);
	public void PinChange(int acc_no,int pin)throws SQLException{
	Connection conn = BMS_Helper.con();
	Statement stmt = conn.createStatement(); //createStatement() method of Connection interface is used to create statement and store inside the object of Statement interface 
	System.out.println("Enter New Pin: ");
	int newPin=sc.nextInt();
	ResultSet rs = stmt.executeQuery("select * from bank where acc_no="+acc_no);  //executeQuery() method of Statement interface is used to execute queries to the database, inside object of ResultSet interface 
	while(rs.next()) { //getting the column of each record in the table
		db_acc=rs.getInt(1);
		db_pin=rs.getInt(7);
	}
	if(db_acc!=acc_no) {
		System.err.println("!!WRONG ACCOUNT NUMBER INSERTED!!");
	}
	if(db_pin!=pin) {
		System.err.println("!!WRONG PIN INSERTED!!");
	}
	else {
		stmt.executeUpdate("update bank set pin = "+newPin+" where acc_no="+acc_no);
		
	}
	}
}
