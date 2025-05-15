package ExcelDataDriven;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class InputClass {

	@BeforeClass
	public void setupExcel() {
		// 🔁 Pass your Excel file path here
		ReadExcelData.loadExcel("C:/Users/kiran/OneDrive/Desktop/Selenium Input/TestFile.xlsx");
	}

	@Test
	public void flexibleTest() {
		int colCount = ReadExcelData.getColumnCount("Sheet1", 1);
		System.out.println(colCount);
		for (int i = 1; i < colCount; i++) {
			List<String> data = ReadExcelData.getRowData("Sheet1", i);

			String username = data.get(0);
			String password = data.get(1);
			String emial = data.get(2);

			System.out.println("Username: " + username + " ,Password: " + password + " ,email: " + emial);

		}

	}

}
