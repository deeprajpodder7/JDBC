package com.banking.bms;

import java.sql.*;
import java.util.Scanner;

import com.banking.BMS_Helper;

public class PinChange {
	int db_acc, db_pin;
	Scanner sc=new Scanner(System.in);
	public void PinChange(int acc_no,int pin)throws SQLException,WrongAccnoException,WrongpinException{
	Connection conn = BMS_Helper.con();
	Statement stmt = conn.createStatement();
	System.out.println("Enter New Pin: ");
	int newPin=sc.nextInt();
	ResultSet rs = stmt.executeQuery("select * from bank where acc_no="+acc_no);
	while(rs.next()) {
		db_acc=rs.getInt(1);
		db_pin=rs.getInt(7);
	}
	if(db_acc!=acc_no) {
		throw new WrongAccnoException("!!WRONG ACCOUNT NUMBER INSERTED!!");
	}
	if(db_pin!=pin) {
		throw new WrongpinException("!!WRONG PIN INSERTED!!");
	}
	else {
		stmt.executeUpdate("update bank set pin = "+newPin+" where acc_no="+acc_no);
		System.err.println("---- Pin Has Been Changed ----");
	}
	}
}
