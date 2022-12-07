package com.banking.bms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.banking.BMS_Helper;

public class ShowBal {
	int db_acc;
	int db_pin;
	public void showAccountDetails(int acc_no,int pin) throws SQLException, WrongpinException{ 
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
		System.err.println("-------------------------------");
		System.out.println("Details of Your Account:");
		ResultSet rs1=stmt.executeQuery("select * from Bank where pin ="+pin);
		while(rs1.next()) {
			System.err.println("Account Number  : "+rs1.getInt(1));
			System.err.println("Account Holder  : "+rs1.getString(2));
			System.err.println("Branch IFSC     : "+rs1.getString(3));
			System.err.println("Branch          : "+rs1.getString(4));
			System.err.println("Account type    : "+rs1.getString(5));
			System.err.println("Account Balance : "+rs1.getDouble(6));
			System.err.println("Account Pin : "+rs1.getInt(7));
			System.err.println("-------------------------------");
		}
		}
	}
}