package com.sms;

import java.sql.*;
import java.util.*;

import com.sms.fetch.DisplayRecord;
import com.sms.student.InsertRecord;
import com.sms.update.UpdateRecord;

public class Helper {
public static void main(String[] args) throws Exception {
	InsertRecord ir=new InsertRecord();
	DisplayRecord dr=new DisplayRecord();
	UpdateRecord ur=new UpdateRecord();
	Scanner sc= new Scanner(System.in);
	int ch;
	do {
	System.out.println("Enter your choice from 1 to 4: ");
	System.out.println("1: Insert record into Student Table \n2:Display records of Student Table \n3:Update record from Student Table \n4:Delete record from Student Table");
	ch=sc.nextInt();
	switch (ch)
    {
	case 1: 
		ir.insertRecord();
		break;
	case 2: 
		dr.displayRecord();
		break; 
	case 3:
		ur.updateRecord();
		break;
	case 4:
		System.out.println("\nThank you for using the program. Goodbye!\n");
		System.exit(0);
				break;
	
	default: 
		System.out.println("\nInvalid input\n");
			break;
    }
    }while(ch<5);
}

static {
	try {
		Class.forName("com.mysql.jdbc.Driver"); //registering driver
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} 
}
public static Connection con() throws SQLException{
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/deepdb","root","root");
}
}
