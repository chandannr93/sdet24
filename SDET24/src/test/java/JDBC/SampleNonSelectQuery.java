package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleNonSelectQuery {
public static void main(String[] args) throws Throwable {
		
		//Step 01: Load/Register the driver for Specific database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		//Step 02: Connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		//Step 03: Create/Issue SQL Statement
		  Statement stat = con.createStatement();
		  //Step 04: Execute the query
		int result =  stat.executeUpdate("insert into student_list values (8,'Chandana','nrc','chandana.nrc@gmail.com')");
		if (result==1)
		{
			System.out.println("Student Created Sucessfully");
			
		}
		else {
			System.err.println("Student not Created");
		//verify 
		//Step 05: Close the connection
		con.close();
	}
}
}
