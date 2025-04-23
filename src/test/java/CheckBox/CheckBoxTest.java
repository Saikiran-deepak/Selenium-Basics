package CheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;

public class CheckBoxTest extends Base{
	static WebDriver driver;
	static Base b;

	@Test
	public void test1() throws InterruptedException{
		b=new Base();
		b.Login2();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();
		//Click on the checkbox 
		driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
		driver.findElement(By.xpath("//button[@class=\"rct-collapse rct-collapse-btn\"]")).click();
		
		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click();
		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[3]")).click();
		driver.findElement(By.xpath("(//button[@class=\"rct-collapse rct-collapse-btn\"])[5]")).click();
		List<WebElement> elements=driver.findElements(By.xpath("(//li[@class=\"rct-node rct-node-parent rct-node-expanded\"])[3]//li[@class=\"rct-node rct-node-parent rct-node-expanded\"]//li"));
		
		for(int i=0;i<elements.size();i++) {
			if(!elements.get(i).isSelected()) {
				Thread.sleep(3000);
				WebElement officeElement=elements.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", officeElement);
				officeElement.click();
			}
		}

		Thread.sleep(5000);
		driver.close();
	}
}
