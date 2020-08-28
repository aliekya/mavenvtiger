package genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileData {
	public String fetchDataFromProperty(String key) throws IOException
	{
		FileInputStream file= new FileInputStream("./src/test/resources/Data.properties");
		Properties proj=new Properties();
		proj.load(file);
		String value = proj.getProperty(key);
		return value;
	}
	public String fetchDataFromExcel(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("./src/test/resources/FWexcelDocumentation.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}
	public void AddDataFromExcel(String sheetname, int rownum, int cellnum, String newdata) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("./src/test/resources/FWexcelDocumentation.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		cell.setCellValue(newdata);
		FileOutputStream out=new FileOutputStream("./src/test/resources/FWexcelDocumentation.xlsx");
		book.write(out);
		out.flush();
		
}

}
