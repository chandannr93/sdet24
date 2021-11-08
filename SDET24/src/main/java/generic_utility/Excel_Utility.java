package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class is created using apache POi libraries, Which is used to read the Workbook(Excel)
 * @author Chandan NR
 *
 */
public class Excel_Utility {
/**
 * This method is used to read the data from excel sheet, with the below parameters
 * @author Chandan NR
 * @param sheet
 * @param rowNum
 * @param colNum 
 * @throws Throwable 
 * @returns String
 * @throws Throwable
 */
	public String getDataFromExcelSheet(String SheetName, int rowNum, int colNum ) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		  String data = row.getCell(colNum).getStringCellValue();
		  workbook.close();
		  return data;		  
	}
	/**
	 * This method is used to get the last row number on specified sheet
	 * @param sheetName
	 * @return getLastRowNum
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return sheet.getLastRowNum();		
	}
	/**
	 * This method is used to write the data into the excel sheet based on the below arguments
	 * @param sheetName
	 * @param rowNum 
	 * @param colNum
	 * @param data
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public void setDataInExcel(String sheetName, int rowNum, int colNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(colNum);
		cell.setCellValue(data);
		FileOutputStream fist = new FileOutputStream("./data/testData.xlsx");
		 workbook.write(fist);
		 workbook.close(); 	
	}
}
