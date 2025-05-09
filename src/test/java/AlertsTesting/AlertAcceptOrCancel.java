package AlertsTesting;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class AlertAcceptOrCancel extends Base {

	static Base b;

	@Test
	public void acceptAlert() throws InterruptedException {


		b=new Base();
		driver = b.Login2();
		
// For Head Less
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new"); // or just "--headless" for older versions
//		WebDriver driver = new ChromeDriver(options);
	

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		WebElement e = driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"));
		AlertAcceptOrCancel.executor(e);
		e.click();
		driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
		

		WebElement e1=driver.findElement(By.id("alertButton"));
		AlertAcceptOrCancel.executor(e1);
		e1.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		driver.findElement(By.id("timerAlertButton")).click();
		
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(2000);
		// Find the button and scroll it into view
		WebElement alrt = driver.findElement(By.id("promtButton"));
		AlertAcceptOrCancel.executor(alrt);
		alrt.click();

//		// Wait until the alert is present
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

//		 Switch to the alert and send text
		Alert alert1 = driver.switchTo().alert();  // ⚠️ Switch AFTER alert is confirmed to exist
		alert1.sendKeys("Testing abc");
		Thread.sleep(2000);
		alert1.accept(); // Optional: to submit the prompt
		driver.quit();

	
}
	
	public static WebElement executor(WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
}
