package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void getData() throws IOException {

		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Saucedemo.xlsx";

		FileInputStream fis = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Saucedemo");

		int totalRows = sheet.getPhysicalNumberOfRows();
		int totlCells = sheet.getRow(1).getLastCellNum();

		System.out.println(totalRows);
		System.out.println(totlCells);

		for (int r = 1; r < totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);

			for (int c = 0; c < totlCells; c++) {
				XSSFCell currentCell = currentRow.getCell(c);
				String value = currentCell.toString();
				System.out.print(value + "|");
			}

			System.out.println();
		}

		workbook.close();
		fis.close();

	}
	
	public static void main(String[]args) throws IOException
	{
		getData();
	}

}
