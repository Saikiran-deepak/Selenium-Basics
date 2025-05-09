package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;

public class Slider extends Base {
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

		driver.findElement(By.xpath("//span[contains(text(),'Slider')]")).click();

		
	    WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));

        // Set slider value and trigger both input and change events
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        String script = "let slider = arguments[0]; " +
                        "slider.value = arguments[1]; " +
                        "slider.dispatchEvent(new Event('input', { bubbles: true })); " +
                        "slider.dispatchEvent(new Event('change', { bubbles: true }));";
        js.executeScript(script, slider, "100");

        WebElement value = driver.findElement(By.id("sliderValue"));
       // System.out.println("Slider value: " + value.getAttribute("value"));

  

	}

	public static WebElement executor(WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
}
