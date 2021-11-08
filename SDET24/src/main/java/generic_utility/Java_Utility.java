package generic_utility;

import java.util.Date;
import java.util.Random;

/**
 * This Class contains java Specific generic libraries
 * @author Chandan NR
 *
 */
public class Java_Utility {
public int getRandomNumber() {
	/**
	 * Its used to get the integer random number within the specified range.
	 * @return integer 
	 */
	Random ranDom = new Random();
	int ranDomNum = ranDom.nextInt(1000);
	return ranDomNum;
}
/**
 * It is used to get the current system date and time.
 * @return system_DateandTime
 */
public String getSystemDateandTime() {
	Date date = new Date();
	String system_DateandTime = date.toString();
	return system_DateandTime;
}
/**
 * It is used to get the current system date in YYYY-MM-DD format.
 * @return final_Format.
 */
public String getSystemDateandYYYY_MM_DD() {
	Date date = new Date();
	String[] dateArr = date.toString().split(" ");
	String DD = dateArr[2];
	String YYYY = dateArr[5];
	int MM = date.getMonth()+1;
	String final_Format = YYYY+"-"+MM+"-"+DD;
	return final_Format;	
}
}
