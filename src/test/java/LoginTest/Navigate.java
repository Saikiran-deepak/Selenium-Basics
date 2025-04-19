package LoginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Navigate extends Base{
	static WebDriver driver;
	static Base b;
	static WebDriverWait wait;
	//@Test
	public static void goBack() throws InterruptedException{
		b=new Base();
		b.Login();
		driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		Thread.sleep(2000);
		driver.navigate().to("https://www.facebook.com");
		driver.close();
	}
	@Test
	public static void forward() throws InterruptedException{
		b=new Base();
		b.Login();
		driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		Thread.sleep(2000);
		driver.navigate().to("https://www.youtube.com");
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name=\"search_query\"][1]")).sendKeys("Rajinikanth Songs");
		driver.findElement(By.xpath("//button[@aria-label=\"Search\"]/yt-icon")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id=\"video-title\"]")).click();
		Thread.sleep(20000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.close();
		
	}
}
