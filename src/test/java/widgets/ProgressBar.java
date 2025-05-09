package widgets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class ProgressBar extends Base {
	static Base b;

	@Test
	public static void sliderTest() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]"));
		executor(ele);
		ele.click();
		driver.findElement(By.xpath("//span[contains(text(),'Progress Bar')]")).click();
		driver.findElement(By.id("startStopButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(driver -> {
			WebElement progressBar = driver.findElement(By.xpath("//div[@id='progressBar']"));
			String text = progressBar.getText().replace("%", "").trim();
			try {
				int progress = Integer.parseInt(text);
				return progress >= 40;
			} catch (NumberFormatException e) {
				return false;
			}
		});

		// Stop the progress
		driver.findElement(By.id("startStopButton")).click();

	}

	public static WebElement executor(WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

}
