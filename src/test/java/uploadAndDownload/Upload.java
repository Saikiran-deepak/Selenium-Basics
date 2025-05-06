package uploadAndDownload;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.Base;

public class Upload extends Base{
	static Base b;

	@Test
	public void Download() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		// driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Download')]")).click();
		driver.close();
	}
	
	

	@Test
	public void Upload() throws InterruptedException {
		b = new Base();
		driver = b.Login2();
		// driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		ele.click();
		driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]")).click();
		//WebElement uploadFile=driver.findElement(By.id("uploadFile"));
		//uploadFile.click();
		//uploadFile.sendKeys("C:\\Users\\kiran\\OneDrive\\Desktop\\Selenium Input\\InputFile.docx");
		//or
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\kiran\\OneDrive\\Desktop\\Selenium Input\\InputFile.docx");
		driver.close();
	}
}
