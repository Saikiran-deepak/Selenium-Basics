package Clicks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import BaseClass.Base;

public class ClickButtons extends Base{
	
	static Base b;
	@Test
	public void doubleClick() {
		b=new Base();
		driver = b.Login2();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();		
		driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();
		//Double Click
		WebElement element = driver.findElement(By.id("doubleClickBtn"));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		driver.close();

	}
	@Test
	public void rightClick() {
		b=new Base();
		driver = b.Login2();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();		
		driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();
		//Double Click
		WebElement element = driver.findElement(By.id("Right Click Me"));
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		driver.close();

	}
}
