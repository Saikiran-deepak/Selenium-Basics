package LoginTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class OpenWebsite {
@Test
public static void Login() throws IOException, InterruptedException {
	System.setProperty("WebDriver.chrome,driver", "C:\\Users\\kiran\\Drivers\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
	WebElement name=driver.findElement(By.id("username"));
	name.sendKeys("Itachi");
	String url= driver.getCurrentUrl();
	//Reporter.log("Current URL: " + url, true);
	//Reporter.log("Page Title "+driver.getTitle(),true);
	
	// Find Elements
	List<WebElement> elements=driver.findElements(By.tagName("label"));
	for(WebElement element:elements) {
		//Reporter.log(element.getText(),true);
	}
	
	WebElement element=driver.findElement(By.xpath("//label[@for='username']"));
	//Reporter.log(element.getText(),true);
	Thread.sleep(5000);  // waits exactly 5 seconds
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String Pagesource=driver.getPageSource();
	Reporter.log(Pagesource,true);
	driver.close();
}
}
