package com.sms.fetch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.sms.Helper;


public class DisplayRecord {

	public void displayRecord() throws Exception{
		Connection con=Helper.con();
		Statement stmt=con.createStatement(); //3. Creating Statement
		ResultSet rs= stmt.executeQuery("select * from StudentManage");
		while(rs.next()) {
		System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " +rs.getInt(3) + " " + rs.getString(4)); }
	
}
}
