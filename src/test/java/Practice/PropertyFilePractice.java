package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step 1:Open the File in Java Readable Format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2:Create Object Of Properties From Java.util Package
		Properties pobj=new Properties();
		
		//Step 3:Load the File Input Stream Into Properties
		pobj.load(fis);
		
		//Step 4:Access the Values with Keys
		String URL = pobj.getProperty("url");
		String UserName = pobj.getProperty("username");
		
		System.out.println(URL);
		System.out.println(UserName);
		

	}

}
