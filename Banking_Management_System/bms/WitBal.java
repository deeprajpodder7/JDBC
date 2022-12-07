package com.banking.bms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.banking.BMS_Helper;

public class WitBal {
	int pin;
	double pbal;
	int db_pin;
	int db_acc;
	Scanner sc = new Scanner(System.in);
	public void WithdrawalBalance(int acc_no,int pin) throws SQLException, WrongpinException {
		this.pin=pin;
		Connection conn = BMS_Helper.con();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from bank where acc_no ="+ acc_no +" and pin ="+pin);
		while(rs.next()) {
			db_acc = rs.getInt(1);
			db_pin=rs.getInt(7);
		}
		if(db_acc!=acc_no || db_pin !=pin) {
			throw new WrongpinException("!!WRONG ACCOUNT NUMBER/PIN INSERTED!!");
		}
		else {
		System.out.print("Enter amount you want to withdraw :");
		double with = sc.nextDouble();
		ResultSet rs2 = stmt.executeQuery("select balance from bank where pin ="+pin);
			while(rs2.next()) {
			pbal=rs2.getDouble(1); // storing the salary 
			if((pbal-with)<0) {
				System.out.println();
				System.err.println("!!Insufficient BALANCE!!");
				System.out.println("-------------------------------");
			}
			else {
			System.out.println();
			System.out.println("Your previous balance was : "+pbal);
			}
			stmt.executeUpdate("Update bank set balance = balance-"+with+" where pin ="+ pin);
			System.err.println("Your new balance is       : "+(pbal-with));
			System.err.println("-------------------------------");}
		}}
}