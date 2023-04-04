package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuerry {

	public static void main(String[]args) throws SQLException
	{
		//Driver for MysqL Database
		Driver driverRef=new Driver();
		
		//Step 1:Register the Driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2:GetConnection from Database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//Step 3:Issue Create Statement
		Statement state=con.createStatement();
		
		//Step 4:Execute the query-Table Name
		ResultSet result=state.executeQuery("select * from candidateinfo;");
		while(result.next())
		{
		System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));	
		}
		//Step 5:Close the browser
		con.close();
		System.out.println("db closed");
		
		
		
		
		
	}
}
