package Practice;

import java.io.IOException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	

	public static void main(String[] args) throws IOException {
		 
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
        ExcelFileUtility eUtil=new ExcelFileUtility();
        String value = eUtil.readDataFromExcel("Contacts", 4, 2);
        System.out.println(value);
        
        System.out.println(eUtil.getRowCount("Contacts"));
        
        eUtil.WriteDataIntoExcel("Contacts", 4, 6, "Batman");
        
        JavaUtility jutil=new JavaUtility();
        System.out.println(jutil.getSystemDate());
        System.out.println(jutil.getSystemDateInFormat());
        System.out.println(jutil.getRandomNumber());
        
        
        
	}

}
