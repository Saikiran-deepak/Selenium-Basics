package WindowHandles;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;

public class Windows extends Base {
	static Base b;
	static WebDriver driver;

	@Test
	public static void Newwindow() throws InterruptedException {
		b = new Base();
		// System.setProperties("WebDriver.chrome.driver","https://demoqa.com/");
		b.Login2();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		driver.manage().window().maximize();

		WebElement element = driver
				.findElement(By.xpath("//div[@class='card-body']//h5[contains(text(),'Alerts, Frame & Windows')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();

		// driver.findElement(By.xpath("//div[@id=\"browserWindows\"]"));

		WebElement newWindow = driver.findElement(By.xpath("//button[@id=\"windowButton\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newWindow);
		newWindow.click();
		Thread.sleep(10000);

		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parent)) {
				driver.switchTo().window(handle);// switch to child window
				String text = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
				Reporter.log(text, true);

			}
		}
		driver.close();

		driver.switchTo().window(parent);
		driver.close();
	}

	@Test
	public static void NewTab() throws InterruptedException {
		b = new Base();
		// System.setProperties("WebDriver.chrome.driver","https://demoqa.com/");
		b.Login2();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		driver.manage().window().maximize();

		WebElement element = driver
				.findElement(By.xpath("//div[@class='card-body']//h5[contains(text(),'Alerts, Frame & Windows')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();

		driver.findElement(By.xpath("//button[@id='tabButton']")).click();

		Thread.sleep(10000);

		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parent)) {
				driver.switchTo().window(handle);
				String text = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
				Reporter.log(text, true);

			}
		}
		driver.close();

		driver.switchTo().window(parent);
		driver.close();

	}

	@Test
	public static void windowMessage() throws InterruptedException {
		b = new Base();
		// System.setProperties("WebDriver.chrome.driver","https://demoqa.com/");
		b.Login2();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement element = driver
				.findElement(By.xpath("//div[@class='card-body']//h5[contains(text(),'Alerts, Frame & Windows')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();

		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();

		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parent)) {
				Reporter.log(handle,true);
				driver.switchTo().window(handle);
			}
		}
		driver.close();

		driver.switchTo().window(parent);
		driver.close();

	}
}
