package radioButtons;

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

public class RadioButtons extends Base {
	static Base b;

	@Test
	public void test1() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		// driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		// Click on the radio
		driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
		List<WebElement> radioButtons = driver.findElements(By.xpath("//label[@class=\"custom-control-label\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		for (WebElement radio : radioButtons) {
			if (!radio.isSelected()) {
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
//				Reporter.log(radio.getText());
				wait.until(ExpectedConditions.elementToBeClickable(radio)).click();
				radio.click();
			}

		}

		driver.quit();
	}
}
