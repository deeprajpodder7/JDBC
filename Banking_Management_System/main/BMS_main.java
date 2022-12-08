package com.banking.main;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

import com.banking.bms.CloseAccount;
import com.banking.bms.DepBal;
import com.banking.bms.Open;
import com.banking.bms.PinChange;
import com.banking.bms.ShowBal;
import com.banking.bms.WitBal;


public class BMS_main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		int variable;
		do{
		System.out.println("""
				->||    Welcome to Our Banking Services    ||<- 
				      
				Press 1 to open account in our bank	:~
				Press 2 to check your account details 	:~
				Press 3 to deposit money in your account 	:~
				Press 4 to withdraw money from your account 	:~
				Press 5 to change your pin 	:~
				Press 6 to close your account 	:~
				Press 7 to exit 	:~ 
				""");
		variable = sc.nextInt(); 
		System.out.println("-------------------------------");
		switch(variable) {
		case 1 : 
			System.out.print("Enter 10 Digits To Create A New Account Number  :");
			int acc_no=sc.nextInt();
	    	System.out.print("Enter Account Ifsc :");
	    	String ifsc_code=sc.next();
	    	System.out.print("Enter 4 Digits To Create A New Account Pin :");
	    	int pin=sc.nextInt();
			Open op = new Open();
			op.OpenNewAccount(acc_no,ifsc_code,pin);
			System.err.println("----New Account Created----");
			break;
		case 2 :  
			System.out.print("Enter Your Account Number: ");
			int p = sc.nextInt();
			System.out.print("Enter Your pin : ");
			int q = sc.nextInt();
			ShowBal sb = new ShowBal();
			sb.showAccountDetails(p,q);
			System.out.println();
			break;
		case 3 :
			System.out.print("Enter Your Account Number: ");
			int a = sc.nextInt();
			System.out.print("Enter Your pin : ");
			int b = sc.nextInt();
			DepBal db = new DepBal();
			db.DepositBalance(a, b);
			System.out.println();
			break;
		case 4 :
			System.out.print("Enter Your Account Number: ");
			int c = sc.nextInt();
			System.out.print("Enter Your pin : ");
			int d = sc.nextInt();
			WitBal wb = new WitBal();
			wb.WithdrawalBalance(c,d);
			System.out.println();
			break;
		case 5:
			System.out.print("Enter Your Account Number: ");
			int e = sc.nextInt();
			System.out.print("Enter Your Current Pin : ");
			int f = sc.nextInt();
			PinChange pc=new PinChange();
			pc.PinChange(e,f);
			System.err.println("---- Pin Has Been Changed ----");
			break;
		case 6 :
			System.out.print("Enter Your Account Number: ");
			int g = sc.nextInt();
			System.out.print("Enter Your pin : ");
			int h = sc.nextInt();
			CloseAccount ca = new CloseAccount();
				ca.cloacc(g,h);
			System.out.println();
			break;
		case 7 :
			System.err.println("You have successfully logged out");
			System.out.println("--Thank You--");
			System.out.println();
			System.exit(0);
			break;
		}}
		while(variable>0 && variable<8);
	}
}

