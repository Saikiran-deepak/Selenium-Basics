package WebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;

public class WebTableTest extends Base {

	static Base b;

	@Test
	public void webTablesTest() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]")).click();
		driver.findElement(By.xpath("//div[@class=\"rt-tr-group\"]")).click();
		driver.findElement(By.id("addNewRecordButton")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Uchiha");
		driver.findElement(By.id("lastName")).sendKeys("Itachi");
		driver.findElement(By.id("userEmail")).sendKeys("Itachi3423@gmail.com");
		driver.findElement(By.id("age")).sendKeys("27");
		driver.findElement(By.id("salary")).sendKeys("45343");
		driver.findElement(By.id("department")).sendKeys("Testing");
		driver.findElement(By.id("submit")).submit();
		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));

		for (int i = 0; i < elements.size(); i++) {
			String a = elements.get(i).getText(); // ✅ Get text from the WebElement

			if (a.equals("Itachi")) {
				//String b = elements.get(i).getText();
				//Reporter.log(b, true);
				// Assuming each row has exactly 6 columns, and the match is within the 3rd
				// column of each row
				int rowIndex = i / 6; // because rt-tr-group represents rows, and each has 6 td

				String baseXPath = "(//div[@class='rt-tr-group'])[" + (rowIndex + 1) + "]//div[@class='rt-td']";
				//Reporter.log(baseXPath, true);
				String firstname = driver.findElement(By.xpath(baseXPath + "[1]")).getText();
				String lastName = driver.findElement(By.xpath(baseXPath + "[2]")).getText();
				String Age = driver.findElement(By.xpath(baseXPath + "[3]")).getText();
				String Email = driver.findElement(By.xpath(baseXPath + "[4]")).getText();
				String Salary = driver.findElement(By.xpath(baseXPath + "[5]")).getText();
				String Department = driver.findElement(By.xpath(baseXPath + "[6]")).getText();

				Reporter.log("Firstname = " + firstname + ",\nLastname = " + lastName + ",\nSalary = " + Salary
						+ ",\nAge = " + Age+ "\nEmail = " +Email+ "\nDepartment = " +Department, true);
			}
		}

		Thread.sleep(2000);
		driver.close();

	}

}
