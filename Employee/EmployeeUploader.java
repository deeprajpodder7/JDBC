package December1Lab;

import java.sql.*;
import java.util.Scanner;

import com.student.Helper;

class LessSalaryException extends Exception{	//Less salary exception custom class
	public LessSalaryException(String str) {
		super(str);
	}
}

public class EmployeeUploader {    //class which contains all the methods 
	Scanner sc=new Scanner(System.in);
	int e_id,d_id,e_contact;
	double e_salary;
	String e_name,d_name,d_head,d_description,e_address;
	
	//saving department details
	public void storeDepartmentDetails()throws Exception{
		System.out.println("Enter department id: ");
		d_id=sc.nextInt();
		System.out.println("Enter department name: ");
		d_name=sc.next();
		System.out.println("Enter department head: ");
		d_head=sc.next();
		System.out.println("Enter department description: ");
		d_description=sc.next();
		
		Connection con=Helper.con();		PreparedStatement stmt=con.prepareStatement("insert into Department values(?,?,?,?)");
		stmt.setInt(1, d_id);
		stmt.setString(2, d_name);
		stmt.setString(3, d_head);
		stmt.setString(4, d_description);
		stmt.executeUpdate();
	  }
	
	//saving employee details
	public void storeEmployeeDetails()throws Exception{
		System.out.println("Enter employee id: ");
		e_id=sc.nextInt();
		System.out.println("Enter employee name: ");
		e_name=sc.next();
		System.out.println("Enter employee address: ");
		e_address=sc.next();
		System.out.println("Enter employee salary: ");
		e_salary=sc.nextDouble();
		System.out.println("Enter employee contact no. : ");
		e_contact=sc.nextInt();
		System.out.println("Enter department id : ");
		d_id=sc.nextInt();
		
		if(e_salary<1000) throw new LessSalaryException("Salary must be greater than 1000!!");  //throwing the custom exception if salary <1000
		
		Connection con=Helper.con();	//creating connection with the help of Helper class
		PreparedStatement stmt=con.prepareStatement("insert into Employee values(?,?,?,?,?)"); 
		stmt.setInt(1, e_id);
		stmt.setString(2, e_name);
		stmt.setString(3, e_address);
		stmt.setDouble(4, e_salary);
		stmt.setInt(5, e_contact);
		stmt.executeUpdate();
	  }
	
	//retrieving employee details
	public void retrieveEmployeeDetails(int e_id) throws Exception{
		Connection con=Helper.con();		Statement stmt=con.createStatement(); // Creating Statement
		int count=0;
		ResultSet rs= stmt.executeQuery("select * from Employee where e_id="+e_id);
		while(rs.next()) {
		System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " +rs.getString(3) + " " + rs.getDouble(4) + " " +rs.getInt(5)+ " " +rs.getInt(6)); count++; }
		if(count==0)System.out.println("Id not found");
	}
	
	//method to calculate PF of employee
	public void calculatePF(int e_id) throws Exception{ 
		Connection con=Helper.con();	//creating connection with the help of Helper class
		Statement stmt=con.createStatement();  //creating statement
		ResultSet rs= stmt.executeQuery("select * from Employee where e_id="+e_id);
		while(rs.next()) {
			//checking conditions as per question
		if(rs.getInt(4) >= 1000 && rs.getInt(4)<=10000) {
			double salary=rs.getInt(4)*1.05;
			System.out.println("Employee PF amount is: "+salary);
		}
		
		else if(rs.getInt(4) >= 10000 && rs.getInt(4)<=100000) {
			double salary=rs.getInt(4)*1.06;
			System.out.println("Employee PF amount is: "+salary);
		}
		if(rs.getInt(4) >100000) {
			double salary=rs.getInt(4)*1.07;
			System.out.println("Employee PF amount is: "+salary);
		}
		}
	}

}
