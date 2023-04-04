package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of Generic Methods to read data from Property File
 * @author patnaik
 *
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read data from Property File
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.PropertyFilePath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;

	}

}

