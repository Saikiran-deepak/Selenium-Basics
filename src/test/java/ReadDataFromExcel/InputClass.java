package ReadDataFromExcel;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class InputClass {

	@BeforeClass
	public void setupExcel() {
		// 🔁 Pass your Excel file path here
		ReadData.loadExcel("src/test/resources/TestData.xlsx");
	}

	@Test
	public void flexibleTest() {
		List<String> data = ReadData.getRowData("Sheet1", 1);

		String username = data.get(0);
		String password = data.get(1);

		if (data.size() >= 5) {
			String email = data.get(4);
			System.out.println("Email: " + email);
		}

		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}

}
