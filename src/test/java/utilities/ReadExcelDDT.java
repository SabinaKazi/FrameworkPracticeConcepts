package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDDT {

	public static Object[][] getExcelData(String sheetName) throws IOException {

		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Saucedemo.xlsx";
		FileInputStream fis = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[totalRows - 1][totalCols]; // skipping header row

		// Start from row 1 (skip header)
		for (int r = 1; r < totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c < totalCols; c++) {
				XSSFCell currentCell = currentRow.getCell(c);
				if (currentCell == null) {
				    data[r - 1][c] = "";
				} else {
				    data[r - 1][c] = currentCell.toString();
				}
			}
		}

		workbook.close();
		fis.close();

		return data;

}
}
