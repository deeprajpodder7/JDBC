package com.banking.bms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.banking.BMS_Helper;


public class DepBal{
	int db_pin;
	int db_acc;
	double pbal;
	Scanner sc = new Scanner(System.in);
	public void DepositBalance(int acc_no,int pin) throws SQLException{
	Connection conn = BMS_Helper.con();
	Statement stmt = conn.createStatement(); //createStatement() method of Connection interface is used to create statement and store inside the object of Statement interface 
	ResultSet rs = stmt.executeQuery("select * from bank where acc_no ="+ acc_no +" and pin ="+pin);  //executeQuery() method of Statement interface is used to execute queries to the database, inside object of ResultSet interface 
	while(rs.next()) { //getting the column of each record in the table
		db_acc = rs.getInt(1);
		db_pin=rs.getInt(7);
	}
	if(db_acc!=acc_no) {
		System.err.println("!!WRONG ACCOUNT NUMBER INSERTED!!");
	}
	if(db_pin!=pin) {
		System.err.println("!!WRONG PIN INSERTED!!");
	}
	else {
	System.out.print("Enter amount you want to deposit :");
	double depo = sc.nextDouble();
	ResultSet rs2 = stmt.executeQuery("select balance from bank where acc_no ="+ acc_no +" and pin ="+pin); 
		while(rs2.next()) {
		pbal=rs2.getDouble(1); 
		System.out.println();
		System.out.println("Your previous balance was : "+pbal);
		}
		stmt.executeUpdate("Update bank set balance = "+(pbal+depo)+" where pin ="+ pin);
		System.err.println("Your new balance is       : "+(pbal+depo));
		System.err.println("-------------------------------");
	}
	}
}

