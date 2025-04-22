package Frames;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
public class IFrames extends Base{
	static Base b;
	static WebDriver driver;
	@Test
	public void frames() throws InterruptedException{
		b=new Base();
		b.Login2();
		driver=new ChromeDriver();
		driver.get("https://Demoqa.com");
		WebElement element=driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Frames')]")).click();
		
//		String text=driver.findElement(By.xpath("//div[@id='framesWrapper']//h1[@class='text-center']")).getText();
//		assertEquals(text, "Frames");
		
		
//		driver.findElements(By.id("frame1Wrapper"));
		WebElement Frames=driver.findElement(By.xpath("//iframe[@id='frame2']"));
		Thread.sleep(5000);
		
		driver.switchTo().frame(Frames);
		String frameText=driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]")).getText();
		Reporter.log(frameText,true);
		assertEquals(frameText, "This is a sample page");
		//driver.switchTo().parentFrame();
		
//		for(WebElement iframe:Frames) {
//			//driver.switchTo().frame(iframe).getTitle();
//			}
		
		
	
		driver.close();
	}

}
