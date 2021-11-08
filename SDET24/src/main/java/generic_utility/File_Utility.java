package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Chandan NR
 *
 */
public class File_Utility {
/**
 * Used to get the data from the property file based on the key
 * @param key
 * @return the value of the key in the form of string
 * @throws Throwable 
 * @throws Throwable
 */
	public String getPropertyKeyValue(String key) throws Throwable {
		// Step 01: Get the Java Representation object of the physical file
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		// Step 02: Create an Object to property class to load all the keys
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String value = pobj.getProperty(key);
		return value;
		
	}
}
