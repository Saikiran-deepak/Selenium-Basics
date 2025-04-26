package Frames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import BaseClass.Base;
public class NestedFrames extends Base{
	
	static Base base;
	//static 
	@Test
	public void nestedFrames() {
		base=new Base();
		driver = base.Login2();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com");
		WebElement element= driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Nested Frames')]")).click();
		
		//Parent Frame Details
		WebElement frameParent=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frameParent);
		
		//Child Frame Details
		WebElement child=driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		driver.switchTo().frame(child);
		String text=driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]")).getText();
		Reporter.log(text,true);
		//Child Frame Validation
		assertEquals(text,"Child Iframe");
		
		//Switching back to parent Frame
		driver.switchTo().parentFrame();
		
		String Parenttext=driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText();
		Reporter.log(Parenttext,true);
		//Parent Frame Validation
		assertEquals(Parenttext,"Parent frame");
		
		driver.close();
	}

}
