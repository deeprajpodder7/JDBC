package com.banking.bms;



	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import com.banking.BMS_Helper;




	 public class CloseAccount {
		int db_pin;
		int db_acc;
		public void cloacc(int acc_no,int pin) throws SQLException{
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
			stmt.executeUpdate("Delete from bank where acc_no ="+ acc_no +" and pin ="+pin);
			System.err.println("----Account Closed----");
			}
		}
	}
	 

