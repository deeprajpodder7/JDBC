package com.banking.bms;



	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import com.banking.BMS_Helper;




	 public class CloseAccount {
		int db_pin;
		int db_acc;
		public void cloacc(int acc_no,int pin) throws SQLException,WrongpinException{
			Connection conn = BMS_Helper.con();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from bank where acc_no ="+ acc_no +" and pin ="+pin);
			while(rs.next()) {
				db_acc = rs.getInt(1);
				db_pin=rs.getInt(7);
			}
			if(db_acc!=acc_no || db_pin!=pin) {
				throw new WrongpinException("!!WRONG ACCOUNT NUMBER/PIN INSERTED!!");
			}
			else {
			stmt.executeUpdate("Delete from bank where acc_no ="+ acc_no +" and pin ="+pin);
			System.err.println("----Account Closed----");
			}
		}
	}
	 

