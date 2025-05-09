package widgets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;

public class Dates extends Base {
	static Base b;
	String YEAR = "2020";
	String MONTH = "October";
	String DAY = "12";

	@Test
	public void dateSelection() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
		driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("05/05/2025");
		// driver.findElement(By.id("datePickerMonthYearInput")).click();
		WebElement year = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));

		// Select Year
		WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
		Dates.executor(yearDropdown);
		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByVisibleText(YEAR);

		// Select Month
		WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText(MONTH.substring(0, 1).toUpperCase() + MONTH.substring(1).toLowerCase());

		// Select Day
		WebElement day = driver
				.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + DAY + "']"));
		Dates.executor(day);
		day.click();

		Thread.sleep(10);
		driver.quit();

	}

	@Test
	public void dateAndTimeSection() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();

		// Navigate to Widgets
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();

		driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
		WebElement DTpicker = driver.findElement(By.id("dateAndTimePickerInput"));
		Dates.executor(DTpicker).click();

		// ==== Select Year ====
		WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-read-view--down-arrow"));
		Dates.executor(yearDropdown).click();

		for (int attempt = 0; attempt < 30; attempt++) {
			boolean dateFound = false;

			// Always refresh the list of year elements
			List<WebElement> yearSelect = driver
					.findElements(By.xpath("//div[@class='react-datepicker__year-option']"));

			for (WebElement year : yearSelect) {
				String yearText = year.getText().trim();
				if (yearText.equalsIgnoreCase(YEAR.trim())) {
					Dates.executor(year).click();
					Thread.sleep(500);
					Reporter.log("Year found and clicked", true);
					dateFound = true;
					break;
				}
			}

			if (dateFound) {
				break;
			}

			// If not found, click next or previous and re-loop
			int desiredYear = Integer.parseInt(YEAR.trim());
			int displayedYear = Integer.parseInt(yearSelect.get(yearSelect.size() / 2).getText().trim()); // Use middle
																											// element

			if (desiredYear > displayedYear) {
				WebElement nextButton = driver.findElement(By.xpath("//a[contains(@class,'years-upcoming')]"));
				Dates.executor(nextButton).click();
				// Reporter.log("Clicked NEXT year", true);
			} else {
				WebElement prevButton = driver.findElement(By.xpath("//a[contains(@class,'years-previous')]"));
				Dates.executor(prevButton).click();
				// Reporter.log("Clicked PREVIOUS year", true);
			}

			Thread.sleep(1000); // Let the new year list load
		}

		WebElement monthDropDown = driver
				.findElement(By.xpath("//span[@class=\"react-datepicker__month-read-view--down-arrow\"]"));
		Dates.executor(monthDropDown).click();
		List<WebElement> Months = driver.findElements(By.className("react-datepicker__month-option"));
		for (WebElement month : Months) {
			if (month.getText().contains(MONTH)) {
				Dates.executor(month).click();
				break;

			}

		}

		WebElement day = driver.findElement(By.xpath("//div[contains(text(),'" + DAY + "')]"));
		Dates.executor(day).click();

		driver.quit();
	}

	public static WebElement executor(WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

}
