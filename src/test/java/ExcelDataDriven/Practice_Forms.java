package ExcelDataDriven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.Base;

public class Practice_Forms extends Base {
	Base b = new Base();

	@BeforeTest
	public void setupExcel() {
		ReadExcelData.loadExcel("C:/Users/kiran/OneDrive/Desktop/Selenium Input/TestFile.xlsx");
		driver = b.Login2();
	}

	@Test
	public void registerClassTest() {
		String SheetName = "Sheet1";
		List<ReadExcelData> allForms = ReadData(SheetName);

		for (ReadExcelData form : allForms) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement registerForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"card-body\"]//h5[contains(text(),'Forms')]")));
//			WebElement registerForm = driver.findElement(By.xpath("//div[@class=\"card-body\"]//h5[contains(text(),'Forms')]"));
			jsExecutor(registerForm).click();
			//register.click();
			driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();

			driver.findElement(By.id("firstName")).sendKeys(form.getFName());
			driver.findElement(By.id("lastName")).sendKeys(form.getLName());
			driver.findElement(By.id("userEmail")).sendKeys(form.getEmail());
			WebElement radioM=driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
			jsExecutor(radioM).click();

			// Additional form fields and submission can go here
		}
	}

	public List<ReadExcelData> ReadData(String sheet) {
		
		List<ReadExcelData> forms = new ArrayList<>();
		int colCount = ReadExcelData.getColumnCount(sheet, 1);

		for (int i = 1; i <= colCount; i++) {
			List<String> data = ReadExcelData.getRowData(sheet, i);
			if (data.size() >= 3) {
				forms.add(new ReadExcelData(data.get(0), data.get(1), data.get(2)));
			}
		}
		return forms;
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	public static WebElement jsExecutor(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
}
