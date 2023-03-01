package comp.magnus.libraryfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public static String getprofiles(String key) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream("C:\\Users\\Prachi\\eclipse-workspace\\magnus\\Testdata\\Credentials.properties");
		Properties pro = new Properties();
		pro.load(file);
		String value = pro.getProperty(key);
		return value;
	}
	
	public static String getexceldata(int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Prachi\\eclipse-workspace\\magnus\\Testdata\\magnustestdata.xlsx");
		Sheet data1 = WorkbookFactory.create(file).getSheet("data1");
		String value = data1.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	public static String getempdata(int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Prachi\\eclipse-workspace\\magnus\\Testdata\\magnustestdata.xlsx");
		Sheet data1 = WorkbookFactory.create(file).getSheet("empdata");
		String value = data1.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	

}
