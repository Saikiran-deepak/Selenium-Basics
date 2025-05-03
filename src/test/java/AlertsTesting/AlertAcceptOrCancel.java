package AlertsTesting;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

<<<<<<< HEAD
public class AlertAcceptOrCancel {
	static WebDriver driver;
=======
public class AlertAcceptOrCancel extends Base{
	//static WebDriver driver;
>>>>>>> a78173b (Running TestCase from XML)
	static Base b;

	@Test
	public void acceptAlert() throws InterruptedException {
<<<<<<< HEAD
		b = new Base();
		b.Login2();
		driver = new ChromeDriver();
=======
		b=new Base();
		driver = b.Login2();
		
	//	driver = new ChromeDriver();
//--> For Head Less
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new"); // or just "--headless" for older versions
//		WebDriver driver = new ChromeDriver(options);
//<<-		
>>>>>>> a78173b (Running TestCase from XML)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		WebElement e = driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
		driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
		
		
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		
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
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alrt);

		// Click the button to trigger the prompt alert
		alrt.click();

//		// Wait until the alert is present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

//		 Switch to the alert and send text
		Alert alert = driver.switchTo().alert();  // ⚠️ Switch AFTER alert is confirmed to exist
		alert.sendKeys("Testing abc");
		Thread.sleep(2000);
		alert.accept(); // Optional: to submit the prompt
		driver.quit();

	}
}
