package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try
		{
		Driver driverRef=new Driver();
	
		//Step 1:Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2:Get the connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//Step 3:Issue Create Statement
		Statement state = con.createStatement();
		
		//Step 4:Execute the query
		String query="insert into candidateinfo values('Bagad Billa',01,'Mayurbhanj');";
		int result = state.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("data added");
		}
		ResultSet resul = state.executeQuery("select * from candidateinfo;");
		while(resul.next())
		{
		System.out.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));	
		}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
		//Step 5:Close the browser
          con.close();
          System.out.println("db closed");
	}

}
}
