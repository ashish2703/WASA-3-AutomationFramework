package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		//Step 1:Open the document in java readable format
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
				
				//Step 2:Create a Workbook
				Workbook wb=WorkbookFactory.create(fis);
				
				//Step 3:Get Control of Sheet
				Sheet sh=wb.getSheet("Contacts");
				
				//Step 4:Get Control of Row
				Row rw=sh.getRow(4);
				
				//Step 5:Create a Cell in that Row
				Cell ce = rw.createCell(8);
				
				//Step 6:Set a value to the Cell
				ce.setCellValue("wasa");
				
				//Step 7:Open the document in write mode
				FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Test Data.xlsx");
				
				//Step 8:Write the data
				wb.write(fos);
				System.out.println("data added");
				
	}

}
