package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class SampleSelectQuery {

	public static void main(String[] args) throws Throwable {
		
		//Step 01: Load/Register the driver for Specific database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		//Step 02: Connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		//Step 03: Create/Issue SQL Statement
		  Statement stat = con.createStatement();
		  //Step 04: Execute the query
		ResultSet set =  stat.executeQuery("select * from student_list");
		while (set.next())
		{
			System.out.println(set.getInt(1) + "\t" + set.getString(2) + "\t" + set.getString(3) + "\t" + set.getString(4));
		}
		//verify 
		//Step 05: Close the connection
		con.close();
	}
}


