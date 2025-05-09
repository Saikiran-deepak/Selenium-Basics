package ReadDataFromExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	private static Workbook workbook;

	public static void loadExcel(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getRowData(String sheetName, int rowNum) {
		List<String> rowData = new ArrayList<>();
		if (workbook == null)
			return rowData;

		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		if (row == null)
			return rowData;

		DataFormatter formatter = new DataFormatter();
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			rowData.add(formatter.formatCellValue(cell));
		}
		return rowData;
	}
}
