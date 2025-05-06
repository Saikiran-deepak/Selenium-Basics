package widgets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;

public class AutoComplete extends Base {
	static Base b;

	@Test
	public void Download() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		driver.findElement(By.xpath("//span[contains(text(),'Auto Complete')]")).click();
		// Type Color
//		driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']")).sendKeys("b");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		List<WebElement> elements = wait.until(ExpectedConditions
//				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"auto-complete__indicators css-1wy0on6\"]")));
//		for (WebElement element : elements) {
//			if (element.getText().equalsIgnoreCase("Black")) {
//				element.click();
//				break;
//			}
//		}

		// Step 1: Locate input and type text
		WebElement inputBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("autoCompleteMultipleInput")));
		inputBox.sendKeys("B");

		// Step 2: Wait for dropdown suggestions to appear

		List<WebElement> suggestions = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@id, 'react-select-2-option')]")
//						By.xpath("//*[contains(text(),'Black')]") // adjust

				));

		// Step 3: Click the suggestion that says "Black"
		for (WebElement suggestion : suggestions) {
			if (suggestion.getText().equalsIgnoreCase("Blue")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", suggestion);
				suggestion.click();
				break;
			} else {
				Reporter.log("Element not found", true);
			}
		}

	}
}
