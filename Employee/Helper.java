package December1Lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {
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
